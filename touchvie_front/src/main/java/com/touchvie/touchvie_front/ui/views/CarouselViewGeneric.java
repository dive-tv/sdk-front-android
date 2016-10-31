package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.MiniCard;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;

/**
 * Created by rodrigo.moral on 03/10/2016.
 */

public class CarouselViewGeneric extends CarouselView {

    public CarouselViewGeneric(Context context, MiniCard card) {
        super(context, card);
    }

    @Override
    protected void createLayout() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FrameLayout baseView = (FrameLayout) inflater.inflate(R.layout.carousel_item_generic, null);
        final ImageView mImageView = (ImageView) baseView.findViewById(R.id.carousel_item_generic_base_img);
        TextView mTextView = (TextView) baseView.findViewById(R.id.carousel_item_generic_base_txt);
            mImageView.setVisibility(View.VISIBLE);
            mImageView.post(new Runnable() {
                @Override
                public void run() {
                    if (card.getImage() != null && card.getImage().getThumb() !=null) {
                        Picasso.with(context)
                                .load(card.getImage().getThumb())
                                .priority(Picasso.Priority.HIGH)
                                .noFade()
                                .placeholder(R.drawable.ico_nophoto_medium)
                                .into(mImageView);
                    }else{
                        Picasso.with(context)
                                .load(R.drawable.ico_nophoto_medium)
                                .priority(Picasso.Priority.HIGH)
                                .fit()
                                .noFade()
                                .placeholder(R.drawable.ico_nophoto_medium)
                                .into(mImageView);
                    }
                }
            });

        if (card.getTitle() != null && card.getTitle().length() > 0) {
            mTextView.setText(card.getTitle());
        } else {
            mTextView.setText("");
        }

        baseView.setVisibility(View.VISIBLE);
        baseView.requestLayout();
        baseView.invalidate();
        layout = baseView;
    }
}
