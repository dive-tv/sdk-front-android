package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.TextRowData;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class CuriositiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<TextRowData> rows;
    private Typeface latoSemibold;

    public CuriositiesAdapter(Context context, ArrayList<TextRowData> rows){
        super();
        this.rows=rows;
        latoSemibold = Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.curiosity_row, parent, false);
        return new CuriositiesAdapter.CuriositiesItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final TextRowData row= rows.get(position);
        ((CuriositiesAdapter.CuriositiesItemHolder) holder).text.setText(row.getText());
        ((CuriositiesAdapter.CuriositiesItemHolder) holder).text.setTypeface(latoSemibold);
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public static class CuriositiesItemHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public CuriositiesItemHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.curiosity_text);
        }
    }
}
