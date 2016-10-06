package com.touchvie.touchvie_front.logic;

import android.content.Context;
import android.content.res.Resources;

import com.google.gson.GsonBuilder;
import com.touchvie.backend.CardData;
import com.touchvie.touchvie_client.data.CarouselCard;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.data.CarouselCell;
import com.touchvie.touchvie_front.data.GroupableTree;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tagsonomy S.L. on 27/09/2016.
 */

public class CarouselLogic {
    private Context context;
    private GroupableTree groupableTree;
    private HashMap<String, HashMap<String, String>> tree;
    private HashMap<String, String> tree1;

    public CarouselLogic(Context context) {
        this.context = context;
        loadGroupable();
    }

    public ArrayList<CarouselCell> processData(ArrayList<CarouselCard> cards) {
        CarouselCard lastCard = null;
        CarouselCard newCard = null;
        ArrayList<CarouselCell> cells = new ArrayList<>();
        ArrayList<CardData> cellCards = null;
        CarouselCell newCell = null;
        boolean setNewCell = true;
        int rel = 0;

        for (CarouselCard card : cards) {
            if (setNewCell) {
                newCell = new CarouselCell();
                cellCards = new ArrayList<>();
            }

            newCard = card;
            if (lastCard == null) {
                CardData temp;
                temp = card.getData();
                cellCards.add(temp);
                lastCard = newCard;
                setNewCell = false;
                continue;
            }
            if (checkGroupableTree(newCard, lastCard)) {
                CardData temp;
                temp = newCard.getData();
                cellCards.add(temp);
                if (newCard.getChildren() != null) {
                    outerloop:
                    for (int i = 0; i < newCard.getChildren().length - 1; i++) {
                        for (int j = 0; i < newCard.getChildren()[i].getRelated().length - 1; j++) {
                            CardData temp2;
                            temp2 = newCard.getChildren()[i].getRelated()[j];
                            cellCards.add(temp2);
                            rel++;
                            if (rel == 2)
                                break outerloop;
                        }
                    }
                    ArrayList<CardData> tempNewCell;
                    tempNewCell = cellCards;
                    newCell.setCards(tempNewCell);
                    newCell.setSceneNr(card.getSceneNumber());
                    cellCards = null;
                    cells.add(newCell);
//                    cellCards.clear();
                    setNewCell = true;
                    continue;
                } else {
                    if (cellCards.size() < 2)
                        setNewCell = false;
                    else
                        setNewCell = true;
                }
            } else {
                ArrayList<CardData> temp;
                temp = cellCards;
                newCell.setCards(temp);
                newCell.setSceneNr(lastCard.getSceneNumber());
                cells.add(newCell);
                newCell = new CarouselCell();
                cellCards = new ArrayList<>();
                CardData temp2;
                temp2 = newCard.getData();
                cellCards.add(temp2);
                if (newCard.getChildren() != null) {
                    outerloop:
                    for (int i = 0; i < newCard.getChildren().length - 1; i++) {
                        for (int j = 0; i < newCard.getChildren()[i].getRelated().length - 1; j++) {
                            CardData temp3;
                            temp3 = newCard.getChildren()[i].getRelated()[j];
                            cellCards.add(temp3);
                            rel++;
                            if (rel == 2)
                                break outerloop;
                        }
                    }
                    ArrayList<CardData> tempNewCell;
                    tempNewCell = cellCards;
                    newCell.setCards(tempNewCell);
                    newCell.setSceneNr(card.getSceneNumber());
                    cellCards = null;
                    cells.add(newCell);
                    setNewCell = true;
                    continue;
                } else {
                    if (cellCards.size() < 2)
                        setNewCell = false;
                    else
                        setNewCell = true;
                }
            }
            lastCard = newCard;
        }
        return cells;
    }

    private boolean checkGroupableTree(CarouselCard card, CarouselCard last) {
        if (tree.get(last.getData().getType()) != null && tree.get(last.getData().getType()).get(card.getData().getType()) != null) {
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
            return;
            //jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        }
        groupableTree = new GsonBuilder().create().fromJson(jsonString, GroupableTree.class);
        if (groupableTree == null) {
            groupableTree = new GroupableTree();
        }

        tree = new HashMap<>();
        tree1 = new HashMap<>();
        for (int i = 0; i < groupableTree.getTrees().length; i++) {
            if (groupableTree.getTrees()[i].getChildren() != null && groupableTree.getTrees()[i].getChildren().length >0 ) {
                if (groupableTree.getTrees()[i].getChildren()[0].getChildren() != null && groupableTree.getTrees()[i].getChildren()[0].getChildren().length>0) {
                    tree1.put(groupableTree.getTrees()[i].getChildren()[0].getTypeOfCard().toString(), groupableTree.getTrees()[i].getChildren()[0].getChildren()[0].getTypeOfCard().toString());
                } else {
                    tree1.put(groupableTree.getTrees()[i].getChildren()[0].getTypeOfCard().toString(), null);
                }
                tree.put(groupableTree.getTrees()[i].getTypeOfCard().toString(), tree1);
            }
        }


    }
}
