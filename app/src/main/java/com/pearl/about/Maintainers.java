package com.pearl.about;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;


public class Maintainers extends PreferenceActivity {


    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_maintainers);

        PreferenceCategory maintainers = (PreferenceCategory) findPreference("maintainers");
        final String[] maintainers_title = getResources().getStringArray(R.array.maintainers_title);
        final String[] maintainers_devices = getResources().getStringArray(R.array.maintainers_devices);
        final String[] maintainers_url = getResources().getStringArray(R.array.maintainers_url);
        for (int i = 0; i < maintainers_title.length; i++) {
            Preference maintainer = new Preference(this);
            final String maintainer_url = maintainers_url[i];
            maintainer.setIcon(R.drawable.ic_devs_phone);
            maintainer.setTitle(maintainers_title[i]);
            maintainer.setSummary(String.format(getString(R.string.maintainer_description), maintainers_devices[i]));
            maintainer.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(maintainer_url)));
                    return true;
                }
            });
            maintainers.addPreference(maintainer);
        }
    }
}
