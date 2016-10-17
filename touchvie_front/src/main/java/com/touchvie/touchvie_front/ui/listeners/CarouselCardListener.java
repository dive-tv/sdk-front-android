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
    public void onShowCarouselCard(Integer sceneIndex, CarouselCard carouselCard );

    /**
     * Interface to be reported when there is data that can be preloaded.
     * @param imageUrls Image urls to be preloaded.
     */
    public void onPreloadCarouselCard(String[] imageUrls);

    /**
     * Interface to receive all the information about one scene.
     * @param sceneIndex
     * @param scene
     */
    public void onShowScene(Integer sceneIndex, Scene scene);

    /**
     * Interface to be reported when a new array of cards must pe preload
     * @param cards: Array of CarouselCards
     */
    public void onCardsForPreloadReceived(CarouselCard[] cards);

    /**
     *
     * @param sectionId
     * @param end
     */

    public void onSectionEndReceived(String sectionId, Double end);

    public void onSectionStartReceived(String sectionId, Double start);

    public void onCardsForPaintReceived(String[] cardIds);

    public void onCarouselSceneChanged(int sceneId);

}
