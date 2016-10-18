package com.touchvie.touchvie_front.ui.utils;

import android.content.Context;
import android.graphics.Typeface;

import com.touchvie.touchvie_front.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tagsonomy S.L. on 15/09/2016.
 */
public class Utils {
    public static final String CARD_DATA = "CARD_DATA";
    public static final String CONFIG_SECTION = "CONFIG_MODULES";
    public static final String SECTION_TYPE = "SECTION_TYPE";
    public static final String CARD_DETAIL_LISTENER = "CARD_DETAIL_LISTENER";
    public static final String FULLSCREEN_FRAGMENT="FULLSCREEN_FRAGMENT";
    public static final String POSITION="POSITION";
    public static final String IMAGES="IMAGES";
    public static final String ROW_DATA="ROW_DATA";

    /*****************************************************************/
    public static final String SWIPE_GALLERY ="SWIPE_GALLERY";
    /*****************************************************************/
    private static Typeface latoBold = null;
    private static Typeface latoLight = null;
    private static Typeface latoRegular = null;
    private static Typeface latoItalic = null;

    /**
     * Constructs the font of a given Typeface from a fonts file.
     *
     * @param context the context
     * @param font    the font
     * @return the font
     * @returns {Typeface} type. The constructed font type.
     */
    public static Typeface getFont(Context context, TypeFaces font) {

        Typeface type;
        switch (font) {

            case LATO_BOLD:
                if (latoBold == null){
                    final String FONT = "lato_bold.ttf";
                    File fontFile = new File(context.getFilesDir(), FONT);
                    if (!fontFile.exists()) {
                        copyFontToInternalStorage(context, fontFile, font);
                    }
                    latoBold =  Typeface.createFromFile(fontFile);
                }
                type = latoBold;
                break;
            case LATO_LIGHT:
                if (latoLight == null){

                    final String FONT = "lato_light.ttf";
                    File fontFile = new File(context.getFilesDir(), FONT);
                    if (!fontFile.exists()) {
                        copyFontToInternalStorage(context, fontFile, font);
                    }
                    latoLight = Typeface.createFromFile(fontFile);
                }

                type = latoLight;
                break;
            case LATO_REGULAR:
                if (latoRegular == null){
                    final String FONT = "lato_regular.ttf";
                    File fontFile = new File(context.getFilesDir(), FONT);
                    if (!fontFile.exists()) {
                        copyFontToInternalStorage(context, fontFile, font);
                    }
                    latoRegular =Typeface.createFromFile(fontFile);
                }

                type = latoRegular;
                break;
            case LATO_ITALIC:
                if (latoItalic == null){
                    final String FONT = "lato_italic.ttf";
                    File fontFile = new File(context.getFilesDir(), FONT);
                    if (!fontFile.exists()) {
                        copyFontToInternalStorage(context, fontFile, font);
                    }
                    latoItalic =Typeface.createFromFile(fontFile);
                }

                type = latoItalic;
                break;
            default:
                if (latoRegular == null){
                    final String FONT = "lato_regular.ttf";
                    File fontFile = new File(context.getFilesDir(), FONT);
                    if (!fontFile.exists()) {
                        copyFontToInternalStorage(context, fontFile, font);
                    }
                    latoRegular =Typeface.createFromFile(fontFile);
                }

                type = latoRegular;
        }
        return type;

    }


    private static void copyFontToInternalStorage(Context context, File font, TypeFaces typeface ) {
        try {

            InputStream is = null;
            switch(typeface){
                case LATO_BOLD:
                    is=context.getResources().openRawResource(R.raw.lato_bold);
                    break;
                case LATO_LIGHT:
                    is=context.getResources().openRawResource(R.raw.lato_light);
                    break;
                case LATO_REGULAR:
                    is=context.getResources().openRawResource(R.raw.lato_regular);
                    break;
                case LATO_ITALIC:
                    is=context.getResources().openRawResource(R.raw.lato_italic);
                    break;
                case LATO_SEMIBOLD:
                    is=context.getResources().openRawResource(R.raw.lato_semibold);
                    break;
            }

            byte[] buffer = new byte[4096];
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(font));
            int readByte;
            while ((readByte = is.read(buffer)) > 0) {
                bos.write(buffer, 0, readByte);
            }
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * The enum Type faces.
     */
    public static enum TypeFaces {

        /**
         * Lato bold type face.
         */
        LATO_BOLD,
        /**
         * Lato light type face.
         */
        LATO_LIGHT,
        /**
         * Lato regular type face.
         */
        LATO_REGULAR,
        /**
         * Lato italic type face.
         */
        LATO_ITALIC,

        /**
         * Lato italic type face.
         */
        LATO_SEMIBOLD,


    }

    public static String getTime(long time, Context context){

        if(time >=60000){
            return String.format("%02d"+context.getString(R.string.hours_short)+" %02d"+context.getResources().getString(R.string.minutes_short),
                    TimeUnit.SECONDS.toHours(time),
                    TimeUnit.SECONDS.toMinutes(time) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(time)));
        }else{
            return String.format("%02d "+context.getResources().getString(R.string.minutes),
                    TimeUnit.SECONDS.toHours(time),
                    TimeUnit.SECONDS.toMinutes(time) -
                            TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(time)));
        }

    }

}
