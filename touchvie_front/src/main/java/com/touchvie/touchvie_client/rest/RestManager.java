package com.touchvie.touchvie_client.rest;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.touchvie.touchvie_client.interfaces.OauthObjectInterface;
import com.touchvie.touchvie_client.rest.listeners.CardDataListener;
import com.touchvie.touchvie_client.rest.listeners.MiniCardListener;
import com.touchvie.touchvie_client.rest.restmanager.Cards;
import com.touchvie.touchvie_client.rest.restmanager.interfaces.CardManagerInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class RestManager implements CardManagerInterface {
    public static Context context = null;

    private Cards cardManager;

    private static volatile RestManager instance;

    private SharedPreferences.Editor editor = null;
    private HashMap<String, String> headerParams;
    HashMap<String, String> registerParams;

    private String language;


    private VolleyProvider mVProvider = null;
    private static SharedPreferences settings = null;

    //header variables.
    private static final String DIVE_TOKEN = "Authorization";
    private static final String ACCEPT_LANGUAGE = "Accept-Language";

    /**
     * RestManager constructor.
     *
     * @param {Context} ctx. Context of the current REST manager.
     */

    public RestManager(Context ctx) {
        context = ctx;

        cardManager = new Cards(ctx);

        mVProvider = VolleyProvider.getInstance(ctx);
        settings = context.getSharedPreferences(Utils.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        editor = settings.edit();


        //HEADERS CONTENT
        language = Locale.getDefault().toString();
        language = language.replaceAll("_", "-");
        //TODO stop forcing Spanish
        //language = "es-ES";

        //register headers

        registerParams = new HashMap<>();
        registerParams.put(ACCEPT_LANGUAGE, language);

        //generic headers
        headerParams = new HashMap<>();
        headerParams.put(DIVE_TOKEN, Utils.getStoredToken(ctx));
        headerParams.put(ACCEPT_LANGUAGE, language);

    }

    /**
     * Return the single instance of the authentication manager. Create it if it has not been previously created.
     *
     * @returns {RestManager} instance. The single instance of the authentication manager.
     */

    public static synchronized RestManager getOrCreateInstance(Context context) {
        if (instance == null)
            instance = new RestManager(context);

        return instance;
    }

    /**
     * Return the single instance of the authentication manager.
     *
     * @returns {RestManager} instance. The single instance of the authentication manager.
     */

    public static synchronized RestManager getInstance() {
        if (instance == null)
            instance = new RestManager(context);
        return instance;
    }

    public static synchronized RestManager checkInstance() {

        return instance;
    }

    public HashMap<String, String> getRegisterHeader() {
        return registerParams;
    }

    public HashMap<String, String> getHeader() {
        return headerParams;
    }

    /**
     * Check whether the network is On or not.
     *
     * @returns {boolean} true if the network is on, false otherwise.
     */
    public boolean isNetworkOnline() {

        boolean status = false;
        if (context == null)
            return false;

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();

            if (netInfo != null && netInfo.isConnected()) {
                status = true;
            } else {
                netInfo = cm.getActiveNetworkInfo();
                if (netInfo != null && netInfo.isConnected())
                    status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return status;

    }


    @Override
    public boolean getCard(String cardId, CardDataListener listener, OauthObjectInterface auth) {
        return cardManager.getCard(cardId, listener, auth);
    }

    @Override
    public boolean getMiniCard(ArrayList<String> cardId, String addProducts, MiniCardListener listener) {
        return getMiniCard(cardId, addProducts, listener);
    }
}

