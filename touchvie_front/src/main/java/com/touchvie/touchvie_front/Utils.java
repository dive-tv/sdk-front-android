package com.touchvie.touchvie_front;

import java.util.Random;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class Utils {
    public final static int PUSH=1;

    private static final String NO_MAIN_ERROR ="No main section defined";

    public enum ErrorCode {
        no_main_error(NO_MAIN_ERROR);

        private String error;
        ErrorCode(String error) {
            this.error=error;
        }

        public String getError() {
            return error;
        }
    }


    /**
     * Gets the string of an error code.
     * @param errorCode The code of an error.
     * @return
     */
    public static String getError( ErrorCode errorCode){

        return errorCode.getError();

    }


    /**
     * Returns a psuedo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimim value
     * @param max Maximim value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


}
