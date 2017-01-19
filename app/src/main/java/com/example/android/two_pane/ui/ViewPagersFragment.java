package com.example.android.two_pane.ui;

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
import com.example.android.two_pane.data.AndroidImageAssets;
import com.example.android.two_pane.adapter.AndroidMeViewPagerAdapter;
import com.example.android.two_pane.util.SaveBitmapImageHelper;

public class ViewPagersFragment extends Fragment {

    ViewPager viewPagerHead;
    ViewPager viewPagerBody;
    ViewPager viewPagerLegs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_viewpagers, container, false);

        // Create three view pagers - one for each Android-Me body part
        // You can mix the order of these up for an entertaining effect
        viewPagerHead = (ViewPager) rootView.findViewById(R.id.headPager);
        viewPagerBody = (ViewPager) rootView.findViewById(R.id.bodyPager);
        viewPagerLegs = (ViewPager) rootView.findViewById(R.id.legPager);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        viewPagerHead.setAdapter(new AndroidMeViewPagerAdapter(fragmentManager, AndroidImageAssets.getHeads()));
        viewPagerBody.setAdapter(new AndroidMeViewPagerAdapter(fragmentManager, AndroidImageAssets.getBods()));
        viewPagerLegs.setAdapter(new AndroidMeViewPagerAdapter(fragmentManager, AndroidImageAssets.getLegs()));

        createSaveButton(rootView, viewPagerHead, viewPagerBody, viewPagerLegs);

        return rootView;
    }


    // This will allow for communication and updating between this fragment and the Master list
    public void updateViewPager(int currentPosition) {

        // Using the fact that there are 12 of each head, body, and leg images, we can identify the
        //   correct ViewPager that they are linked to based on the currentPosition/12
        // (This also rounds down to the nearest int)
        int viewPagerIndex = currentPosition/12;

        // Modify the position so that it falls in the range of items in each ViewPager
        currentPosition = currentPosition - 12*viewPagerIndex;

        // Set the currently displayed item in the ViewPager
        getViewPager(viewPagerIndex).setCurrentItem(currentPosition);
    }

    // This method retrieves a specific ViewPager in this fragment
    public ViewPager getViewPager(int vp) {
        switch(vp) {
            case 0: return viewPagerHead;
            case 1: return viewPagerBody;
            case 2: return viewPagerLegs;
            default: return null;
        }
    }

    // Save image functionality
    private void createSaveButton(View rootView, final ViewPager viewPagerHead, final ViewPager viewPagerBody, final ViewPager viewPagerLegs) {
        Button saveButton = (Button) rootView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer heads = AndroidImageAssets.getHeads().get(viewPagerHead.getCurrentItem());
                Integer bods = AndroidImageAssets.getBods().get(viewPagerBody.getCurrentItem());
                Integer legs = AndroidImageAssets.getLegs().get(viewPagerLegs.getCurrentItem());

                // Combine all three images in one Bitmap image
                Bitmap bitmap = SaveBitmapImageHelper.combineSelectedImages(getResources(), heads, bods, legs);

                // This line asks for permission to write to the image gallery, which is external storage
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);

                // Save through the media ContentResolver
                MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), bitmap, "Custom Android", null);
            }
        });
    }
}