package com.desk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kshitij.sharma on 9/28/2015.
 */
public class Fragment_credits extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Context context;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment_credits newInstance(int sectionNumber) {
        Fragment_credits fragment = new Fragment_credits();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_credits() {
        System.out.println("created fragment credits");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_credits, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

}
