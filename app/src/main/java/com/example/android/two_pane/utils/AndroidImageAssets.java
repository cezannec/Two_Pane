package com.example.android.two_pane.utils;


import com.example.android.two_pane.R;

import java.util.ArrayList;
import java.util.List;

// Util class for storing all the drawables in arraylists

public class AndroidImageAssets {

    private static final List<Integer> heads = new ArrayList<Integer>() {{
        add(R.drawable.head1);
        add(R.drawable.head2);
        add(R.drawable.head3);
        add(R.drawable.head4);
        add(R.drawable.head5);
        add(R.drawable.head6);
        add(R.drawable.head7);
        add(R.drawable.head8);
        add(R.drawable.head9);
        add(R.drawable.head10);
        add(R.drawable.head11);
        add(R.drawable.head12);
    }};

    private static final List<Integer> bods = new ArrayList<Integer>() {{
        add(R.drawable.body1);
        add(R.drawable.body2);
        add(R.drawable.body3);
        add(R.drawable.body4);
        add(R.drawable.body5);
        add(R.drawable.body6);
        add(R.drawable.body7);
        add(R.drawable.body8);
        add(R.drawable.body9);
        add(R.drawable.body10);
        add(R.drawable.body11);
        add(R.drawable.body12);
    }};

    private static final List<Integer> legs = new ArrayList<Integer>() {{
        add(R.drawable.legs1);
        add(R.drawable.legs2);
        add(R.drawable.legs3);
        add(R.drawable.legs4);
        add(R.drawable.legs5);
        add(R.drawable.legs6);
        add(R.drawable.legs7);
        add(R.drawable.legs8);
        add(R.drawable.legs10);
        add(R.drawable.legs11);
        add(R.drawable.legs12);
    }};


    // Getter methods

    public static List<Integer> getHeads() {
        return heads;
    }

    public static List<Integer> getBods() {
        return bods;
    }

    public static List<Integer> getLegs() {
        return legs;
    }
}
