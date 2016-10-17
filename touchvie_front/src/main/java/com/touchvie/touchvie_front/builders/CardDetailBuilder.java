package com.touchvie.touchvie_front.builders;

import android.content.Context;

/**
 * Class to build a card detail without a configuration json.
 */
public class CardDetailBuilder extends BaseCardDetailBuilder<CardDetailBuilder> {

    /**
     * Default constructor
     */
    public CardDetailBuilder(Context context) {
        super(context);
    }


    /**
     * Makes parent addSection method public.
     * @return
     */
    public CardDetailBuilder addSection(String sectionId, ConfigSection section){
        return super.addSection(sectionId, section);
    }

    @Override
    protected CardDetailBuilder getThis() {
        return this;
    }
}