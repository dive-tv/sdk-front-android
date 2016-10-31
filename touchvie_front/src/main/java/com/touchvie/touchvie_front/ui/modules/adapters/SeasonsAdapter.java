package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.SeasonRowData;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class SeasonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<SeasonRowData> rows;
    private Picasso mPicasso;
    private Typeface latoRegular;
    private Typeface latoSemibold;


    public SeasonsAdapter(Context context, ArrayList<SeasonRowData> rows){
        super();
        this.rows=rows;
        mPicasso = Picasso.with(context);
        latoRegular = Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR);
        latoSemibold = Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.season_item_row, parent, false);
        return new SeasonsAdapter.SeasonsItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mPicasso.load(rows.get(position).getImage())
                .into(((SeasonsAdapter.SeasonsItemHolder) holder).image);
        final SeasonRowData row= rows.get(position);
        ((SeasonsAdapter.SeasonsItemHolder) holder).year.setText(row.getYear());
        ((SeasonsAdapter.SeasonsItemHolder) holder).year.setTypeface(latoRegular);
        ((SeasonsItemHolder) holder).season.setText(row.getSeason());
        ((SeasonsAdapter.SeasonsItemHolder) holder).season.setTypeface(latoSemibold);

    }

    @Override
    public int getItemCount() {
        return rows.size();
    }


    public static class SeasonsItemHolder extends RecyclerView.ViewHolder {

        ImageView image;

        TextView year;

        TextView season;


        public SeasonsItemHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.season_image);
            year = (TextView) v.findViewById(R.id.season_year);
            season = (TextView) v.findViewById(R.id.season_season);
        }
    }


}



