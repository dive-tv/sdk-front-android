package com.touchvie.touchvie_front.logic;

import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.data.CarouselCell;

/**
 * Created by Tagsonomy S.L. on 27/09/2016.
 */

public class CarouselLogic {

    public void processData(CarouselCard[] cards){
        CarouselCard lastCard = null;
        CarouselCard newCard = null;
        CarouselCell cell = null;

        for (CarouselCard card:cards){
            newCard = card;
            if (newCard!=null && lastCard!=null && checkGroupableTree(newCard, lastCard)){

            }
            lastCard = newCard;
        }
    }

    private boolean checkGroupableTree(CarouselCard Card, CarouselCard last){


        return false;
    };
}
