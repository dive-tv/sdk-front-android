package com.touchvie.touchvie_client.rest;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class Utils {
    public final static String SHARED_PREFERENCES = "Settings";
    private static SharedPreferences settings = null;
    public static final String DIVE_TOKEN = "Authorization";

    private String language = Locale.getDefault().toString().replaceAll("_", "-");

    //Shared preferences
    private static final String DIVE_REFRESH_TOKEN = "refresh_token";


    /**
     * Get the stored Touchvie token.
     *
     * @returns {String} touchvieToken. The Touchvie token.
     */
    public static String getStoredToken(Context context) {
        settings = context.getSharedPreferences(Utils.SHARED_PREFERENCES, 0);
        //Check whether the token is stored in Shared Preferences or not.
        String touchvieToken = settings.getString(DIVE_TOKEN, null);
       /* if (touchvieToken == null || touchvieToken.length() == 0)
            return null;*/
        return "Bearer " + touchvieToken;
    }

    /**
     * Store the Touchvie token on the device.
     *
     * @param {String} token. The Touchvie token.
     */

    public static void storeToken(String token, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                Utils.SHARED_PREFERENCES, Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPref.edit();

        editor = settings.edit();
        editor.putString(DIVE_TOKEN, token);
        editor.apply();
    }

    /**
     * Get the stored Touchvie refresh token.
     *
     * @returns {String} touchvieToken. The Touchvie token.
     */
    public static String getStoredRefreshToken(Context context) {
        settings = context.getSharedPreferences(Utils.SHARED_PREFERENCES, 0);
        //Check whether the token is stored in Shared Preferences or not.
        String diveRefreshToken = settings.getString(DIVE_REFRESH_TOKEN, null);
        if (diveRefreshToken == null || diveRefreshToken.length() == 0)
            return null;
        return diveRefreshToken;
    }

    /**
     * Store the Touchvie refresh token on the device.
     *
     * @param {String} token. The Touchvie token.
     */

    public static void storeRefreshToken(String refresh_token, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                Utils.SHARED_PREFERENCES, Context.MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPref.edit();

        editor = settings.edit();
        editor.putString(DIVE_REFRESH_TOKEN, refresh_token);
        editor.apply();
    }

    /**
     * Return whether this application has a valid token stored inside. TODO:  The token is now stored in sharedPreferences. Change it.
     *
     * @returns {boolean} true if the token is stored and valid, false otherwise.
     */
    public static boolean checkStoredToken() {

        //Check whether the token is stored in Shared Preferences or not.

        String diveToken = settings.getString(DIVE_TOKEN, null);

        if (diveToken == null || diveToken.length() == 0 || diveToken.trim().length() == 0)
            return false;
        return true;
    }


    public static String getImageSize(int density) {
        String DPI = "m";
        switch (density) {

            case DisplayMetrics.DENSITY_XXXHIGH: //HDPI
                DPI = "l";
                break;
            case DisplayMetrics.DENSITY_XXHIGH: //HDPI
                DPI = "m";
                break;
            case DisplayMetrics.DENSITY_XHIGH: //HDPI
                DPI = "m";
                break;
            case DisplayMetrics.DENSITY_HIGH: //HDPI
                DPI = "m";
                break;
            case DisplayMetrics.DENSITY_MEDIUM: //MDPI
                DPI = "s";
                break;
            case DisplayMetrics.DENSITY_LOW:  //LDPI
                DPI = "s";
                break;
        }
        return DPI;
    }
}
