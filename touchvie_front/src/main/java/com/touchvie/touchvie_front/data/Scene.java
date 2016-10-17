package com.touchvie.touchvie_front.data;

import com.touchvie.touchvie_client.data.CarouselCard;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class Scene {

    /**
     * The carousel cards that shape this scene.
     */
    private ArrayList<CarouselCard> carouselCards;


    /**
     * Gets all the carousel cards that belong to this scene.
     * @return
     */
    public ArrayList<CarouselCard> getCarouselCards() {
        return carouselCards;
    }

    /**
     * Sets all the carousel cards that belong to this scene.
     * @param carouselCards The cards to be set.
     */
    public void setCarouselCards(ArrayList<CarouselCard> carouselCards) {
        if(this.carouselCards !=null){
            this.carouselCards.clear();
        }else{
            this.carouselCards= new ArrayList<>();
        }
        this.carouselCards.addAll(carouselCards);
    }

    /**
     * Adds a carousel card to this scene.
     * @param carouselCard The card to be added.
     */
    public void addCarouselCard(CarouselCard carouselCard){
        if(this.carouselCards ==null){
            this.carouselCards= new ArrayList<>();
        }
        this.carouselCards.add(carouselCard);
    }

    /**
     * Adds a bunch of carousel cards to this scene.
     * @param carouselCards The cards to be added.
     */
    public void addCarouselCards(ArrayList<CarouselCard> carouselCards){

        if(this.carouselCards ==null){
            this.carouselCards= new ArrayList<>();
        }
        this.carouselCards.addAll(carouselCards);

    }
}
