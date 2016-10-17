package com.touchvie.touchvie_front.ui.modules.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.touchvie.touchvie_front.ui.modules.data.TextRowData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class CuriositiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<TextRowData> rows;

    public CuriositiesAdapter(ArrayList<TextRowData> rows){

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

    public static class CuriositiesItemHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public CuriositiesItemHolder(View v) {
            super(v);

        }
    }
}
