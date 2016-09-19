package com.touchvie.touchvie_front.builders;

import android.util.Log;

import com.touchvie.backend.CardData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.Utils;
import com.touchvie.touchvie_front.datatypes.JsonDataType;
import com.touchvie.touchvie_front.datatypes.ModuleType;
import com.touchvie.touchvie_front.ui.CardDetail;
import com.touchvie.touchvie_front.ui.Section;
import com.touchvie.touchvie_client.CardDataListener;
import com.touchvie.touchvie_front.ui.Module;
import com.touchvie.touchvie_front.validators.ModuleValidator;

import org.json.JSONObject;

import java.util.*;

/**
 * Class to inherit the card detail builders common methods.
 */
public abstract class BaseCardDetailBuilder <T extends BaseCardDetailBuilder<T>> implements CardDataListener{


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
    protected String mainSectionKey= "main";


    /**
     * Sets wheter the card detail must show all the modules by default or not.
     */
    protected boolean buildDefault=false;


    /**
     * Object to validate the modules to be added.
     */
    protected ModuleValidator validator=null;


    /**
     * Default constructor
     */
    public BaseCardDetailBuilder() {
    }

    /**
     * Requests the server the modules for the given card.
     * @param cardID  the card identifier.
     * @return
     */
    public void build(String cardID, JSONObject customValidator) {

        buildDefault=false;

        //requestCard(cardId)

    }

    /**
     * Requests the server the modules for the given card.
     * @param cardID  the card identifier.
     * @return
     */
    public void buildAll(String cardID,JSONObject customValidator ) {

        buildDefault=true;

        //requestCard(cardId)

    }


    /**
     * Gets the card data from server
     * @param cardId The card identifier.
     * @return
     */
    protected CardData getCardData(String cardId) {
        return null;
    }

    /**
     * Loads the style configuration from a JSON file
     * @param styleConfig A JSON containing all the style information for the card to be built.
     * @return
     */
    public T loadStyleConfig(JSONObject styleConfig) {
        return getThis();
    }

    protected void composeCardDetail(){

        //First off all get the main section from the dictionary.
        ConfigSection main = idSection.get(mainSectionKey);
        if(main == null){
            Log.e(this.getClass().getName(), Utils.getError(Utils.ErrorCode.no_main_error));
            return;
        }

        //Compose all the modules with the data.

        CardDetail cardDetail= new CardDetail();

        for(String id: idSection.keySet()){

            ConfigSection section= idSection.get(id);

            for(ConfigModule module: section.getModulesConfig()){
                if(true /*ModuleValidator.validate(data, module )*/){
                    cardDetail.setSection(section);
                }
            }
        }

    }

    @Override
    public void onCardReceived(CardData data){

            this.data=data;
            composeCardDetail();
    }

    protected T addSection(String sectionId, ConfigSection section, boolean isMain){
        return getThis();
    }

    protected String getMainSectionKey() {
        return mainSectionKey;
    }

    protected void setMainSectionKey(String mainSectionKey) {
        this.mainSectionKey = mainSectionKey;
    }


}