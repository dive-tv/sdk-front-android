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

    private HashMap<Integer, Scene> scenes;
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
     * Listener to receive each card from the client.
     * @param card Card received.
     */
    @Override
    public void onCardReceived(CarouselCard card) {

        if(currentScene==null){
            if(orphanedCards==null){
                orphanedCards= new ArrayList<>();
                orphanedCards.add(card);
            }
        }else{
            Scene scene= scenes.get(currentScene);
            if(scene==null){
                scene= new Scene();
                scenes.put(currentScene,scene );
            }
            scene.addCarouselCard(card);
        }
    }

    /**
     * Listener to be reported about a section end.
     * @param sectionId The id of the section received.
     */
    @Override
    public void onSectionEndReceived(Integer sectionId) {

        currentScene=null;
        if(orphanedCards !=null){
            Scene scene= scenes.get(sectionId);
            if(scene !=null){
                scene.addCarouselCards(orphanedCards);
            }else{
                scene=new Scene();
                scene.addCarouselCards(orphanedCards);
                scenes.put(sectionId, scene);
            }
            orphanedCards.clear();
        }

    }

    @Override
    public void onSectionPreload(Integer sectionId) {
        sectionToPreload=sectionId;
        preloadSectionCardIndex=0;
        //TODO: apply logic.
    }

    @Override
    public void onDrawCards(String[] cardIds) {
        //TODO: in test mode we just draw a card each time the user calls this method.
        if(scenes==null ){
            return;
        }
        Scene scene= scenes.get(sectionToPreload);
        if(scene==null  ){
            return;
        }
        ArrayList<CarouselCard> cards= scene.getCarouselCards();
        if(cards==null || cards.size()<=preloadSectionCardIndex){
            return;
        }

        CarouselCard drawCard = cards.get(preloadSectionCardIndex);

        System.out.println("Draw card!");
        //TODO: send card to carousel.
        //TODO: it is not the same the card and the rows in carousel. From the card Id we must get all the rows that belong to a card to be drawn.
        preloadSectionCardIndex+=1;

    }

    /**
     * Listener to be reported about a section start.
     * @param sectionId The id of the section to be received.
     */

    @Override
    public void onSectionStartReceived(Integer sectionId) {

        currentScene=sectionId;
        scenes.put(sectionId, new Scene());
    }

}
