package com.touchvie.touchvie_front.ui;


import java.util.*;

/**
 * 
 */
public class CardDetail {

    /**
     * Default constructor
     */
    public CardDetail() {
    }

    /**
     * Card Type
     */
    public int type;

    /**
     * Dictionary of Sections in the Card
     * Key: Section name
     * Value: Section
     */
    public HashMap<String,Section> sections;




    /**
     * Set the Card Type
     * @param type 
     * @return
     */
    public void setType(int type) {
        // TODO implement here
    }

    /**
     * Get the Card Type
     * @return
     */
    public int getType() {
        // TODO implement here
        return type;
    }

    /**
     * Create new Section
     * @param section 
     * @return
     */
    public void setSection(Section section) {
        if(section==null){
            return;
        }


        // TODO implement here
    }

    /**
     * Set multiple sections at once
     * @param sections
     * @return
     */
    public void setSections(HashMap<String, Section> sections) {
        // TODO implement here
    }

    /**
     * Get the sections
     * @return
     */
    public HashMap<String, Section> getSections() {
        // TODO implement here
        return sections;
    }

}