package com.touchvie.touchvie_front.data;

import com.touchvie.backend.CardData;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class CarouselCellData implements Serializable {

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
}