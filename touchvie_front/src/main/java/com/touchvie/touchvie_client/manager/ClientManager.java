package com.touchvie.touchvie_client.manager;

import android.util.DisplayMetrics;

import com.touchvie.touchvie_client.data.ImageSize;

/**
 * Created by Tagsonomy S.L. on 30/09/2016.
 */

public class ClientManager {


    private static ClientManager instance = new ClientManager();

    public static ClientManager getInstance() {
        return instance;
    }

    private ClientManager() {

    }

    public String getImageUrl(String data, ImageSize imageSize, int densityDpi){

        String DPI = "@2x";

        String size="";

        String url;
        if (data == null || data.length() == 0 || data.trim().length() == 0) {
            return "";
        }

        switch (imageSize) {

            case small:
                size = "s";
                break;
            case thumb:
                size = "thumb";
                break;
            case medium:
                size = "m";
                break;
            case large:
                size = "l";
                break;
            case high:
                size = "h";
                break;
            case extra_large:
                size = "xl";
                break;
            case extra_extra_large:
                size = "xxl";
                break;
            case full:
                size = "full";
                break;
            default:
                size = "s";
                break;

        }

        switch (densityDpi) {

            case DisplayMetrics.DENSITY_XXXHIGH: //HDPI
                DPI = "@3x";
                break;
            case DisplayMetrics.DENSITY_XXHIGH: //HDPI
                DPI = "@2x";
                break;
            case DisplayMetrics.DENSITY_XHIGH: //HDPI
                DPI = "@2x";
                break;
            case DisplayMetrics.DENSITY_HIGH: //HDPI
                DPI = "@2x";
                break;
            case DisplayMetrics.DENSITY_MEDIUM: //MDPI
                DPI = "@1x";
                break;
            case DisplayMetrics.DENSITY_LOW:  //LDPI
                DPI = "@1x";
                break;
        }
        //DPI="@2x";
        String s = data;
        int dotPos = s.lastIndexOf(".");
        if (data.contains("https://")) {
            if (imageSize != ImageSize.full) {
                url = (s.substring(0, dotPos)).concat("_" + size).concat("_" + DPI).concat(s.substring(dotPos));
            } else {
                url = (s.substring(0, dotPos)).concat("_" + size).concat(s.substring(dotPos));
            }

        } else {
            if (imageSize != ImageSize.full) {
                url = getStoredCardBaseUrl().concat((s.substring(0, dotPos)).concat("_" + size).concat("_" + DPI).concat(s.substring(dotPos)));
            } else {
                url = getStoredCardBaseUrl().concat((s.substring(0, dotPos)).concat("_" + size).concat(s.substring(dotPos)));
            }
        }
        return url;

    }

    private String getStoredCardBaseUrl(){

        return "https://card.touchvie.com/";
    }

}
