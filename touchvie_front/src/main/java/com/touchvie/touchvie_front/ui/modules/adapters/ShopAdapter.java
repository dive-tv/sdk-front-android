package com.touchvie.touchvie_front.ui.modules.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.touchvie.touchvie_front.ui.modules.data.ShopRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ShopRowData> rows;

    public ShopAdapter(ArrayList<ShopRowData> data){
        this.rows=data;
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

    public static class ShopItemHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView price;
        private ImageView showNow;
        private TextView shop;

        public ShopItemHolder(View v) {
            super(v);

        }
    }

}

