package com.touchvie.touchvie_client.listeners;

import android.support.v4.app.FragmentManager;
import android.widget.LinearLayout;

import com.touchvie.backend.CardData;

/**
 * Created by Tagsonomy S.L. on 14/09/2016.
 */
public interface CardDataListener {

    /**
     * Interface to be reported when the data of a card has been received.
     * @param data
     */
    void onCardReceived(CardData data);
}
