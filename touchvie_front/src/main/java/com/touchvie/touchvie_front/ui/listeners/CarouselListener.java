package com.touchvie.touchvie_front.ui.listeners;

import com.touchvie.touchvie_front.data.CarouselCellData;

/**
 * Created by Tagsonomy S.L. on 14/09/2016.
 */
public interface CarouselListener {

    /**
     * Interface to be reported when the data of a card has been received.
     *
     * @param data
     */
    void onRowsToDraw(CarouselCellData data);
}
