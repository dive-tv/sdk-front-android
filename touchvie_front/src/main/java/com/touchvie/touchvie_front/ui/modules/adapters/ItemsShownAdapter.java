package com.touchvie.touchvie_front.ui.modules.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class ItemsShownAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ItemsShownItemHolder extends RecyclerView.ViewHolder {

        public ItemsShownItemHolder(View v) {
            super(v);

        }
    }
}


