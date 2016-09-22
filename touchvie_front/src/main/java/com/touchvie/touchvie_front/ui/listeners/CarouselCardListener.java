package com.touchvie.touchvie_front.ui.listeners;

import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.data.Scene;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public interface CarouselCardListener {

    /**
     * Interface to be reported when a new carousel card enters to the carousel.
     * @param sceneIndex The scene where this card belongs to (//TODO: index from 1 to x or starting from 0????)
     * @param carouselCard The carousel card to be added to the carousel.
     */
    void onShowCarouselCard(Integer sceneIndex, CarouselCard carouselCard );

    /**
     * Interface to be reported when there is data that can be preloaded.
     * @param imageUrls Image urls to be preloaded.
     */
    void onPreloadCarouselCard(String[] imageUrls);

    /**
     * Interface to receive all the information about one scene.
     * @param sceneIndex
     * @param scene
     */
    void onShowScene(Integer sceneIndex, Scene scene);
}
