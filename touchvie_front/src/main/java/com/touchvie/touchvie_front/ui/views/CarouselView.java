package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.CardData;
import com.touchvie.touchvie_client.data.ImageSize;
import com.touchvie.touchvie_client.manager.ClientManager;
import com.touchvie.touchvie_front.R;

/**
 * Created by rodrigo.moral on 03/10/2016.
 */

public class CarouselView {

    Context context;
    CardData card;
    FrameLayout layout;

    public CarouselView(Context context, CardData card) {
        this.context = context;
        this.card = card;
        createLayout();
    }

    protected void createLayout() {}

    public FrameLayout getLayout() {
        return layout;
    }



}
