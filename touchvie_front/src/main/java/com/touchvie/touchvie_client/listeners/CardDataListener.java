package com.touchvie.touchvie_client.listeners;

import com.touchvie.backend.carddetail.CardDetail;

/**
 * Created by Tagsonomy S.L. on 14/09/2016.
 */
public interface CardDataListener {

    /**
     * Interface to be reported when the data of a card has been received.
     *
     * @param data
     */
    void onCardReceived(CardDetail data);
}
