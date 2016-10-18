package com.touchvie.touchvie_client.rest.restmanager.interfaces;

import com.touchvie.touchvie_client.interfaces.OauthObjectInterface;
import com.touchvie.touchvie_client.rest.listeners.CardDataListener;
import com.touchvie.touchvie_client.rest.listeners.MiniCardListener;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public interface CardManagerInterface {
    boolean getCard(final String cardId, final CardDataListener listener, OauthObjectInterface auth);

    boolean getMiniCard(final ArrayList<String> cardId, final String addProducts, final MiniCardListener listener);
}
