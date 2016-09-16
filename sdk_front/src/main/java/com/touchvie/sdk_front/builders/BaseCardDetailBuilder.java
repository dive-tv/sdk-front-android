package com.touchvie.sdk_front.builders;

import com.touchvie.backend.CardData;
import com.touchvie.sdk_front.datatypes.JsonDataType;
import com.touchvie.sdk_front.datatypes.ModuleType;
import com.touchvie.sdk_front.ui.CardDetail;
import com.touchvie.sdk_front.ui.Section;
import com.touchvie.listeners.CardDataListener;
import com.touchvie.sdk_front.ui.Module;

import org.json.JSONObject;

import java.util.*;

/**
 * Class to inherit the card detail builders common methods.
 */
public abstract class BaseCardDetailBuilder <T extends BaseCardDetailBuilder<T>> implements CardDataListener{


    protected abstract T getThis();

    /**
     *
     */
    protected CardDetailListener listener=null;

    /**
     * JSON with the style configuration
     */
    protected JSONObject styleConfig;

    /**
     * Dictionary with the modules nested in sections
     * Key: Name of the section
     * Value: section
     */
    protected HashMap<String, ConfigSection> idSection;

    protected CardData data;


    /**
     *
     */
    protected String mainSectionKey= "main";


    protected boolean buildDefault=false;
    /**
     * Default constructor
     */
    public BaseCardDetailBuilder() {
    }

    /**
     * Requests the server the modules for the given card.
     * @param cardID  the card identifier.
     * @param listener the object to be notified when the card detail is built.
     * @return
     */
    public void build(String cardID, CardDetailListener listener) {

        buildDefault=false;
        this.listener=listener;
        //requestCard(cardId)

    }

    public void buildAll(String cardID, CardDetailListener listener) {

        buildDefault=true;
        this.listener=listener;
        //requestCard(cardId)

    }


    /**
     * Creates a new module
     * @param modType the type of the module that will be created.
     * @param dataTypes the identifiers of the data that will be used to build the module
     * @return
     */
    protected Module buildModule(ModuleType modType, JsonDataType[] dataTypes) {
        // TODO implement here
        return null;
    }

    /**
     * Creates a new section
     * @param section
     * @return
     */
    protected Section buildSection(ConfigSection section) {

        for(ConfigModule config: section.getModulesConfig() ){

                ModuleType type= config.getModuleType();
                if(!Module.validate(data, type.toString() )){
                    continue;
                }


        }
        return null;
    }

    /**
     * Gets the card data from server
     * @param param 
     * @return
     */
    protected CardData getCardData(Set<String> param) {
        // TODO implement here. Get it from local while the server does not implement this method.
        return null;
    }

    /**
     * Loads the style configuration from a JSON file
     * @param styleConfig A JSON containing all the style information for the card to be built.
     * @return
     */
    public T loadStyleConfig(JSONObject styleConfig) {
        // TODO implement here
        return getThis();
    }

    protected void composeCardDetail(){

        //First off all get the main section from the dictionary.
        ConfigSection main = idSection.get(mainSectionKey);
        if(main == null){
            listener.onCardDetailError();
            return;
        }

        //Compose all the modules with the data.

        CardDetail cardDetail= new CardDetail();
        cardDetail.setSection(buildSection(main));

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


    public interface CardDetailListener{

        void onCardDetailCreated(CardDetail cardDetail);
        void onCardDetailError();
    }


}