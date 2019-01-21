package com.pearl.about;

import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import static java.lang.Math.abs;


public class ZoomInTransformer implements ViewPager.PageTransformer {

    float offset;
    private float newpos;
    private float RighttOffset;
    private float LeftOffset;

    public ZoomInTransformer() {
    }

    @Override
    public void transformPage(View page, float position) {
        offset = 0.03030309f;
        newpos = position + offset;
        RighttOffset = 0.3084849f;
        LeftOffset = 0.3084849f;
        if (position < 0) {
            newpos = position - LeftOffset;
            //Log.d("pos", "position = " + LeftOffset);
        } else if (position > 0) {
            newpos = position - RighttOffset;
        }
        float ScaleFactor = ((abs(newpos) + 1.3f)/(abs(newpos) + 1f));
        page.setScaleY(ScaleFactor);
        page.setScaleX(ScaleFactor);
    }
}
