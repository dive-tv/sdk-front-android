package com.touchvie.touchvie_client.rest.restmanager;

import android.content.Context;

import com.touchvie.touchvie_client.rest.Utils;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

public class RestService {
    String baseUrl = "https://pre-api.dive.tv/";

    final String versionApi = "v1";
    protected final String versionCarouselConfig = "v2";
    protected final String versionAudio = "v2";
    protected final String versionChunk = "v1";
    Context context = null;
    private static final String ACCEPT_LANGUAGE = "Accept-Language";
    private static final String CONTENT_TYPE = "Content-Type";
    protected static final String DIVE_TOKEN = "Authorization";
    private static final String BASIC_AUTH = "Basic ZGl2ZV9tb2JpbGU6RkJoY045dDNVTWhaN0VaenRiNHdSQUtMWm82OTVjMzI=";

    private String token;

    //    final HashMap<String,String> paramsDict=new HashMap<>();
    public static final String PARAM_TOKEN = "token";
    public static final String PARAM_CARDID = "cardId";
    public static final String PARAM_RELATIONS = "relations";
    public static final String PARAM_IMAGE_SIZE = "image_size";
    public static final String PARAM_IDENTITY_ID = "identity_id";
    public static final String PARAM_USER_ID = "user_id";
    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_IS_PASSWORD_SET = "is_password_set";
    public static final String PARAM_TV_REGION = "tv_region";
    public static final String PARAM_TV_CHANNEL_ID = "id";
    public static final String PARAM_TV_CAHNNEL_IS_ACTIVE = "is_active";
    public static final String PARAM_NOTIFICATION_CONFIG = "notification_config";
    public static final String PARAM_DIVE = "dive";
    public static final String PARAM_HAS_LOGGED_IN = "has_logged_in";
    public static final String PARAM_NEW_PASSWORD = "new_password";
    public static final String PARAM_OLD_PASSWORD = "old_password";
    public static final String PARAM_TYPE = "type";
    public static final String PARAM_VERSION = "version";
    public static final String PARAM_ENVIRONMENT = "environment";
    public static final String PARAM_GRANT_TYPE = "grant_type";
    public static final String PARAM_USERNAME = "username";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_REFRESH_TOKEN = "refresh_token";
    public static final String PARAM_LOCAL_TIME = "local_time";

    //HEADER
    HashMap<String, String> registerParams;
    volatile static HashMap<String, String> headerParams;
    HashMap<String, String> tokenHeaderParams;
    HashMap<String, String> resetPassHeaderParams;
    String language, encoding, contentType;

    public RestService(Context ctx) {
        this.context = ctx;
        token = Utils.getStoredToken(ctx);
        //HEADERS CONTENT
        language = Locale.getDefault().toString();
        language = language.replaceAll("_", "-");
        contentType = "application/json";


        //post token headers
        tokenHeaderParams = new HashMap<>();
        tokenHeaderParams.put(DIVE_TOKEN, BASIC_AUTH);
        tokenHeaderParams.put(CONTENT_TYPE, contentType);

        //generic headers
        headerParams = new HashMap<>();
        headerParams.put(DIVE_TOKEN, token);
        headerParams.put(ACCEPT_LANGUAGE, language);
        headerParams.put(CONTENT_TYPE, contentType);


        //register headers
        registerParams = new HashMap<>();
        registerParams.put(ACCEPT_LANGUAGE, language);
        registerParams.put(CONTENT_TYPE, contentType);


        //reset pass headers
        resetPassHeaderParams = new HashMap<>();
        resetPassHeaderParams.put(ACCEPT_LANGUAGE, language);
        resetPassHeaderParams.put(CONTENT_TYPE, contentType);

    }
}

