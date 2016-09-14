package com.touchvie.sdkfront.builders;

import java.util.*;

/**
 * 
 */
public class CardDetailBuilder extends BaseCardDetailBuilder {

    /**
     * Default constructor
     */
    public CardDetailBuilder() {
    }

    /**
     *
     * @return
     */
    public CardDetailBuilder showAll(){

        return (CardDetailBuilder) super.showAll();
    }

    /**
     *
     * @return
     */
    public CardDetailBuilder addSection(){

        return (CardDetailBuilder) super.addSection();
    }

}