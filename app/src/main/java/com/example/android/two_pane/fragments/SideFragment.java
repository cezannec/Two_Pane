package com.example.android.two_pane.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

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

        RecyclerView headRecView= (RecyclerView) rootView.findViewById(R.id.head_list);

       // RecyclerView bodyRecView= (RecyclerView) rootView.findViewById(R.id.bod_list);
//        final RecyclerView legsRecView= (RecyclerView) rootView.findViewById(R.id.legs_list);



        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //set adapter and grid view

        //head view pager..
        ViewPagerFragment vp = (ViewPagerFragment) fragmentManager.findFragmentById(R.id.main_panel);
        //ViewPager vPager = vp.viewPagerHead;

        Log.v("Side Frag", "Activity : "+ (getActivity().getLocalClassName()));
        Log.v("Side Frag", "view pager, y/n ? "+ (vp != null));

        headRecView.setAdapter(new SimpleItemRecyclerViewAdapter(fragmentManager, AndroidImageAssets.getHeads(), vp));
        headRecView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        //bodyRecView.setAdapter(new SimpleItemRecyclerViewAdapter(fragmentManager, AndroidImageAssets.getBods(), vp));
//        bodyRecView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//
//        legsRecView.setAdapter(new SimpleItemRecyclerViewAdapter(fragmentManager, AndroidImageAssets.getLegs()));
//        legsRecView.setLayoutManager(new GridLayoutManager(getActivity(), 3));


        //SAME as above but with GridView **
        //GridView headGridView = (GridView) rootView.findViewById(R.id.head_list);



        return rootView;
    }
}
