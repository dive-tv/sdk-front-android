package com.touchvie.touchvie_front.builders;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.LinearLayout;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.touchvie.backend.Card;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_client.interfaces.OauthObjectInterface;
import com.touchvie.touchvie_client.rest.RestManager;
import com.touchvie.touchvie_client.rest.datawrappers.NetworkData;
import com.touchvie.touchvie_client.rest.listeners.CardDataListener;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.Utils;
import com.touchvie.touchvie_front.ui.managers.CardDetailManager;
import com.touchvie.touchvie_front.validators.ModuleValidator;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Class to inherit the card detail builders common methods.
 */
public abstract class BaseCardDetailBuilder<T extends BaseCardDetailBuilder<T>> implements CardDataListener {


    private FragmentManager mManager;
    private LinearLayout mLayout;
    private CardDataListener listener;

    /**
     * Method to get the object of a class derived from BaseCardDetailBuilder.
     *
     * @return
     */
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
    protected CardDetail card;


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

    protected Context context = null;

    private OauthObjectInterface auth;
    /**
     * Default constructor
     */
    public BaseCardDetailBuilder(Context ctx, OauthObjectInterface auth) {
        this.auth = auth;
        context = ctx;
    }

    /**
     * Requests the server the modules for the given card.
     *
     * @param cardID    the card identifier.
     * @param manager   fragment manager.
     * @param container LinearLayout where will show cardDetail.
     * @return
     */
    public void build(String cardID, FragmentManager manager, LinearLayout container) {

        buildDefault = false;
        this.mManager = manager;
        this.mLayout = container;
        requestCard(cardID);
        listener = this;
    }

    /**
     * Requests the server the modules for the given card.
     *
     * @param cardID    the card identifier.
     * @param manager   fragment manager.
     * @param container LinearLayout where will show cardDetail.
     * @return
     */
    public void buildAll(String cardID, FragmentManager manager, LinearLayout container) {

        buildDefault = true;
        this.mManager = manager;
        this.mLayout = container;
        requestCard(cardID);

//        RestManager.getInstance().getCard( "bf1b00c5-b779-3e73-a9f6-1cf836c674e5", listener, auth);

    }


    /**
     * Gets the card data from server
     *
     * @param cardId The card identifier.
     * @return
     */
    protected com.touchvie.backend.carddetail.CardDetail getCardData(String cardId) {
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
     * Create the Card Detail
     */
    protected void composeCardDetail() {

        //First off all get the main section from the dictionary.
        ConfigSection main = idSection.get(mainSectionKey);
        if (main == null) {
            Log.e(this.getClass().getName(), Utils.getError(Utils.ErrorCode.no_main_error));
            return;
        }

        //Compose all the modules with the data.

        new CardDetailManager(context, card, idSection, "main", mManager, mLayout);

/*
        for (String id : idSection.keySet()) {

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

    @Override
    public void onCardDataReceived(CardDetail card) {
        this.card = card;
        composeCardDetail();
    }

    @Override
    public void onCardDataError(NetworkData response) {

    }

    protected T addSection(String sectionId, ConfigSection section) {
        idSection.put(sectionId, section);
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
     */

    private void requestCard(String cardId) {
        String jsonString = null;
        try {
            Resources res = context.getResources();
            InputStream in_s;
            in_s = res.openRawResource(R.raw.card_detail_movie);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            jsonString = new String(b);
        } catch (Exception e) {
            return;
            //jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        }
//        CardDetail cardData = new GsonBuilder().create().fromJson(jsonString, CardDetail.class);
        CardDetail cardData=null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            cardData = mapper.readValue(jsonString, CardDetail.class);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (cardData == null) {
           return;
        }
        onCardReceived(cardData);
    }


    public void onCardReceived(CardDetail card) {
        this.card = card;
        composeCardDetail();
    }

}