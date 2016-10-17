package com.touchvie.touchvie_client.rest.listeners;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */


import com.touchvie.touchvie_client.rest.datawrappers.AuthData;
import com.touchvie.touchvie_client.rest.datawrappers.NetworkData;

/**
 * Interface to listen to RestManager calls when a response of a synchronization audio REST service is received.
 */
public interface AuthListener {
    /**
     * Call when a response is received.
     *
     * @param {SyncResult} result. Parsed network response.
     */
    public void onGetDiveToken(AuthData auth);

    /**
     * Call when an error response is received.
     *
     * @param {SyncResult} result. Parsed network response.
     */
    public void onError(NetworkData response);

}
