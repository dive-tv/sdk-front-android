package com.touchvie.touchvie_client.rest;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.touchvie.dive.restmanager.datawrappers.NotifConfigData;
import com.touchvie.dive.restmanager.listeners.AuthListener;
import com.touchvie.dive.restmanager.listeners.ProfileListener;
import com.touchvie.dive.restmanager.listeners.TvEventListener;
import com.touchvie.dive.restmanager.restmanager.Auth;
import com.touchvie.dive.restmanager.restmanager.Profile;
import com.touchvie.dive.restmanager.restmanager.TvEvent;
import com.touchvie.dive.restmanager.restmanager.interfaces.AuthManagerInterface;
import com.touchvie.dive.restmanager.restmanager.interfaces.ProfileManagerInterface;
import com.touchvie.dive.restmanager.restmanager.interfaces.TvEventManagerInterface;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class RestManager implements AuthManagerInterface, ProfileManagerInterface, TvEventManagerInterface {
    public static Context context = null;

    private Auth authManager;
    private Profile profileManager;
    private TvEvent tvEvent;

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


        authManager = new Auth(ctx);
        profileManager = new Profile(ctx);
        tvEvent = new TvEvent(ctx);

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


    //Implemented interface methods.
    @Override
    public boolean getDiveToken(String username, String password, String token, String refresh_token, boolean refresh, int currentTry, int maxTries, AuthListener listener) {
        return authManager.getDiveToken(username, password, token, refresh_token, refresh, currentTry, maxTries, listener);
    }

    @Override
    public boolean registerEmail(String email, String password, AuthListener listener) {
        return authManager.registerEmail(email, password, listener);
    }

    @Override
    public boolean registerFacebook(String token, AuthListener listener) {
        return authManager.registerFacebook(token, listener);
    }

    @Override
    public boolean setPassword(String password, AuthListener listener) {
        return authManager.setPassword(password, listener);
    }

    @Override
    public boolean changePassword(String newPassword, String oldPassword, AuthListener listener) {
        return authManager.changePassword(newPassword, oldPassword, listener);
    }

    @Override
    public boolean resetPassword(String email, AuthListener listener) {
        return authManager.resetPassword(email, listener);
    }

    @Override
    public boolean getCredentialsAWS(int currentTry, int maxTries, AuthListener listener) {
        return authManager.getCredentialsAWS(currentTry, maxTries, listener);
    }

    @Override
    public boolean checkDiveVersion(AuthListener listener) {
        return authManager.checkDiveVersion(listener);
    }

    @Override
    public boolean addDevice(String token, ProfileListener listener) {
        return profileManager.addDevice(token,listener);
    }

    @Override
    public boolean deleteDevice(String token, ProfileListener listener) {
        return profileManager.deleteDevice(token, listener);
    }

    @Override
    public boolean getProfile(ProfileListener listener) {
        return profileManager.getProfile(listener);
    }

    @Override
    public boolean changeEmail(String email, ProfileListener listener) {
        return profileManager.changeEmail(email, listener);
    }

    @Override
    public boolean profileNotificationsSettings(NotifConfigData notifConf, ProfileListener listener) {
        return profileManager.profileNotificationsSettings(notifConf, listener);
    }

    @Override
    public boolean getTvRegions(TvEventListener listener) {
        return tvEvent.getTvRegions(listener);
    }

    @Override
    public boolean updateRegions(String tvRegionSelect, TvEventListener listener) {
        return tvEvent.updateRegions(tvRegionSelect, listener);
    }

    @Override
    public boolean getTvChannels(TvEventListener listener) {
        return tvEvent.getTvChannels(listener);
    }

    @Override
    public boolean updateChannels(String tvChannelId, boolean isActive, TvEventListener listener) {
        return tvEvent.updateChannels(tvChannelId, isActive, listener);
    }
}

