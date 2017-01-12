package com.example.android.two_pane.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.two_pane.R;
import com.example.android.two_pane.utils.AndroidImageAssets;
import com.example.android.two_pane.utils.AndroidifyViewPagerAdapter;
import com.example.android.two_pane.utils.SimpleItemRecyclerViewAdapter;

/**
 * Created by cezannec on 1/11/17.
 */

public class SideFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_side, container, false);

        // set up three diff recycler views

        final RecyclerView headRecView= (RecyclerView) rootView.findViewById(R.id.head_list);
//        final RecyclerView bodyRecView= (RecyclerView) rootView.findViewById(R.id.body_list);
//        final RecyclerView legsRecView= (RecyclerView) rootView.findViewById(R.id.legs_list);


        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //set adapter and grid view
        headRecView.setAdapter(new SimpleItemRecyclerViewAdapter(fragmentManager, AndroidImageAssets.getHeads()));
        headRecView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

//        bodyRecView.setAdapter(new SimpleItemRecyclerViewAdapter(fragmentManager, AndroidImageAssets.getBods()));
//        bodyRecView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//
//        legsRecView.setAdapter(new SimpleItemRecyclerViewAdapter(fragmentManager, AndroidImageAssets.getLegs()));
//        legsRecView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return rootView;
    }
}
