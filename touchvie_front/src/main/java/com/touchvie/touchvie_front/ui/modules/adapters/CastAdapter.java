package com.touchvie.touchvie_front.ui.modules.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.data.CastRowData;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.modules.data.TextData;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class CastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<CastRowData> rows;
    private Context context;
    private Typeface latoRegular;
    private Typeface latoSemibold;
    private Picasso mPicasso;

    public CastAdapter(Context context, ArrayList<CastRowData>rows){
        super();
        this.rows=rows;
        this.context=context;
        mPicasso = Picasso.with(context);
        latoRegular = Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR);
        latoSemibold = Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_row, parent, false);
        return new CastAdapter.CastItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CastRowData row= rows.get(position);
        if(row.getImage()!=null){
            mPicasso.load(row.getImage())
                    .into(((CastAdapter.CastItemHolder) holder).image);
        }else{ //TODO:see this case.
            mPicasso.load(R.drawable.ico_nophoto_medium)
                    .into(((SeasonsAdapter.SeasonsItemHolder) holder).image);
        }


        ((CastAdapter.CastItemHolder) holder).person.setText(row.getPerson());
        ((CastAdapter.CastItemHolder) holder).person.setTypeface(latoSemibold);
        ((CastAdapter.CastItemHolder) holder).character.setText(row.getCharacter().getText());
        ((CastAdapter.CastItemHolder) holder).character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: go to link.
                row.getCharacter().getUrl();
            }
        });
        ((CastAdapter.CastItemHolder) holder).character.setTypeface(latoSemibold);
        ((CastItemHolder) holder).interprets.setTypeface(latoRegular);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CastItemHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView person;
        private TextView character;
        private TextView interprets;

        public CastItemHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.cast_image);
            person = (TextView) v.findViewById(R.id.cast_name);
            character = (TextView) v.findViewById(R.id.cast_character);
            interprets = (TextView) v.findViewById(R.id.cast_interprets);
        }
    }
}

