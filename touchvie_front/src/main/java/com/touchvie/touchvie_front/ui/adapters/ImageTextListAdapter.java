package com.touchvie.touchvie_front.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class ImageTextListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ImageRowData> rows;

    public ImageTextListAdapter(ArrayList<ImageRowData> rows){
        super();
        this.rows=rows;
    }

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

    public static class ImageTextItemHolder extends RecyclerView.ViewHolder {

        ImageView image;

        TextView title;

        TextView subtitle;

        public ImageTextItemHolder(View v) {
            super(v);

        }
    }

}

