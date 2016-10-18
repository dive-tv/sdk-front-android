package com.touchvie.touchvie_client.rest.listeners;

import com.touchvie.backend.MiniCard;
import com.touchvie.touchvie_client.rest.datawrappers.NetworkData;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public interface MiniCardListener {
    public void onMiniCardReceived(MiniCard miniCard);
    public void onMiniCardError(NetworkData response);
}
