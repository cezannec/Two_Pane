package com.example.android.two_pane.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android.two_pane.fragments.AndroidMeImageFragment;

import java.util.List;

public class AndroidifyViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Integer> mImageIds;

    public AndroidifyViewPagerAdapter(FragmentManager fm, List<Integer> imageIds) {
        super(fm);
        mImageIds = imageIds;
    }

    @Override
    public Fragment getItem(int position) {
        // Create a new instance of an AndroidMeImageFragment
        AndroidMeImageFragment imageFragment = new AndroidMeImageFragment();

        // Set the correct image resource for the fragment (by calling on setter method)
        int id = mImageIds.get(position);
        imageFragment.setId(id);

        return imageFragment;
    }

    // Returns the number of items held in the ViewPager
    @Override
    public int getCount() {
        return mImageIds.size();
    }

}
