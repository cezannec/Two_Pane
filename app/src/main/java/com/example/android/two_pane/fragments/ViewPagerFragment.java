package com.example.android.two_pane.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.two_pane.R;
import com.example.android.two_pane.utils.AndroidImageAssets;
import com.example.android.two_pane.utils.AndroidifyViewPagerAdapter;

public class ViewPagerFragment extends Fragment {

    ViewPager viewPagerHead;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // create three view pagers - one for each android segment
        // can mix the order of these up for entertaining effect
        viewPagerHead = (ViewPager) rootView.findViewById(R.id.headPager);
        ViewPager viewPagerBody = (ViewPager) rootView.findViewById(R.id.bodyPager);
        ViewPager viewPagerLegs = (ViewPager) rootView.findViewById(R.id.legPager);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        viewPagerHead.setAdapter(new AndroidifyViewPagerAdapter(fragmentManager, AndroidImageAssets.getHeads()));
        viewPagerBody.setAdapter(new AndroidifyViewPagerAdapter(fragmentManager, AndroidImageAssets.getBods()));
        viewPagerLegs.setAdapter(new AndroidifyViewPagerAdapter(fragmentManager, AndroidImageAssets.getLegs()));

        return rootView;
    }

    public void setCurrentItem(int pos) {
        viewPagerHead.setCurrentItem(pos);
    }


    //TODO: add share/save functionality?


}