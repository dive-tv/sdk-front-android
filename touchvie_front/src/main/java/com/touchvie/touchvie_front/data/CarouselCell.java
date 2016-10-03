package com.touchvie.touchvie_front.data;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.touchvie.backend.CardData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.Utils;
import com.touchvie.touchvie_front.ui.views.CarouselView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class CarouselCell implements Serializable {

    ArrayList<CardData> cards;
    int sceneNr;

    public ArrayList<CardData> getCards() {
        return cards;
    }

    public void setCards(ArrayList<CardData> cards) {
        this.cards = cards;
    }

    public int getSceneNr() {
        return sceneNr;
    }

    public void setSceneNr(int sceneNr) {
        this.sceneNr = sceneNr;
    }


    ////////////

    View baseView;
    LinearLayout layout;
    ArrayList<CarouselView> views = new ArrayList<>();


    public LinearLayout getView(Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.baseView = inflater.inflate(R.layout.carousel_item_linear_container, null);
        this.layout = (LinearLayout) baseView.findViewById(R.id.carousel_item_linear_container);

        if (getCards() != null && getCards().size() > 0) {
            if (getCards().get(0).getType().equals(Utils.cardType.curiosity.toString())) {
                CarouselView carouselView = new CarouselView(context, getCards().get(0));
                views.add(carouselView);
            }
        }

        if (views != null && views.size() > 0) {
            if (layout.getParent() != null) {
                ((CardView) this.layout.getParent()).removeAllViews();
            }

            for (int i = 0; i < views.size(); i++) {
                this.layout.addView(views.get(i).getLayout());
            }

            layout.requestLayout();
            layout.invalidate();
        }


        return layout;
    }
}