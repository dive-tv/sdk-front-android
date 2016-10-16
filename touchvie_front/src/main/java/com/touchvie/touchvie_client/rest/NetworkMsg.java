package com.touchvie.touchvie_client.rest;

/**
 * Created by Tagsonomy S.L. on 04/10/2016.
 */

/*
* Implements all the HTTP response codes management.
*/
public class NetworkMsg {

    public final static int OK = 200;
    public final static int BAD_REQUEST = 400;
    public final static int UNAUTHORIZED = 401; //user not authorized or token expired; Go to login page.
    public final static int METHOD_NOT_ALLOWED = 405; //Method (GET, POST, PUT, DELETE)not supported by this service.
    public final static int CONFLICT = 409;
    public final static int PRECONDITION_FAILED = 412;
    public final static int UNPROCESABLE_ENTITY = 422;
    public final static int TOO_MANY_REQUESTS = 429; //The application has overcome the maximun number of request. No request allowed till some time.
    public final static int INTERNAL_SERVER_ERROR = 500; //Unexpected error.
    public final static int BAD_GATEWAY = 502; //Load balancer error. Probably an overload problem.
    public final static int SERVICE_UNAVAILABLE = 503; //Service not available.
    public final static int TEMPORARY_REDIRECT = 307;
    public final static int PERMANENT_REDIRECT = 308;
    public final static int NOT_FOUND = 404;


    public static enum REST_SERVICES {
        REG_EMAIL,
        REG_FACEBOOK,
        REG_TWITTER,
        LOG_EMAIL,
        LOG_FACEBOOK,
        LOG_TWITTER,
        RESET_PASSWD,
        NEW_PASSWD,
        CHANGE_PASSWD,
        CHANGE_USERNAME,
        CHANGE_EMAIl,
        DELETE_ACCOUNT,
        SEARCH_FRIEND
    }

}