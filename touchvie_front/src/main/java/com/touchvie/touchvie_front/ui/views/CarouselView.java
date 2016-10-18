package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.widget.FrameLayout;

import com.touchvie.backend.CardData;
import com.touchvie.backend.MiniCard;

/**
 * Created by rodrigo.moral on 03/10/2016.
 */

public class CarouselView {

    Context context;
    MiniCard card;
    FrameLayout layout;

    public CarouselView(Context context, MiniCard card) {
        this.context = context;
        this.card = card;
        createLayout();
    }

    protected void createLayout() {
    }

    public FrameLayout getLayout() {
        return layout;
    }


}
