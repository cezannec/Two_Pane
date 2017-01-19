package com.example.android.two_pane.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.two_pane.R;


// These fragments are paged through using a view pager
// Their contents are defined by an image id

public class AndroidMeImageFragment extends Fragment {

    // Keep track of image resource with class variables
    public static final String IMG_ID = "IMG_ID";
    private int mImageId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Load current image resource id if it exists
        if (savedInstanceState != null) {
            mImageId = savedInstanceState.getInt(IMG_ID);
        }

        // Inflate the Android-Me image segment, populating it with an image based on it's resource id
        View rootView = inflater.inflate(R.layout.fragment_androidme_image, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.androidme_image);

        // Set the currently selected image resource id
        imageView.setImageResource(mImageId);

        // Return the root view
        return rootView;
    }


    // Save current image resource id
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putInt(IMG_ID, mImageId);
    }


    // This is a "setter" method that gives us a way to update the id from the adapter class
    public void setId(int id) {
        this.mImageId = id;
    }

}
