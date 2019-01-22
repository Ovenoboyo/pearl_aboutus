package com.pearl.about.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pearl.about.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DialogView extends DialogFragment {

    int DialogId;
    String github, telegram, xdalink;

    public DialogView() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        DialogId = bundle.getInt("ID");
        github = bundle.getString("github");
        telegram = bundle.getString("telegram");
        xdalink = bundle.getString("xdalink");

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ViewGroup nullParent = null;
        View view = null;
        if (inflater != null) {
            view = inflater.inflate(DialogId, nullParent);
        }

        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(false);
        final AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();

        ImageView git = null;
        ImageView tg = null;
        ImageView xda = null;
        CircleImageView oveno = null;

        if (view != null) {
            git = view.findViewById(R.id.github);
            tg = view.findViewById(R.id.telegram);
            xda = view.findViewById(R.id.xda);
            oveno = view.findViewById(R.id.ovenicon);

        }

        if (git != null && tg != null && xda != null) {
            git.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setLink(github);
                }
            });

            tg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setLink(telegram);
                }
            });

            xda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setLink(xdalink);
                }
            });

        }

        if (oveno != null) {
            oveno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TriggerEasterEgg();
                }
            });
        }

        return dialog;
    }

    @Override
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);

        }
        super.onDestroyView();
    }

    private void setLink(final String link) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://" + link));
        startActivity(intent);
    }

    private void TriggerEasterEgg() {

    }


}
