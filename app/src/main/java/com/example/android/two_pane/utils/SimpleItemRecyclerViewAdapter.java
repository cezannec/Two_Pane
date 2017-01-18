package com.example.android.two_pane.utils;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.two_pane.R;
import com.example.android.two_pane.fragments.AndroidSegmentFragment;
import com.example.android.two_pane.fragments.ViewPagerFragment;


import java.util.List;

/**
 * Created by cezannec on 1/11/17.
 */

public class SimpleItemRecyclerViewAdapter
        extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private FragmentManager mFragmentManager;
    private List<Integer> mResourceIds;

    private ViewPagerFragment vPager;

    public SimpleItemRecyclerViewAdapter(FragmentManager fm, List<Integer> items, ViewPagerFragment vp) {
        mResourceIds = items;
        mFragmentManager = fm;
        vPager = vp;
    }

    // set the list content
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        int id = mResourceIds.get(position);
        holder.mItem.setImageResource(id);
        //holder.mIdView.setText(mResourceIds.get(position).id);
        //holder.mContentView.setText(mResourceIds.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                // create a new instance of an AndroidSegmentFragment and set it's correct image resource
//                AndroidSegmentFragment fragment = new AndroidSegmentFragment();
//                fragment.setId(id);
//                Log.v("TAG", "Id clicked = " + id);
//
//
//                // replace old fragment
//                mFragmentManager.beginTransaction()
//                        .replace(R.id.test_container, fragment)
//                        .commit();


                // Update position of relevant view pager:
                // addess or clean up weird math

                int pos = holder.getAdapterPosition();

                Log.v("TAG", "position clicked = " + pos);
                int vPagerIndex = Math.round(pos/12);
                Log.v("TAG", "vpager index (0-2) = " + vPagerIndex);

                // modify position so that it suits the vPager clicked:
                pos = pos - 12*vPagerIndex;
                Log.v("NEW tag", "NEW position clicked = " + pos);

                if(vPager != null) {
                    //vPager.getViewPager(vPagerIndex).setCurrentItem(5);
                    vPager.getViewPager(vPagerIndex).setCurrentItem(pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResourceIds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView mIdView;
        //public final TextView mContentView;
        public ImageView mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mIdView = (TextView) view.findViewById(R.id.id);
            mItem = (ImageView) view.findViewById(R.id.image);
        }

    }
}
