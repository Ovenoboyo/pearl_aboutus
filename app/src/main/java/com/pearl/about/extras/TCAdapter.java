package com.pearl.about.extras;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pearl.about.R;

public class TCAdapter extends RecyclerView.Adapter<TCAdapter.ViewHolder> {

    private String[] tcMemberName, tcMemberDesc, uriArray;
    private Context context;
    private int[] tcMemberDp, tcMemberBg;
    private static LayoutInflater inflater = null;

    public TCAdapter(FragmentActivity Activity, String[] tcMemberName, String[] tcMemberDesc, int[] tcMemberDp, int[] tcMemberBg, String[] uriArray) {
        this.tcMemberName = tcMemberName;
        this.tcMemberDesc = tcMemberDesc;
        this.tcMemberDp = tcMemberDp;
        this.tcMemberBg = tcMemberBg;
        this.uriArray = uriArray;
        context = Activity;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.tccard_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tcMemberName.setText(tcMemberName[position]);
        holder.tcMemberDesc.setText(tcMemberDesc[position]);
        holder.tcMemberDp.setImageResource(tcMemberDp[position]);
        holder.tcMemberBg.setImageResource(tcMemberBg[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!uriArray[position].equals(""))
                    context.startActivity(new Intent(android.content.Intent.ACTION_VIEW)
                            .setData(Uri.parse(uriArray[position])));
                else
                    Toast.makeText(context.getApplicationContext(), "Nae Nae. Not Yet!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tcMemberName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tcMemberName, tcMemberDesc;
        public ImageView tcMemberDp, tcMemberBg;

        public ViewHolder(View itemView) {
            super(itemView);
            tcMemberName = itemView.findViewById(R.id.tcMemberName);
            tcMemberDesc = itemView.findViewById(R.id.tcMemberDesc);
            tcMemberDp = itemView.findViewById(R.id.tcMemberDp);
            tcMemberBg = itemView.findViewById(R.id.tcMemberBg);
        }
    }
}