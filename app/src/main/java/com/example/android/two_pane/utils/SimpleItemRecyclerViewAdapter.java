package com.example.android.two_pane.utils;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.two_pane.R;
import com.example.android.two_pane.fragments.ViewPagerFragment;


import java.util.List;

/**
 * Created by cezannec on 1/11/17.
 */

public class SimpleItemRecyclerViewAdapter
        extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private List<Integer> mImageIds;
    private ViewPagerFragment mViewPagerFragment;

    public SimpleItemRecyclerViewAdapter(List<Integer> imageIds, ViewPagerFragment viewPagerFragment) {
        mImageIds = imageIds;
        mViewPagerFragment = viewPagerFragment;
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

        int id = mImageIds.get(position);
        holder.mItem.setImageResource(id);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Update position of relevant view pager:
                // address or clean up weird math

                int pos = holder.getAdapterPosition();

                Log.v("TAG", "position clicked = " + pos);
                int vPagerIndex = Math.round(pos/12);
                Log.v("TAG", "vpager index (0-2) = " + vPagerIndex);

                // modify position so that it suits the mViewPagerFragment clicked:
                pos = pos - 12*vPagerIndex;
                Log.v("NEW tag", "NEW position clicked = " + pos);

                if(mViewPagerFragment != null) {
                    mViewPagerFragment.getViewPager(vPagerIndex).setCurrentItem(pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageIds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public ImageView mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItem = (ImageView) view.findViewById(R.id.image);
        }

    }
}
