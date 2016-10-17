package com.touchvie.touchvie_front.managers;

import android.content.Context;
import android.os.Handler;

import com.squareup.picasso.Picasso;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_client.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.Utils;
import com.touchvie.touchvie_front.logic.CarouselLogic;
import com.touchvie.touchvie_front.ui.listeners.CarouselListener;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class SceneManager implements CarouselCardListener {

    private final Handler handler;
    private HashMap<Integer, ArrayList<String>> scenes;
    private HashMap<String, CarouselCard> cards;
    private Integer currentScene = null;
    private Integer sectionToPreload = null;
    private Picasso mPicasso = null;
    private ArrayList<CarouselCard> orphanedCards;
    private Context context;
    private CarouselLogic carouselLogic;
    private CarouselListener carouselListener;


    //***************** for testing purposes ************************************//

    private int preloadSectionCardIndex = 0;

    //***********************************************************************


    public SceneManager(Context context, Handler handler) {
        this.context = context;
        this.handler = handler;
//        this.carouselListener = carousel;
        this.mPicasso = Picasso.with(context);
        carouselLogic = new CarouselLogic(context);
        scenes = new HashMap<>();
        cards = new HashMap<>();

    }


    /**
     * Listener to be reported about a section end.
     *
     * @param sectionId The id of the section received.
     */
    @Override
    public void onSectionEndReceived(Integer sectionId) {


    }


    @Override
    public void onCardsForPreloadReceived(ArrayList<CarouselCard> cardsToPreload) {

        if (cardsToPreload == null || cardsToPreload.size() <= 0) {
            return;
        }

        for (CarouselCard card : cardsToPreload) {
            ArrayList<String> sceneCards = scenes.get(card.getSceneId());
            if (sceneCards == null) {
                sceneCards = new ArrayList<>();
                scenes.put(card.getSceneId(), sceneCards);
            }
            sceneCards.add(card.getCardId());
            cards.put(card.getCardId(), card);
            mPicasso.load(card.getData().getMiniCard().getImage().getFull()).fetch();
            if (card.getChildren()!=null && card.getChildren().length>0){
                int maxRel = (card.getChildren().length>=2?2:card.getChildren().length);
              /*  for (int i=0;i<maxRel;i++){
                    if (card.getChildren()[i]!=null && card.getChildren()[i].getRelated()!=null && card.getChildren()[i].getRelated()[0].getImage()!=null)
                        mPicasso.load(card.getChildren()[i].getRelated()[0].getImage().getFull()).fetch();
                }*/
            }
        }
    }

    @Override
    public void onCardsForPaintReceived(ArrayList<String> cardIds) {
        if (cardIds==null ||cardIds.size()<=0)
            return;
        ArrayList<CarouselCard> cardsToPush = new ArrayList<>();

        for (String ids: cardIds ) {
            cardsToPush.add(cards.get(ids));
        }
        handler.sendMessage(handler.obtainMessage(Utils.PUSH,carouselLogic.processData(cardsToPush)));
//        carouselListener.onRowsToDraw(carouselLogic.processData(cardsToPush));
    }

    /**
     * Listener to be reported about a section start.
     *
     * @param sectionId The id of the section to be received.
     */

    @Override
    public void onSectionStartReceived(Integer sectionId) {


    }

}
