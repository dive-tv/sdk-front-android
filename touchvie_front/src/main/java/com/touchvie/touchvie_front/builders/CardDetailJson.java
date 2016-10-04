package com.touchvie.touchvie_front.builders;

import org.json.JSONObject;

/**
 * Class to build a card detail with a configuration json.
 */
public class CardDetailJson extends BaseCardDetailBuilder<CardDetailJson> {

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
        return getThis();
    }

    @Override
    protected CardDetailJson getThis() {
        return this;
    }

}