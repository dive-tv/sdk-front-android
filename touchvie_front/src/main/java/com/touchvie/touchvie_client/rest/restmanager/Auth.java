package com.touchvie.touchvie_client.rest.restmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.GsonBuilder;
import com.touchvie.touchvie_client.rest.NetworkMsg;
import com.touchvie.touchvie_client.rest.Utils;
import com.touchvie.touchvie_client.rest.VolleyProvider;
import com.touchvie.touchvie_client.rest.datawrappers.AuthData;
import com.touchvie.touchvie_client.rest.datawrappers.NetworkData;
import com.touchvie.touchvie_client.rest.listeners.AuthListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.TimeZone;

import static com.touchvie.touchvie_client.rest.NetworkMsg.CONFLICT;


//import com.crashlytics.android.Crashlytics;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class Auth extends RestService {
    private final String getOauthUrl = versionApi + "/token";
    private gran_type grant;

    public Auth(Context ctx) {
        super(ctx);
    }

    public boolean getDiveToken(final String username, final String password, final String token, final String refresh_token, final boolean refresh, final int currentTry, final int maxTries, final AuthListener listener) {
        RequestQueue queue = VolleyProvider.getRequestQueue();

        Uri.Builder builder = Uri.parse(baseUrl + getOauthUrl).buildUpon();
        if (username != null && password != null) {
            grant = gran_type.password;
            builder.appendQueryParameter("grant_type", grant.name());
            builder.appendQueryParameter(PARAM_USERNAME, username);
            builder.appendQueryParameter(PARAM_PASSWORD, password);
        } else if (token != null) {
            grant = gran_type.facebook;
            builder.appendQueryParameter("grant_type", grant.name());
            builder.appendQueryParameter(PARAM_TOKEN, token);
        } else if (refresh_token != null) {
            grant = gran_type.refresh_token;
            builder.appendQueryParameter("grant_type", grant.name());
            builder.appendQueryParameter(PARAM_REFRESH_TOKEN, refresh_token);
        }

        Uri uriToSend = builder.build();
//        Crashlytics.log(Log.ERROR, "RestManager URL: ", uriToSend.toString());
        Request request = null;

        request = new JsonRequest<AuthData>(Request.Method.POST, uriToSend.toString(), null, new Response.Listener<AuthData>() {

            @Override
            public void onResponse(AuthData response) {
                Utils.storeRefreshToken(response.getRefresh_token(),context);
                Utils.storeToken(response.getAccess_token(),context);
                headerParams.put(DIVE_TOKEN,Utils.getStoredToken(context));
//                Utils.storeUserId(response.getUser_id(), context);
                listener.onGetDiveToken(response);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (currentTry < maxTries) {
                    getDiveToken(username, password, token, refresh_token, refresh, currentTry + 1, maxTries, listener);
                } else {
                    if (error == null || error.networkResponse == null) {

                        listener.onError(null);
                        return;
                    }
                    NetworkData data = new NetworkData();
                    data.setHttpCode(error.networkResponse.statusCode);
                    if (NetworkMsg.UNAUTHORIZED == error.networkResponse.statusCode) {
                        switch (grant){
                            case password:
                                getDiveToken(null, null, null, Utils.getStoredRefreshToken(context), true, currentTry, maxTries, listener);
                                break;
                            case facebook:
                                listener.onError(data);
                                break;
                            case refresh_token:
                                listener.onError(data);
                                break;
                        }
                    }

                }
            }
        }) {

            @Override
            protected Response<AuthData> parseNetworkResponse(NetworkResponse response) {
                String jsonString = null;
                try {
                    jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                AuthData server = new GsonBuilder().create().fromJson(jsonString, AuthData.class);
                if (server == null) {
                    server = new AuthData();
                }
                server.setHttpCode(response.statusCode);
                Response<AuthData> result = Response.success(server, HttpHeaderParser.parseCacheHeaders(response));
                return result;
            }

            public HashMap<String, String> getHeaders() {
                return tokenHeaderParams;
            }
        };
        queue.add(request);
        return true;
    }

    public enum gran_type {facebook, password, refresh_token}

}
