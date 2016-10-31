package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.TwoTextRowData;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SoundtrackAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<TwoTextRowData> rows;
    private Typeface latoRegular;
    private Typeface latoSemibold;

    public SoundtrackAdapter(Context context, ArrayList<TwoTextRowData> rows){
        super();
        this.rows=rows;
        latoRegular = Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR);
        latoSemibold = Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.soundtrack_row, parent, false);
        return new SoundtrackAdapter.SoundtrackItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final TwoTextRowData row= rows.get(position);
        ((SoundtrackAdapter.SoundtrackItemHolder) holder).title.setText(row.getText());
        ((SoundtrackAdapter.SoundtrackItemHolder) holder).title.setTypeface(latoSemibold);
        ((SoundtrackAdapter.SoundtrackItemHolder) holder).author.setText(row.getSubtitle());
        ((SoundtrackAdapter.SoundtrackItemHolder) holder).author.setTypeface(latoRegular);
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public static class SoundtrackItemHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView author;

        public SoundtrackItemHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.soundtrack_title);
            author = (TextView) v.findViewById(R.id.soundtrack_author);
        }
    }
}
