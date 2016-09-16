package com.touchvie.sdk_front.builders;

/**
 * 
 */
public class CardDetailBuilder extends BaseCardDetailBuilder<CardDetailBuilder> {

    /**
     * Default constructor
     */
    public CardDetailBuilder() {
    }


    /**
     * Makes parent addSection method public.
     * @return
     */
    public CardDetailBuilder addSection(String sectionId, ConfigSection section, boolean isMain){

        return super.addSection(sectionId, section, isMain);
    }

    @Override
    protected CardDetailBuilder getThis() {
        return this;
    }
}