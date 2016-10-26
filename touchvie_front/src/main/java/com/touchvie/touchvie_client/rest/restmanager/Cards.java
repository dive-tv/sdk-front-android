package com.touchvie.touchvie_client.rest.restmanager;

import android.content.Context;
import android.net.Uri;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.touchvie.backend.MiniCard;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_client.interfaces.OauthObjectInterface;
import com.touchvie.touchvie_client.rest.NetworkMsg;
import com.touchvie.touchvie_client.rest.Utils;
import com.touchvie.touchvie_client.rest.VolleyProvider;
import com.touchvie.touchvie_client.rest.datawrappers.AuthData;
import com.touchvie.touchvie_client.rest.datawrappers.NetworkData;
import com.touchvie.touchvie_client.rest.listeners.AuthListener;
import com.touchvie.touchvie_client.rest.listeners.CardDataListener;
import com.touchvie.touchvie_client.rest.listeners.MiniCardListener;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tagsonomy S.L. on 06/10/2016.
 */

public class Cards extends RestService{
    private String getCardUrl = "/cards/";
    private String PARAM_RELATIONS = "relations";
    private String PARAM_IMAGE_SIZE = "image_size";
    private String getMiniCardUrl = "/cards/mini/";
    private String PARAM_ADD_PRODUCTS = "add_products";
    private OauthObjectInterface oauth;

    public Cards(Context ctx) {
        super(ctx);
    }

    public boolean getCard(final String cardId, final CardDataListener listener, final OauthObjectInterface oauth){
        this.oauth = oauth;
        RequestQueue queue = VolleyProvider.getRequestQueue();
        Uri.Builder builder = Uri.parse(baseUrl + getCardUrl + cardId).buildUpon();

        Uri uriToSend = builder.build();
        builder.appendQueryParameter(PARAM_RELATIONS,"all");
        builder.appendQueryParameter(PARAM_RELATIONS, Utils.getImageSize(context.getResources().getDisplayMetrics().densityDpi));
//        Crashlytics.log(Log.ERROR, "RestManager URL: ", uriToSend.toString());
        Request request = null;

        request = new JsonRequest<CardDetail>(Request.Method.GET, uriToSend.toString(), null, new Response.Listener<CardDetail>() {

            @Override
            public void onResponse(CardDetail response) {
                listener.onCardDataReceived(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                if (error == null || error.networkResponse == null) {
                    listener.onCardDataError(null);
                    return;
                }
                if (NetworkMsg.UNAUTHORIZED == error.networkResponse.statusCode) {
                    AuthListener authListener = new AuthListener() {
                        @Override
                        public void onGetDiveToken(AuthData auth) {
                            getCard(cardId, listener, oauth);
                        }

                        @Override
                        public void onError(NetworkData response) {
                        }
                    };

                    oauth.refreshToken(authListener);
                    return;
                }

                NetworkData authResult = null;
                if (error.networkResponse.data == null) {

                    authResult = new NetworkData();

                } else {
                    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
                    try {
                        authResult = mapper.readValue(new String(error.networkResponse.data), NetworkData.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    if (authResult == null) {
                        authResult = new NetworkData();
                    }

                }
                authResult.setHttpCode(error.networkResponse.statusCode);
                listener.onCardDataError(authResult);
            }
        }) {

            @Override
            protected Response<CardDetail> parseNetworkResponse(NetworkResponse response) {
                String jsonString = null;
                try {
                    jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ObjectMapper mapper = new ObjectMapper();
                CardDetail card = null;
                try {
                    card = mapper.readValue(jsonString, CardDetail.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (card == null) {
                    card = new CardDetail();
                }
                card.setHttpCode(response.statusCode);
                Response<CardDetail> result = Response.success(card, HttpHeaderParser.parseCacheHeaders(response));
                return result;
            }

            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {

                return volleyError;
            }

            public HashMap<String, String> getHeaders() {
                return headerParams;
            }
        };

        queue.add(request);
        return true;

    }

    public boolean getMiniCard(final ArrayList<String> cardId, final String addProducts, final MiniCardListener listener){
        RequestQueue queue = VolleyProvider.getRequestQueue();

        Uri.Builder builder = Uri.parse(baseUrl + getCardUrl +  android.text.TextUtils.join(",", cardId)).buildUpon();

        Uri uriToSend = builder.build();
        builder.appendQueryParameter(PARAM_IMAGE_SIZE,Utils.getImageSize(context.getResources().getDisplayMetrics().densityDpi));
        builder.appendQueryParameter(PARAM_ADD_PRODUCTS, addProducts);
//        Crashlytics.log(Log.ERROR, "RestManager URL: ", uriToSend.toString());
        Request request = null;

        request = new JsonRequest<MiniCard>(Request.Method.GET, uriToSend.toString(), null, new Response.Listener<MiniCard>() {

            @Override
            public void onResponse(MiniCard response) {
                listener.onMiniCardReceived(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                if (error == null || error.networkResponse == null) {
                    listener.onMiniCardError(null);
                    return;
                }
                if (NetworkMsg.UNAUTHORIZED == error.networkResponse.statusCode) {
                    AuthListener authListener = new AuthListener() {
                        @Override
                        public void onGetDiveToken(AuthData auth) {
                            getMiniCard(cardId, addProducts, listener);
                        }

                        @Override
                        public void onError(NetworkData response) {
                        }
                    };

                    oauth.refreshToken(authListener);
                    return;
                }

                NetworkData authResult = null;
                if (error.networkResponse.data == null) {

                    authResult = new NetworkData();

                } else {
                    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
                    try {
                        authResult = mapper.readValue(new String(error.networkResponse.data), NetworkData.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    if (authResult == null) {
                        authResult = new NetworkData();
                    }

                }
                authResult.setHttpCode(error.networkResponse.statusCode);
                listener.onMiniCardError(authResult);
            }
        }) {

            @Override
            protected Response<MiniCard> parseNetworkResponse(NetworkResponse response) {
                String jsonString = null;
                try {
                    jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ObjectMapper mapper = new ObjectMapper();
                MiniCard miniCard = null;
                try {
                    miniCard = mapper.readValue(jsonString, MiniCard.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (miniCard == null) {
                    miniCard = new MiniCard();
                }
                miniCard.setHttpCode(response.statusCode);
                Response<MiniCard> result = Response.success(miniCard, HttpHeaderParser.parseCacheHeaders(response));
                return result;
            }

            @Override
            protected VolleyError parseNetworkError(VolleyError volleyError) {

                return volleyError;
            }

            public HashMap<String, String> getHeaders() {
                return headerParams;
            }
        };

        queue.add(request);
        return true;

    }


}
