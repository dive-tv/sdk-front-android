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
import com.touchvie.touchvie_front.ui.modules.data.SeasonRowData;
import com.touchvie.touchvie_front.ui.modules.data.ShopRowData;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ShopRowData> rows;
    private Picasso mPicasso;
    private Typeface latoRegular;
    private Typeface latoSemibold;

    public ShopAdapter(Context context, ArrayList<ShopRowData> data){
        super();
        this.rows=data;
        mPicasso = Picasso.with(context);
        latoRegular = Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR);
        latoSemibold = Utils.getFont(context, Utils.TypeFaces.LATO_SEMIBOLD);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_row, parent, false);
        return new ShopAdapter.ShopItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ShopRowData row= rows.get(position);
        if(row.getImage()!=null){
            mPicasso.load(row.getImage())
                    .into(((SeasonsAdapter.SeasonsItemHolder) holder).image);
        }else{ //TODO:see this case.
            mPicasso.load(R.drawable.ico_nophoto_medium)
                    .into(((SeasonsAdapter.SeasonsItemHolder) holder).image);
        }

        ((ShopAdapter.ShopItemHolder) holder).price.setText(row.getPrice());
        ((ShopAdapter.ShopItemHolder) holder).price.setTypeface(latoSemibold);
        ((ShopAdapter.ShopItemHolder) holder).shop.setText(row.getShop());
        ((ShopAdapter.ShopItemHolder) holder).shop.setTypeface(latoRegular);
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public static class ShopItemHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView price;
        private TextView shop;
        private FrameLayout shopNow;

        public ShopItemHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.shop_image);
            price = (TextView) v.findViewById(R.id.shop_price);
            shop = (TextView) v.findViewById(R.id.shop_shop);
            shopNow = (FrameLayout) v.findViewById(R.id.shop_button);
        }
    }

}

