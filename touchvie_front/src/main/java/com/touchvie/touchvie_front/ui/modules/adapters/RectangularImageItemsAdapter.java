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
 * Created by Tagsonomy S.L. on 14/10/2016.
 */

public class RectangularImageItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ImageRowData> rows;
    private boolean imageTextSpace = false;
    private Picasso mPicasso;
    private Typeface latoRegular;
    private Typeface latoSemibold;

    public RectangularImageItemsAdapter(Context context, ArrayList<ImageRowData> rows) {
        super();
        this.rows = rows;
        mPicasso = Picasso.with(context);
        latoRegular = Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR);
        latoSemibold = Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rectangular_image_item_row, parent, false);
        return new RectangularImageItemsItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mPicasso.load(rows.get(position).getImage())
                .into(((RectangularImageItemsItemHolder) holder).image);

        String title = "";
        for (int i = 0; i < rows.get(position).getTitle().size(); i++) {
            title = title + rows.get(position).getTitle().get(i).getText();
        }

        Spannable spannableTitle = new SpannableString(title);
        ((RectangularImageItemsItemHolder) holder).title.setText(spannableTitle);
        ((RectangularImageItemsItemHolder) holder).title.setTypeface(latoRegular);

        String subtitle = "";
        for (int i = 0; i < rows.get(position).getSubtitle().size(); i++) {
            subtitle = subtitle + rows.get(position).getSubtitle().get(i).getText();
        }
        Spannable spannableSubtitle = new SpannableString(subtitle);
        ((RectangularImageItemsItemHolder) holder).subtitle.setText(spannableSubtitle);
        ((RectangularImageItemsItemHolder) holder).subtitle.setTypeface(latoSemibold);
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public void setImageTextSpace(boolean space) {

        this.imageTextSpace = space;
    }

    public static class RectangularImageItemsItemHolder extends RecyclerView.ViewHolder {

        ImageView image;

        TextView title;

        TextView subtitle;

        public RectangularImageItemsItemHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.rimageitems_image);
            title = (TextView) v.findViewById(R.id.rimageitems_title);
            subtitle = (TextView) v.findViewById(R.id.rimageitems_subtitle);
        }
    }


}


