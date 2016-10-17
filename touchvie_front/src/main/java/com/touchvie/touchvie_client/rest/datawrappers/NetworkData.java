package com.touchvie.touchvie_client.rest.datawrappers;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

import java.io.Serializable;

/**
 * Class to manage a HTTP code in a network response.
 */
public class NetworkData implements Serializable {

    int httpCode;

    /**
     * Get the HTTP code received in the network response.
     *
     * @returns {int} httpCode. HTTP code.
     */
    public int getHttpCode() {

        return httpCode;
    }

    /**
     * Set the HTTP code received in the network response.
     *
     * @param {int} code. Code received.
     */
    public void setHttpCode(int code) {

        httpCode = code;
    }

}
