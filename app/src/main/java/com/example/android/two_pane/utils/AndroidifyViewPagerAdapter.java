package com.example.android.two_pane.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.android.two_pane.R;
import com.example.android.two_pane.fragments.AndroidSegmentFragment;

import java.util.List;

public class AndroidifyViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Integer> resourceIds;


    public AndroidifyViewPagerAdapter(FragmentManager fm, List<Integer> ids) {
        super(fm);
        //fragmentManager = fm;
        this.resourceIds = ids;
    }

    @Override
    public Fragment getItem(int position) {
        // create a new instance of an AndroidSegmentFragment and set it's correct image resource
        AndroidSegmentFragment frag = new AndroidSegmentFragment();

        // set image resource for the fragment (by calling on setter method)
        int id = resourceIds.get(position);
        frag.setId(id);

        return frag;
    }

    @Override
    public int getCount() {
        return resourceIds.size();
    }

    // Update position in view adapter
    @Override
    public int getItemPosition(Object item) {
        AndroidSegmentFragment fragment = (AndroidSegmentFragment) item;
        int id = fragment.getResId();
        int position = resourceIds.indexOf(id);

        Log.v("In ViewPagerAdapter", "position = " + position);
        if (position >= 0) {
            return position;
        } else {
            return super.getItemPosition(item);
        }
    }
}
