package com.touchvie.touchvie_client.listeners;

import com.touchvie.touchvie_client.data.CarouselCard;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public interface CarouselCardListener {


    void onSectionEndReceived(Integer sectionId);

    void onSectionStartReceived(Integer sectionId);

    void onCardsForPreloadReceived(ArrayList<CarouselCard> cards);

    void onCardsForPaintReceived(ArrayList<String>cardIds);
}
