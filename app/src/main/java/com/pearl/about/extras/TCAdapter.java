package com.pearl.about.extras;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pearl.about.R;

public class TCAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    String[] name;
    String[] desc;
    String UrlList[];
    Context context;
    int[] bgimage;
    int[] image;

    public TCAdapter(FragmentActivity Activity, String[] devname, String[] devdesc, int[] devbgImage, int[] devimage, String[] urllist) {
        name = devname;
        desc = devdesc;
        UrlList = urllist;
        bgimage = devbgImage;
        image = devimage;

        context = Activity;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.tccard_item, parent, false);

            holder = new Holder();
            holder.tv1 = convertView.findViewById(R.id.cardtitle);
            holder.tv2 = convertView.findViewById(R.id.carddescription);
            holder.img1 = convertView.findViewById(R.id.bgimage);
            holder.img2 = convertView.findViewById(R.id.cardimage);
            holder.tv1.setText(name[position]);
            holder.tv2.setText(desc[position]);
            holder.img1.setImageResource(bgimage[position]);
            holder.img2.setImageResource(image[position]);

            convertView.setTag(holder);

        } else {

            holder = (Holder) convertView.getTag();
        }

        CardView card = convertView.findViewById(R.id.cardView);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = UrlList[position];
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);
            }
        });

        return convertView;
    }

    public class Holder {
        TextView tv1;
        TextView tv2;
        ImageView img1;
        ImageView img2;
    }

}
