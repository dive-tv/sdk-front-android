package com.touchvie.touchvie_front.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;

public class CarouselRowGenericAdapter {

    public View getView(Context context, View convertView, CarouselCard carouselCard) {
        CarouselRowGenericViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.carousel_item_generic, null);
            holder = new CarouselRowGenericViewHolder();
            holder.row = (CardView) convertView.findViewById(R.id.carousel_item_generic_base);
            holder.photo = (ImageView) convertView.findViewById(R.id.carousel_item_generic_base_img);
            holder.title = (TextView) convertView.findViewById(R.id.carousel_item_generic_base_txt);
            convertView.setTag(holder);
        } else {
            holder = (CarouselRowGenericViewHolder) convertView.getTag();
        }

        Card card = carouselCard.getData();
        if (card.getImage() != null && card.getImage().length() > 0) {
            Picasso
                    .with(context)
                    .load(card.getImage())
                    .into(holder.photo);
            holder.photo.setVisibility(View.VISIBLE);
        } else {
            holder.photo.setVisibility(View.GONE);
        }

        //title
        if (card.getTitle() != null && card.getTitle().length() > 0) {
            holder.title.setText(card.getTitle());
        } else {
            holder.title.setText("");
        }

        return convertView;
    }

    private class CarouselRowGenericViewHolder {
        CardView row;
        ImageView photo;
        TextView title;
    }
}
