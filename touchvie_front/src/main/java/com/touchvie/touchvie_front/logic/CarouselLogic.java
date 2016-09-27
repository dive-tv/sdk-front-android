package com.touchvie.touchvie_front.logic;

import com.touchvie.touchvie_client.data.CarouselCard;

/**
 * Created by Tagsonomy S.L. on 27/09/2016.
 */

public class CarouselLogic {

    public void processData(CarouselCard[] cards){
        CarouselCard lastCard = null;
        CarouselCard newCard = null;


        for (CarouselCard card:cards){
            if (checkGroupableTree(newCard, lastCard)){

            }
        }
    }

    private boolean checkGroupableTree(CarouselCard Card, CarouselCard last){


        return false;
    };
}
