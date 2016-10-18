package com.touchvie.touchvie_front.ui.modules.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class SeasonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ImageRowData> rows;

    public SeasonsAdapter(ArrayList<ImageRowData> rows){
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


    public static class RectangularImageItemsItemHolder extends RecyclerView.ViewHolder {

        ImageView image;

        TextView title;

        TextView subtitle;


        public RectangularImageItemsItemHolder(View v) {
            super(v);

        }
    }


}



