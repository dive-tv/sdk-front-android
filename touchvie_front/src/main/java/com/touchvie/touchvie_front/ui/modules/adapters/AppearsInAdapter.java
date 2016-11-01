package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.ImageTextsRowData;
import com.touchvie.touchvie_front.ui.modules.data.TextRowData;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public class AppearsInAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ImageTextsRowData> rows;
    private Context context;
    private Typeface latoRegular;
    private Typeface latoSemibold;
    private Picasso mPicasso;

    public AppearsInAdapter(Context context, ArrayList<ImageTextsRowData> rows){

        super();
        this.rows=rows;
        this.context=context;
        mPicasso = Picasso.with(context);
        latoRegular = Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR);
        latoSemibold = Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.appears_in_row, parent, false);
        return new AppearsInAdapter.AppearsInItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ImageTextsRowData row= rows.get(position);
        if(row.getImage()!=null){
            mPicasso.load(row.getImage())
                    .into(((AppearsInAdapter.AppearsInItemHolder) holder).image);
        }else{ //TODO:see this case.
            mPicasso.load(R.drawable.ico_nophoto_medium)
                    .into(((SeasonsAdapter.SeasonsItemHolder) holder).image);
        }

        ((AppearsInAdapter.AppearsInItemHolder) holder).title.setText(row.getTitle());
        ((AppearsInAdapter.AppearsInItemHolder) holder).title.setTypeface(latoSemibold);
        ((AppearsInAdapter.AppearsInItemHolder) holder).director.setText(row.getSubtitle());
        ((AppearsInAdapter.AppearsInItemHolder) holder).director.setTypeface(latoSemibold);
        ((AppearsInItemHolder) holder).layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage onclick.
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class AppearsInItemHolder extends RecyclerView.ViewHolder {

        private LinearLayout layout;
        private ImageView image;
        private TextView title;
        private TextView director;

        public AppearsInItemHolder(View v) {
            super(v);
            layout=(LinearLayout) v.findViewById(R.id.appearsin_container);
            image = (ImageView) v.findViewById(R.id.appearsin_image);
            title = (TextView) v.findViewById(R.id.appearsin_title);
            director = (TextView) v.findViewById(R.id.appearsin_director);
        }
    }
}
