package com.touchvie.sdkfront.builders;

import com.touchvie.sdkfront.datatypes.JsonDataType;
import com.touchvie.sdkfront.datatypes.ModuleType;
import com.touchvie.sdkfront.ui.CardDetail;
import com.touchvie.sdkfront.ui.Module;
import com.touchvie.sdkfront.ui.Section;

import org.json.JSONObject;

import java.util.*;

/**
 * 
 */
public class BaseCardDetailBuilder {

    /**
     * Default constructor
     */
    public BaseCardDetailBuilder() {
    }

    /**
     * JSON with the style configuration
     */
    public JSONObject styleConfig;

    /**
     * Dictionary with the Modules nested to the Sections
     * Key: Name of the Section
     * Value: Section
     */
    public HashMap<String, ConfigSection> sectionModules;


    /**
     * Fill the Modules with the data from the server, validate them and build the Card Detail.
     * callback: function to be called when the card detail is done.
     * @param cardID  the card identifier.
     * @param listener the object to be notified when the card detail is built.
     * @return
     */
    public CardDetail build(String cardID, CardDetailListener listener) {
        // TODO implement here
        return null;
    }

    /**
     * Create new Module
     * @param modType the module that will be created.
     * @param types the identifiers of the data that will be used to build the module
     * @return
     */
    protected Module buildModule(ModuleType modType, JsonDataType[] types) {
        // TODO implement here
        return null;
    }

    /**
     * Create new Section
     * @param modules 
     * @return
     */
    protected Section buildSection(Set<Module> modules) {
        // TODO implement here
        return null;
    }

    /**
     * Get Data from server
     * @param param 
     * @return
     */
 /*   protected CardData getCardData(Set<String> param) {
        // TODO implement here
        return null;
    }*/

    /**
     * Load the style configuration from a JSON file
     * @param styleConfig
     * @return
     */
    public CardDetailBuilder loadStyleConfig(JSONObject styleConfig) {
        // TODO implement here
        return null;
    }

    protected BaseCardDetailBuilder showAll(){
        return this;
    }

    protected BaseCardDetailBuilder addSection(){
        return this;
    }


    public interface CardDetailListener{

        void onCardDetailCreated(CardDetail cardDetail);
    }

}