package com.touchvie.sdkfront.builders;

import java.util.*;

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
     * Makes parent showAll method public.
     * @return
     */
    public CardDetailBuilder showAll(){

        return (CardDetailBuilder) super.showAll();
    }

    /**
     * Makes parent addSection method public.
     * @return
     */
    public CardDetailBuilder addSection(){

        return (CardDetailBuilder) super.addSection();
    }

    @Override
    protected CardDetailBuilder getThis() {
        return this;
    }
}