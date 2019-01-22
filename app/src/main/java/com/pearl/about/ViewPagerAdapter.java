package com.pearl.about;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewPagerAdapter extends PagerAdapter {

    private List<ViewPagerContainer> contents;
    private Context mContext;
    private Intent i = null;


    public ViewPagerAdapter(List<ViewPagerContainer> contents, Context mContext) {
        this.contents = contents;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return contents.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.pager_contents, container, false);

        container.addView(view);

        CircleImageView imageview = view.findViewById(R.id.icon);
        imageview.setImageResource((contents.get(position).getIcon()));

        TextView cat = view.findViewById(R.id.category);
        cat.setText(contents.get(position).getCat());

        TextView desc = view.findViewById(R.id.desc);
        desc.setText(contents.get(position).getDesc());

        FloatingActionButton fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        showDialog(mContext, R.layout.dialog0);
                        break;

                    case 1:
                        showDialog(mContext, R.layout.dialog1);
                        break;

                    case 2:
                        showDialog(mContext, R.layout.dialog2);
                        break;

                    case 3:
                        showDialog(mContext, R.layout.dialog3);
                        break;

                    case 4:
                        showDialog(mContext, R.layout.dialog4);
                        break;

                    case 5:
                        showDialog(mContext, R.layout.dialog5);
                        break;

                    case 6:
                        showDialog(mContext, R.layout.dialog6);
                        break;


                    case 7:
                        if (i == null) {
                            i = new Intent(mContext, Maintainers.class);
                            mContext.startActivity(i);
                        }
                        i = null;
                        break;

                    case 8:
                        if (i == null) {
                            i = new Intent(mContext, Testers.class);
                            mContext.startActivity(i);
                        }
                        i = null;
                        break;

                    default:
                        break;
                }
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);

        container.removeView((View)object);
    }

    private static void showDialog(Context context, int id) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context );

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(id, null);

        alertDialogBuilder.setView(dialogView);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
