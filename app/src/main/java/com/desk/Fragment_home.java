package com.desk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kshitij.sharma on 9/28/2015.
 */
public class Fragment_home extends Fragment implements ActionBar.TabListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    static Context context;
    ActionBar actionBar;
    ViewPager viewPager;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment_home newInstance(int sectionNumber) {
        Fragment_home fragment = new Fragment_home();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_home() {
        System.out.println("created fragment home");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_actvity, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Adapter adapter = new Adapter(getChildFragmentManager());

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);


        for (int i = 0; i < adapter.getCount(); i++) {
            System.out.println("added new tab : " + i);
            actionBar.addTab(actionBar.newTab().setTabListener(this).setText(adapter.getPageTitle(i)));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomeActvity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
        actionBar = ((HomeActvity) activity).getSupportActionBar();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    private class Adapter extends FragmentPagerAdapter {

        public Adapter(FragmentManager fm) {
            super(fm);
            System.out.println("inside viewpager adapter get constructor");
        }

        @Override
        public Fragment getItem(int position) {
            System.out.println("inside viewpager adapter get item : " + position);
            return new Pager_fragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Section 1";
                case 1:
                    return "Section 2";
                case 2:
                    return "Section 3";
            }
            return null;
        }
    }
}
