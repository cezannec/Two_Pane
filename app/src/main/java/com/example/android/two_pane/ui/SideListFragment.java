package com.example.android.two_pane.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.two_pane.R;
import com.example.android.two_pane.data.AndroidImageAssets;
import com.example.android.two_pane.adapter.CustomRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cezannec on 1/11/17.
 */

public class SideListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_side_list, container, false);

        // Set up the Master list RecyclerView that holds all the Android-Me images
        RecyclerView headRecView= (RecyclerView) rootView.findViewById(R.id.all_images_list);


        // Create a list of ALL images (all heads, bodies, and legs) to populate the RecyclerView
        List<Integer> allImageIds = new ArrayList<>();
        allImageIds.addAll(AndroidImageAssets.getHeads());
        allImageIds.addAll(AndroidImageAssets.getBods());
        allImageIds.addAll(AndroidImageAssets.getLegs());

        // Find the main ViewPagersFragment that this Master list will end up affecting
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ViewPagersFragment viewPagersFragment = (ViewPagersFragment) fragmentManager.findFragmentById(R.id.main_panel);

        // Set the custom adapter and GridLayoutManager to display all the images in a grid
        headRecView.setAdapter(new CustomRecyclerViewAdapter(allImageIds, viewPagersFragment));
        headRecView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return rootView;
    }
}
