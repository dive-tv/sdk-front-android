package com.touchvie.touchvie_front.ui;


import android.support.v4.app.FragmentManager;
import android.widget.LinearLayout;

import com.touchvie.touchvie_front.builders.ConfigSection;

import java.util.*;

/**
 * 
 */
public class CardDetail {

    /**
     * Default constructor
     */
    public CardDetail(FragmentManager manager, LinearLayout container) {
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
    public HashMap<String,ConfigSection> sections;




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
    public void setSection(ConfigSection section) {

        sections.put(section.getTitle(), section);
    }

    /**
     * Set multiple sections at once
     * @param sections
     * @return
     */
    public void setSections(HashMap<String, ConfigSection> sections) {
        // TODO implement here
    }

    /**
     * Get the sections
     * @return
     */
    public HashMap<String, ConfigSection> getSections() {
        // TODO implement here
        return sections;
    }

}