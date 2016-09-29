package com.touchvie.touchvie_front.managers;

import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_client.listeners.CarouselCardListener;
import com.touchvie.touchvie_front.data.Scene;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class SceneManager implements CarouselCardListener{

    private HashMap<Integer, ArrayList<CarouselCard>> scenes;
    private Integer currentScene=null;
    private Integer sectionToPreload=null;

    private ArrayList<CarouselCard> orphanedCards;

    //***************** for testing purposes ************************************//

    private int preloadSectionCardIndex=0;

    //***********************************************************************


    public SceneManager(){
        scenes=new HashMap<>();
    }



    /**
     * Listener to be reported about a section end.
     * @param sectionId The id of the section received.
     */
    @Override
    public void onSectionEndReceived(Integer sectionId) {


    }



    @Override
    public void onCardsForPreloadReceived(ArrayList<CarouselCard> cards) {

        if(cards==null || cards.size()<=0){
            return;
        }

        for(CarouselCard card: cards){
            ArrayList<CarouselCard> sceneCards=scenes.get(card.getSceneId());
            if(sceneCards ==null){
                sceneCards= new ArrayList<>();
                scenes.put(card.getSceneId(), sceneCards);
            }
            sceneCards.add(card);
        }
    }

    @Override
    public void onCardsForPaintReceived(ArrayList<String> cardIds) {
    }

    /**
     * Listener to be reported about a section start.
     * @param sectionId The id of the section to be received.
     */

    @Override
    public void onSectionStartReceived(Integer sectionId) {


    }

}
