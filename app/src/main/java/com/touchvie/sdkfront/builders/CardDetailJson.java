package com.touchvie.sdkfront.builders;

import org.json.JSONObject;

import java.util.*;

/**
 * 
 */
public class CardDetailJson extends BaseCardDetailBuilder {

    /**
     * Default constructor
     */
    public CardDetailJson() {
    }

    /**
     * JSON with formatted with the Section and Modules order
     */
    public JSONObject config;


    /**
     * Load Sections and Modules order directly from a JSON file
     * @param dataConfig
     * @return
     */
    public CardDetailJson loadDataConfig(JSONObject dataConfig) {
        // TODO implement here
        return null;
    }

}