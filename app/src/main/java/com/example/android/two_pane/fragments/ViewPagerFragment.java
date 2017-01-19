package com.example.android.two_pane.fragments;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.two_pane.R;
import com.example.android.two_pane.utils.AndroidImageAssets;
import com.example.android.two_pane.utils.AndroidifyViewPagerAdapter;
import com.example.android.two_pane.utils.SaveBitmapImageHelper;

public class ViewPagerFragment extends Fragment {

    ViewPager viewPagerHead;
    ViewPager viewPagerBody;
    ViewPager viewPagerLegs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Create three view pagers - one for each Android-Me body part
        // You can mix the order of these up for an entertaining effect
        viewPagerHead = (ViewPager) rootView.findViewById(R.id.headPager);
        viewPagerBody = (ViewPager) rootView.findViewById(R.id.bodyPager);
        viewPagerLegs = (ViewPager) rootView.findViewById(R.id.legPager);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        viewPagerHead.setAdapter(new AndroidifyViewPagerAdapter(fragmentManager, AndroidImageAssets.getHeads()));
        viewPagerBody.setAdapter(new AndroidifyViewPagerAdapter(fragmentManager, AndroidImageAssets.getBods()));
        viewPagerLegs.setAdapter(new AndroidifyViewPagerAdapter(fragmentManager, AndroidImageAssets.getLegs()));

        createSaveButton(rootView, viewPagerHead, viewPagerBody, viewPagerLegs);

        return rootView;
    }

    // This method retrieves a specific ViewPager in this fragment
    // This will allow for communication between this fragment and the Master list
    public ViewPager getViewPager(int vp) {
        switch(vp) {
            case 0: return viewPagerHead;
            case 1: return viewPagerBody;
            case 2: return viewPagerLegs;
            default: return null;
        }
    }

    // Save functionality
    private void createSaveButton(View rootView, final ViewPager viewPagerHead, final ViewPager viewPagerBody, final ViewPager viewPagerLegs) {
        Button saveButton = (Button) rootView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer heads = AndroidImageAssets.getHeads().get(viewPagerHead.getCurrentItem());
                Integer bods = AndroidImageAssets.getBods().get(viewPagerBody.getCurrentItem());
                Integer legs = AndroidImageAssets.getLegs().get(viewPagerLegs.getCurrentItem());

                // Combine all three images in one Bitmap image
                Bitmap bitmap = SaveBitmapImageHelper.combineDrawables(getResources(), heads, bods, legs);

                // TODO: check if you have write permission? see if I can force this in Manifest
                // If you do not have permission, request it
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);

                // Save through the media content resolver
                MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), bitmap, "Custom Android", null);
            }
        });
    }
}