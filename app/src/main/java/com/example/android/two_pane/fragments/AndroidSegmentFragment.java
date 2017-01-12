package com.example.android.two_pane.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.two_pane.R;


// These fragments are paged through using a view pager
// Their contents are defined by an image id

public class AndroidSegmentFragment extends Fragment {

    public static final String RESOURCE_ID = "IMG_ID";

    // keep track of image resource
    private int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // load current resource id if it exists
        if (savedInstanceState != null) {
            id = savedInstanceState.getInt(RESOURCE_ID);
        }

        // inflating the android segment, populating it with an image based on it's resource id
        View rootView = inflater.inflate(R.layout.fragment_android_segment, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.android_segment);

        // set the currently selected image resource id
        imageView.setImageResource(id);


        // return the root view
        return rootView;
    }


    // save current image resource id
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putInt(RESOURCE_ID, id);
    }


    // need a way to update the id from the adapter class, so define a setter method:

    public void setId(int id) {
        this.id = id;
    }

    public int getResId() {
        return id;
    }

}
