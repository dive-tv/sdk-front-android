package com.touchvie.touchvie_client.interfaces;

import com.touchvie.touchvie_client.rest.listeners.AuthListener;

/**
 * Created by Tagsonomy S.L. on 18/10/2016.
 */

public interface OauthObjectInterface {
    public String getToken();
    public boolean refreshToken(AuthListener listener);
}
