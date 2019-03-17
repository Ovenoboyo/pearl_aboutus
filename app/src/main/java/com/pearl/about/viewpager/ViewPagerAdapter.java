package com.pearl.about.viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pearl.about.R;
import com.pearl.about.extras.Extras;
import com.pearl.about.fragments.DialogView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewPagerAdapter extends PagerAdapter {

    FragmentManager fm;
    Bundle bundl;
    private List<ViewPagerContainer> contents;
    private Context mContext;
    private Intent i = null;


    public ViewPagerAdapter(List<ViewPagerContainer> contents, Context mContext, FragmentManager fm) {
        this.contents = contents;
        this.mContext = mContext;
        this.fm = fm;
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
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
                        showDialog(R.drawable.dev1, "github.com/sagarrokade006", "t.me/sagarrokade006", "forum.xda-developers.com/member.php?u=7312263", mContext.getString(R.string.dev_desc1));
                        break;

                    case 1:
                        showDialog(R.drawable.dev2, "github.com/Dixzz", "t.me/Shatyam", "forum.xda-developers.com/member.php?u=6795851", mContext.getString(R.string.dev_desc2));
                        break;

                    case 2:
                        showDialog(R.drawable.dev3, "github.com/Ovenoboyo", "t.me/ovenoboyo", "forum.xda-developers.com/member.php?u=6152318", mContext.getString(R.string.dev_desc3));
                        break;

                    case 3:
                        showDialog(R.drawable.dev4, "gitHub.com/beingmishra", " t.me/beingmishra", "duck.com", mContext.getString(R.string.dev_desc4));
                        break;

                    case 4:
                        showDialog(R.drawable.dev8, "github.com/AryanKedare", "t.me/aryankedare", "forum.xda-developers.com/member.php?u=6537039", mContext.getString(R.string.dev_desc8));
                        break;

                    case 5:
                        showDialog(R.drawable.dev5, "github.com/czynot", "t.me/Void_Aspect", "forum.xda-developers.com/member.php?u=9342352", mContext.getString(R.string.dev_desc5));
                        break;

                    case 6:
                        showDialog(R.drawable.dev6, "github.com/Nparte777", "t.me/nparte77", "www.youtube.com/channel/UC-lHJZR3Gqxm24_Vd_AJ5Yw?sub_confirmation=1", mContext.getString(R.string.dev_desc6));
                        break;

                    case 7:
                        showDialog(R.drawable.tester1, "github.com/billouetaudrey", "t.me/billouetaudrey", "forum.xda-developers.com/member.php?u=1168585", mContext.getString(R.string.billou_desc));
                        break;

                    case 8:
                        if (i == null) {
                            i = new Intent(mContext, Extras.class);
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

        container.removeView((View) object);
    }

    private void showDialog(int img, String github, String telegram, String xdalink, String desc) {
        bundl = new Bundle();
        bundl.putInt("img", img);
        bundl.putString("github", github);
        bundl.putString("telegram", telegram);
        bundl.putString("xdalink", xdalink);
        bundl.putString("desc", desc);
        DialogFragment newFragment = new DialogView();
        newFragment.setArguments(bundl);
        newFragment.show(fm, "dialog");
    }
}
