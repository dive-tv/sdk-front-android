package com.touchvie.touchvie_client.data;

import com.touchvie.backend.Card;
import com.touchvie.backend.CardData;
import com.touchvie.backend.Relation;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class CarouselCard {

    /************For testing purposes only ***********************/

    private String cardId;
    private int sceneId;

     /*************************************************************/

    /**
     * The card data received from the server.
     */
    private CardData data;

    /**
     * The cards that are related to this card.
     */
    private Relation[] children;

    /**
     * The number of scene this card is in
     */
    private int sceneNumber;

    /**
     * Gets the data of this card.
     * @return
     */
    public CardData getData() {
        return data;
    }

    /**
     * Sets this card's data.
     * @param data The data to be set.
     */
    public void setData(CardData data) {
        this.data = data;
    }

    /**
     * Gets the cards related to this card.
     * @return
     */
    public Relation[] getChildren() {
        return children;
    }

    /**
     * Sets the card related to this card.
     * @param children The related cards to be set.
     */
    public void setChildren(Relation[] children) {
        this.children = children;
    }


    /*************************For testing purposes only ********************************/

    public String getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {

        this.cardId = Integer.toString(cardId);;
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    /********************************************************************************/

    public int getSceneNumber() {
        return sceneNumber;
    }

    public void setSceneNumber(int sceneNumber) {
        this.sceneNumber = sceneNumber;
    }
}
