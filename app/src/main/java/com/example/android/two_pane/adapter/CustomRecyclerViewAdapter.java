package com.example.android.two_pane.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.two_pane.R;
import com.example.android.two_pane.ui.ViewPagersFragment;


import java.util.List;

/**
 * Created by cezannec on 1/11/17.
 */

public class CustomRecyclerViewAdapter
        extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder> {

    private List<Integer> mImageIds;
    private ViewPagersFragment mViewPagersFragment;

    public CustomRecyclerViewAdapter(List<Integer> imageIds, ViewPagersFragment viewPagersFragment) {
        mImageIds = imageIds;
        mViewPagersFragment = viewPagersFragment;
    }

    // Set the list content
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_side_list_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        // Set image resource based on position in list
        int id = mImageIds.get(position);
        holder.mItem.setImageResource(id);

        holder.mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update position of relevant view pager
                // First get the currently selected position of the selected item
                int clickedPosition = holder.getAdapterPosition();

                // If the ViewPagersFragment exists, update it so that it is at the currently
                //   selected position
                if(mViewPagersFragment != null) {
                    mViewPagersFragment.updateViewPager(clickedPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageIds.size();
    }


    // ViewHolder just holds one ImageView named item

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mItem;

        public ViewHolder(View view) {
            super(view);
            mItem = (ImageView) view.findViewById(R.id.image);
        }

    }
}
