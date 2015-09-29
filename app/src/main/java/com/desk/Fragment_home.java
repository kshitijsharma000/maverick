package com.desk;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kshitij.sharma on 9/28/2015.
 */
public class Fragment_home extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    static Context context;
    ActionBar actionBar;
    ViewPager viewPager;
    View view;

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
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
