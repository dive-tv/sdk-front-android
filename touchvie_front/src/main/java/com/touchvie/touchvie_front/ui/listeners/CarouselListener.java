package com.touchvie.touchvie_front.ui.listeners;

import android.os.Handler;

import com.touchvie.touchvie_front.data.CarouselCellData;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 14/09/2016.
 */
public interface CarouselListener {

    /**
     * Interface to be reported when the data of a card has been received.
     *
     * @param carouselCellDatas array of carousel cell datas to use in the list
     */
    void onRowsToDraw(ArrayList<CarouselCellData> carouselCellDatas);

    void setHandler(Handler handler);
}
