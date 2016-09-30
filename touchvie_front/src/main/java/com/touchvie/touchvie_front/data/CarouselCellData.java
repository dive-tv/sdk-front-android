package com.touchvie.touchvie_front.data;

import com.touchvie.backend.Card;
import com.touchvie.touchvie_client.data.CarouselCard;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class CarouselCellData implements Serializable {

    ArrayList<CarouselCard> cards;
    int sceneNr;

    public ArrayList<CarouselCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<CarouselCard> cards) {
        this.cards = cards;
    }

    public int getSceneNr() {
        return sceneNr;
    }

    public void setSceneNr(int sceneNr) {
        this.sceneNr = sceneNr;
    }
}