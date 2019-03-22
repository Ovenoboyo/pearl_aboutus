package com.pearl.about.extras;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.pearl.about.R;

public class Extras extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.extras);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    //#1
    public static class TCFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private final String LOG_TAG = TCFragment.class.getSimpleName();

        private ArrayAdapter<String> listAdapter;

        public TCFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static TCFragment newInstance(int sectionNumber) {
            TCFragment fragment = new TCFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String listArray1[] = getResources().getStringArray(R.array.testers_title);

            String listArray2[] = getResources().getStringArray(R.array.testers_devices);

            String UrlList[] = getResources().getStringArray(R.array.testers_url);

            int bgimageArray[] = new int[]{
                    R.drawable.tester1_bg,
                    R.drawable.tester2_bg,
                    R.drawable.tester3_bg,
                    //R.drawable.tester4_bg,
                    R.drawable.tester5_bg,
                    R.drawable.tester6_bg
            };

            int imageArray[] = new int[]{
                    R.drawable.tester1,
                    R.drawable.tester2,
                    R.drawable.tester3,
                    //R.drawable.tester4,
                    R.drawable.tester5,
                    R.drawable.tester6
            };

            final int pos = getArguments().getInt(ARG_SECTION_NUMBER);
            Log.d(LOG_TAG, Integer.toString(pos));

            RecyclerView recyclerView = rootView.findViewById(R.id.tcListView);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(new TCAdapter(getActivity(), listArray1, listArray2, imageArray, bgimageArray, UrlList));
            recyclerView.setNestedScrollingEnabled(true);
            Log.d(LOG_TAG, "DONE");
            return rootView;
        }
    }

    //#2
    public static class MaintainerFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private final String LOG_TAG = Extras.TCFragment.class.getSimpleName();

        private ArrayAdapter<String> listAdapter;

        public MaintainerFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static MaintainerFragment newInstance(int sectionNumber) {
            MaintainerFragment fragment = new MaintainerFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String listArray1[] = getResources().getStringArray(R.array.maintainers_title);

            String listArray2[] = getResources().getStringArray(R.array.maintainers_devices);

            String UrlList[] = getResources().getStringArray(R.array.maintainers_url);

            int bgimageArray[] = new int[]{
                    R.drawable.maintainer2_bg,
                    R.drawable.maintainer3_bg,
                    R.drawable.maintainer4_bg,
                    //R.drawable.maintainer5_bg,
                    R.drawable.maintainer6_bg,
                    R.drawable.maintainer7_bg

            };

            int imageArray[] = new int[]{
                    R.drawable.maintainer2,
                    R.drawable.maintainer3,
                    R.drawable.maintainer4,
                    //R.drawable.maintainer5,
                    R.drawable.maintainer6,
                    R.drawable.maintainer7
            };

            int pos = getArguments().getInt(ARG_SECTION_NUMBER);
            Log.d(LOG_TAG, Integer.toString(pos));

            RecyclerView recyclerView = rootView.findViewById(R.id.tcListView);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(new TCAdapter(getActivity(), listArray1, listArray2, imageArray, bgimageArray, UrlList));
            recyclerView.setNestedScrollingEnabled(true);
            Log.d(LOG_TAG, "DONE");
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TCFragment.newInstance(position + 1);
                case 1:
                    return MaintainerFragment.newInstance(position + 1);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Testers";
                case 1:
                    return "Maintainers";
            }
            return null;
        }
    }
}