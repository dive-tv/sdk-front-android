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
public abstract class BaseCardDetailBuilder <T extends BaseCardDetailBuilder<T>>{


    protected abstract T getThis();

    /**
     * JSON with the style configuration
     */
    public JSONObject styleConfig;

    /**
     * Dictionary with the modules nested to the sections
     * Key: Name of the section
     * Value: section
     */
    public HashMap<String, ConfigSection> idSection;


    /**
     * Default constructor
     */
    public BaseCardDetailBuilder() {
    }

    /**
     * Fill the modules with the data from the server, validate them and build the card detail.
     * callback: function to be called when the card detail is done.
     * @param cardID  the card identifier.
     * @param listener the object to be notified when the card detail is built.
     * @return
     */
    public void build(String cardID, CardDetailListener listener) {
        // TODO implement here

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
    public T loadStyleConfig(JSONObject styleConfig) {
        // TODO implement here
        return getThis();
    }

    /**
     *
     * @return
     */
    protected T showAll(){
        return getThis();
    }

    protected T addSection(){
        return getThis();
    }


    public interface CardDetailListener{

        void onCardDetailCreated(CardDetail cardDetail);
    }


}