package com.touchvie.touchvie_client.rest.listeners;

import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_client.rest.datawrappers.NetworkData;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public interface CardDataListener {
    public void onCardDataReceived(CardDetail card);

    public void onCardDataError(NetworkData response);


}
