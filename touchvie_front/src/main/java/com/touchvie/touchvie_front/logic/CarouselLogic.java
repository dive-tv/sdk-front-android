package com.touchvie.touchvie_front.logic;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.Streams;
import com.touchvie.backend.CardData;
import com.touchvie.backend.TypeOfCard;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.data.CarouselCellData;
import com.touchvie.touchvie_front.data.GroupableTree;
import com.touchvie.touchvie_front.ui.fragments.Carousel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Tagsonomy S.L. on 27/09/2016.
 */

public class CarouselLogic {
    private Context context;
    private GroupableTree groupableTree;
    private HashMap<String,HashMap<String,String>> tree;
    private HashMap<String,String> tree1;

    public CarouselLogic(Context context) {
        this.context = context;
        loadGroupable();
    }

    public ArrayList<CarouselCellData> processData(ArrayList<CarouselCard> cards) {
        CarouselCard lastCard = null;
        CarouselCard newCard = null;
        ArrayList<CarouselCellData> cells = new ArrayList<>();
        boolean newCellBool = false;
        int rel=0;

        for (CarouselCard card : cards) {
            if (newCellBool){
                ArrayList<CardData> cellCards= new ArrayList<>();
                CarouselCellData newCell = new CarouselCellData();
            }

            newCard = card;
            if (lastCard==null) {
                cellCards.add(card.getData());
//                tempCell.setCards(cellCards);
//                tempCell.setSceneNr(card.getSceneNumber());
//                cells.add(tempCell);
//                cellCards.clear();
                lastCard = newCard;
                continue;
            }
            if (checkGroupableTree(newCard, lastCard)) {
                cellCards.add(newCard.getData());
                if (newCard.getChildren()!=null) {
                    outerloop:
                    for (int i = 0; i < newCard.getChildren().length; i++) {
                        for (int j = 0; i < newCard.getChildren()[i].getRel_cards().length; j++) {
                            cellCards.add(newCard.getChildren()[i].getRel_cards()[j]);
                            rel++;
                            if (rel == 2)
                                break outerloop;
                        }
                    }
                    newCell.setCards(cellCards);
                    newCell.setSceneNr(card.getSceneNumber());
                    cells.add(newCell);
                    cellCards.clear();
                    continue;
                }
            } else {
                newCell.setCards(cellCards);
                newCell.setSceneNr(lastCard.getSceneNumber());
                cells.add(newCell);
//                cellCards.clear();
//                newCell.getCards().clear();


//                cellCards.add(newCard.getData());

            }
            lastCard = newCard;
        }
        System.out.println("KKKKKKKKKKKKKKKKKK   cellCards:size: " + cellCards.size());
        System.out.println("KKKKKKKKKKKKKKKKKK   cells:size: " + cells.size());
        return cells;
    }

    private boolean checkGroupableTree(CarouselCard card, CarouselCard last) {
        if (tree.get(last.getData().getType())!=null && tree.get(last.getData().getType()).get(card.getData().getType())!=null){
            return true;
        }
        return false;
    }

    ;

    private void loadGroupable() {
        String jsonString = null;
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(R.raw.groupabletree);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            jsonString = new String(b);
        } catch (Exception e) {
            //jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        }
        groupableTree = new GsonBuilder().create().fromJson(jsonString, GroupableTree.class);
        if (groupableTree == null) {
            groupableTree = new GroupableTree();
        }

        tree = new HashMap<>();
        tree1 = new HashMap<>();
        if (groupableTree.getChildren() != null ) {
            if (groupableTree.getChildren().getChildren()!=null){
                tree1.put(groupableTree.getChildren().getTypeOfCard().toString(), groupableTree.getChildren().getChildren().toString());
            } else {
                tree1.put(groupableTree.getChildren().getTypeOfCard().toString(), null);
            }
            tree.put(groupableTree.getTypeOfCard().toString(),tree1);
        }


    }
}
