package com.touchvie.touchvie_front.builders;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.gson.GsonBuilder;
import com.touchvie.backend.CardData;
import com.touchvie.backend.DataConfig;

import com.touchvie.touchvie_front.Utils;
import com.touchvie.touchvie_front.ui.CardDetail;

import com.touchvie.touchvie_client.listeners.CardDataListener;

import com.touchvie.touchvie_front.ui.fragments.Section;

import com.touchvie.touchvie_front.validators.ModuleValidator;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;

import static com.touchvie.touchvie_front.ui.fragments.Section.SectionType.recycler_view;

/**
 * Class to inherit the card detail builders common methods.
 */
public abstract class BaseCardDetailBuilder<T extends BaseCardDetailBuilder<T>> implements CardDataListener {


    protected abstract T getThis();

    /**
     * JSON with the style configuration: colors, fonts...
     */
    protected JSONObject styleConfig;


    /**
     * Dictionary with the config sections created for the card detail without beeing validated.
     * Key: Name of the section
     * Value: section
     */
    protected HashMap<String, ConfigSection> idSection;

    /**
     * Data received from the server.
     */
    protected CardData data;


    /**
     * Key to the main section of the card detail.
     */
    protected String mainSectionKey = "main";


    /**
     * Sets wheter the card detail must show all the modules by default or not.
     */
    protected boolean buildDefault = false;


    /**
     * Object to validate the modules to be added.
     */
    protected ModuleValidator validator = null;

    private Context context = null;

    /**
     * Default constructor
     */
    public BaseCardDetailBuilder() {
    }

    /**
     * Requests the server the modules for the given card.
     *
     * @param cardID    the card identifier.
     * @param manager   fragment manager.
     * @param container LinearLayout where will show cardDetail.
     * @param ctx       the application context.
     * @return
     */
    public void build(String cardID, FragmentManager manager, LinearLayout container, Context ctx) {

        buildDefault = false;
        context = ctx;
        requestCard(cardID, manager, container);

    }

    /**
     * Requests the server the modules for the given card.
     *
     * @param cardID    the card identifier.
     * @param manager   fragment manager.
     * @param container LinearLayout where will show cardDetail.
     * @param ctx       the application context.
     * @return
     */
    public void buildAll(String cardID, FragmentManager manager, LinearLayout container, Context ctx) {

        buildDefault = true;
        context = ctx;
        System.out.println("KKKKKKKKKK BaseCardDetailBuilder buildAll");
        requestCard(cardID, manager, container);

    }


    /**
     * Gets the card data from server
     *
     * @param cardId The card identifier.
     * @return
     */
    protected CardData getCardData(String cardId) {
        return null;
    }

    /**
     * Loads the style configuration from a JSON file
     *
     * @param styleConfig A JSON containing all the style information for the card to be built.
     * @return
     */
    public T loadStyleConfig(JSONObject styleConfig) {
        return getThis();
    }

    /**
     * @param manager   fragment manager.
     * @param container LinearLayout where will show cardDetail.
     */
    protected void composeCardDetail(FragmentManager manager, LinearLayout container) {
        System.out.println("KKKKKKKKKK BaseCardDetailBuilder composeCardDetail ");

        requestDataConfig();

        //First off all get the main section from the dictionary.
        ConfigSection main = idSection.get(mainSectionKey);
        if (main == null) {
            Log.e(this.getClass().getName(), Utils.getError(Utils.ErrorCode.no_main_error));
            return;
        }

        //Compose all the modules with the data.

        CardDetail cardDetail = new CardDetail(context, data, idSection, "main",manager, container);

/*
        for (String id : idSection.keySet()) {
            System.out.println("KKKKKKKKKK BaseCardDetailBuilder idSction for " + id);
            ConfigSection section = idSection.get(id);
            for (ConfigModule module : section.getConfigModules()) {
                if (true */
            /*ModuleValidator.validate(data, module )*//*
            ) {
                    cardDetail.setSection(section);
                }
            }
        }
*/

    }

    /**
     * CallBack of data received
     *
     * @param data      Carddata
     * @param manager   fragment manager.
     * @param container LinearLayout where will show cardDetail.
     */
    @Override
    public void onCardReceived(CardData data, FragmentManager manager, LinearLayout container) {

        this.data = data;
        composeCardDetail(manager, container);
    }

    protected T addSection(String sectionId, ConfigSection section, boolean isMain) {
        return getThis();
    }

    protected String getMainSectionKey() {
        return mainSectionKey;
    }

    protected void setMainSectionKey(String mainSectionKey) {
        this.mainSectionKey = mainSectionKey;
    }


    /**
     * FOR TESTING PURPOSES
     *
     * @param cardId    Card identifier.
     * @param manager   fragment manager.
     * @param container LinearLayout where will show cardDetail.
     */

    private void requestCard(String cardId, FragmentManager manager, LinearLayout container) {
        String jsonString = null;
        try {
            Resources res = context.getResources();
            InputStream in_s;
            if("1".equals(cardId)) {
                in_s = res.openRawResource(R.raw.gastronomy);
            }
            else{
                in_s = res.openRawResource(R.raw.vehicle);
            }
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            jsonString = new String(b);
        } catch (Exception e) {
            //jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        }
        CardData cardData = new GsonBuilder().create().fromJson(jsonString, CardData.class);
        if (cardData == null) {
            cardData = new CardData();
        }
        System.out.println("KKKKKKKKKK BaseCardDetailBuilder request " + cardData.getCard_id());
        onCardReceived(cardData, manager, container);
    }

    /**
     * FOR TESTING PURPOSES
     */

    private void requestDataConfig() {
        String jsonString = null;
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(R.raw.dataconfig);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            jsonString = new String(b);
        } catch (Exception e) {
            //jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        }
        DataConfig dataConfig = new GsonBuilder().create().fromJson(jsonString, DataConfig.class);
        if (dataConfig == null) {
            dataConfig = new DataConfig();
        }

        idSection = new HashMap<>();
        if (dataConfig.getSections() != null && dataConfig.getSections().length > 0) {
            for (int i = 0; i < dataConfig.getSections().length; i++) {
                idSection.put((dataConfig.getSections()[i]).getTitle(), dataConfig.getSections()[i]);
            }
        }
        System.out.println("KKKKKKKKKK BaseCardDetailBuilder requestDataConfig " + idSection.size());

    }
}