package com.example.android.two_pane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.two_pane.fragments.SideFragment;

public class MainActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.side_panel) != null) {
            // The side panel view will be present only in the large-screen, landscape layouts
            // (res/layout-sw600dp-land)
            // If present --> the layout should show two panes
            mTwoPane = true;
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.side_panel, new SideFragment(), "Temp tag")
                        .commit();
            }
        } else {
            mTwoPane = false;
        }

    }
}
