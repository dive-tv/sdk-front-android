package com.touchvie.touchvie_front.ui.modules.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class CastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ImageRowData> rows;

    public CastAdapter(ArrayList<ImageRowData>rows){
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

    public static class CastItemHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;
        private TextView subtitle;

        public CastItemHolder(View v) {
            super(v);

        }
    }
}

