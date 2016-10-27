package com.touchvie.touchvie_client.data;

import com.touchvie.backend.MiniCard;
import com.touchvie.backend.carddetail.relations.Relation;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class CarouselCard {

    /************
     * For testing purposes only
     ***********************/

    private String cardId;
    private int sceneId;

    /*************************************************************/

    /**
     * The card data received from the server.
     */
    private MiniCard miniCard;

    /**
     * The cards that are related to this card.
     */
    private Relation[] relations;

    /**
     * The number of scene this card is in
     */
    private int sceneNumber;

    public MiniCard getMiniCard() {
        return miniCard;
    }

    public void setMiniCard(MiniCard miniCard) {
        this.miniCard = miniCard;
    }

    /**
     * Gets the cards related to this card.
     *
     * @return
     */
    public Relation[] getRelations() {
        return relations;
    }

    /**
     * Sets the card related to this card.
     *
     * @param relations The related cards to be set.
     */
    public void setRelations(Relation[] relations) {
        this.relations = relations;
    }


    /*************************
     * For testing purposes only
     ********************************/

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {

        this.cardId = cardId;
    }

    public int getSceneNumber() {
        return sceneNumber;
    }

    public void setSceneNumber(int sceneNumber) {
        this.sceneNumber = sceneNumber;
    }
}
