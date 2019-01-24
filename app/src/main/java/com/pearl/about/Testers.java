package com.pearl.about;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.view.Window;
import android.view.WindowManager;


public class Testers extends PreferenceActivity {


    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addPreferencesFromResource(R.xml.activity_testers);

        PreferenceCategory testers = (PreferenceCategory) findPreference("testers");
        final String[] testers_title = getResources().getStringArray(R.array.testers_title);
        final String[] testers_devices = getResources().getStringArray(R.array.testers_devices);
        String[] testers_url = getResources().getStringArray(R.array.testers_url);
        for (int i = 0; i < testers_title.length; i++) {
            Preference tester = new Preference(this);
            final String tester_url = testers_url[i];
            tester.setIcon(R.drawable.ic_devs_phone);
            tester.setTitle(testers_title[i]);
            tester.setSummary(String.format(getString(R.string.tester_description), testers_devices[i]));
            tester.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(tester_url)));
                    return true;
                }
            });
            testers.addPreference(tester);
        }
    }
}