package com.pearl.about.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

import static java.lang.Math.abs;


public class ZoomInTransformer implements ViewPager.PageTransformer {

    private float newpos;

    public ZoomInTransformer() {
    }

    @Override
    public void transformPage(View page, float position) {
        float Offset = 0.3084849f;
        if (position < 0) {
            newpos = position - Offset;
            //Log.d("pos", "position = " + LeftOffset);
        } else if (position > 0) {
            newpos = position - Offset;
        }
        float ScaleFactor = ((abs(newpos) + 1.3f) / (abs(newpos) + 1f));
        page.setScaleY(ScaleFactor);
        page.setScaleX(ScaleFactor);
    }
}
