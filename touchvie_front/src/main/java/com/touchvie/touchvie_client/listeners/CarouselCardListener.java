package com.touchvie.touchvie_client.listeners;

import com.touchvie.touchvie_client.data.CarouselCard;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public interface CarouselCardListener {

    void onCardReceived(CarouselCard card);

    void onSectionEndReceived(String sectionId);

    void onSectionStartReceived(String sectionId);
}
