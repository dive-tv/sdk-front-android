package com.touchvie.touchvie_front.data;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.touchvie.backend.CardData;
import com.touchvie.backend.MiniCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.views.CarouselView;
import com.touchvie.touchvie_front.ui.views.CarouselViewCuriosity;
import com.touchvie.touchvie_front.ui.views.CarouselViewGeneric;

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
        views.clear();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.baseView = inflater.inflate(R.layout.carousel_item_linear_container, null);
        this.layout = (LinearLayout) baseView.findViewById(R.id.carousel_item_linear_container);

        if (getCards() != null && getCards().size() > 0) {
            for (int i = 0; i < getCards().size(); i++) {
                if (getCards().get(i).getMiniCard().getType().equals("curiosity")) {
                    CarouselViewCuriosity temp = new CarouselViewCuriosity(context, getCards().get(i).getMiniCard());
                    views.add(temp);
                } else {
                    CarouselViewGeneric temp = new CarouselViewGeneric(context, getCards().get(i).getMiniCard());
                    views.add(temp);
                }
            }
        }

        if (views != null && views.size() > 0) {
            for (int i = 0; i < views.size(); i++) {
                if ((ViewGroup) views.get(i).getLayout().getParent() != null) {
                    ((ViewGroup) views.get(i).getLayout().getParent()).removeAllViews();
                }
                views.get(i).getLayout().setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));

                layout.addView(views.get(i).getLayout());
            }

            layout.requestLayout();
            layout.invalidate();
        }

        if (layout.getParent() != null) {
            ((CardView) layout.getParent()).removeAllViews();
        }

        return layout;

    }
}