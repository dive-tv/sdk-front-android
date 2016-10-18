package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class SquareImageItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ImageRowData> rows;
    private Picasso mPicasso;
    private Typeface latoRegular;
    private Typeface latoSemibold;

    public SquareImageItemsAdapter(Context context, ArrayList<ImageRowData> rows) {
        super();
        this.rows = rows;
        mPicasso = Picasso.with(context);
        latoRegular = Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR);
        latoSemibold = Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.square_image_item_row, parent, false);
        return new SquareImageItemsItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mPicasso.load(rows.get(position).getImage())
                .into(((SquareImageItemsItemHolder) holder).image);

        String title = "";
        for (int i = 0; i < rows.get(position).getTitle().size(); i++) {
            title = title + rows.get(position).getTitle().get(i).getText();
        }

        Spannable spannableTitle = new SpannableString(title);
        ((SquareImageItemsItemHolder) holder).title.setText(spannableTitle);
        ((SquareImageItemsItemHolder) holder).title.setTypeface(latoSemibold);

        String subtitle = "";
        for (int i = 0; i < rows.get(position).getSubtitle().size(); i++) {
            subtitle = subtitle + rows.get(position).getSubtitle().get(i).getText();
        }
        Spannable spannableSubtitle = new SpannableString(subtitle);
        ((SquareImageItemsItemHolder) holder).subtitle.setText(spannableSubtitle);
        ((SquareImageItemsItemHolder) holder).subtitle.setTypeface(latoRegular);
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    private static class SquareImageItemsItemHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView subtitle;

        SquareImageItemsItemHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.simageitems_image);
            title = (TextView) v.findViewById(R.id.simageitems_title);
            subtitle = (TextView) v.findViewById(R.id.simageitems_subtitle);
        }
    }

}


