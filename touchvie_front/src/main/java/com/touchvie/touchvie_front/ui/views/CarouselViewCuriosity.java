package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.touchvie.backend.CardData;
import com.touchvie.backend.MiniCard;
import com.touchvie.touchvie_front.R;

/**
 * Created by rodrigo.moral on 03/10/2016.
 */

public class CarouselViewCuriosity extends CarouselView {

    public CarouselViewCuriosity(Context context, CardData card) {
        super(context, card);
    }

    @Override
    protected void createLayout() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FrameLayout baseView = (FrameLayout) inflater.inflate(R.layout.carousel_item_curiosity, null);
        TextView mTextView = (TextView) baseView.findViewById(R.id.carousel_item_curiosity_text);

        if (card.getMiniCard().getTitle() != null && card.getMiniCard().getTitle().length() > 0) {
            mTextView.setText(card.getMiniCard().getTitle());
        } else {
            mTextView.setText("");
        }

        baseView.setVisibility(View.VISIBLE);
        baseView.requestLayout();
        baseView.invalidate();
        layout = baseView;
    }
}
