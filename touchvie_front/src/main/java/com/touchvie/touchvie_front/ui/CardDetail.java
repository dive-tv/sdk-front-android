package com.touchvie.touchvie_front.ui;


import android.os.Parcel;
import android.support.v4.app.FragmentManager;
import android.widget.LinearLayout;

import com.touchvie.backend.CardData;
import com.touchvie.touchvie_front.builders.ConfigModule;
import com.touchvie.touchvie_front.builders.ConfigSection;
import com.touchvie.touchvie_front.ui.fragments.Section;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;

import java.util.HashMap;

/**
 *
 */
public class CardDetail implements CardDetailListener {

    /**
     * Card Type
     */
    public int type;

    /**
     * Dictionary of Sections in the Card
     * Key: Section name
     * Value: Section
     */
    public HashMap<String, ConfigSection> sections = new HashMap<>();

    private final FragmentManager mFragmentManager;
    private final LinearLayout container;
    private String mainSection;
    private CardData data;

    /**
     * Default constructor
     *
     * @param data
     * @param idSection
     * @param mainKey
     * @param manager   :   fragment manager
     * @param container : Linear layout
     */
    public CardDetail(CardData data, HashMap<String, ConfigSection> idSection, String mainKey, FragmentManager manager, LinearLayout container) {
        System.out.println("KKKKKKKKKK CardDetail new carddetail ");
        this.mFragmentManager = manager;
        this.container = container;
        this.data = data;

        for (String id : idSection.keySet()) {
            System.out.println("KKKKKKKKKK BaseCardDetailBuilder idSction for " + id);
            ConfigSection section = idSection.get(id);
            for (ConfigModule module : section.getConfigModules()) {
                if (true /*ModuleValidator.validate(data, module )*/) {
                    setSection(section);
                    if (section.isMain()) {
                        mainSection = id;
                    }
                }
            }
        }

        Section newSection = Section.newInstance(this.data, sections.get(mainSection), Section.SectionType.recycler_view, this);
        mFragmentManager.beginTransaction().replace(this.container.getId(), newSection).addToBackStack(mainSection).commit();
    }

    /**
     * Set the Card Type
     *
     * @param type
     * @return
     */
    public void setType(int type) {
        // TODO implement here
    }

    /**
     * Get the Card Type
     *
     * @return
     */
    public int getType() {
        // TODO implement here
        return type;
    }

    /**
     * Create new Section
     *
     * @param section
     * @return
     */
    public void setSection(ConfigSection section) {
        sections.put(section.getTitle(), section);
    }

    /**
     * Set multiple sections at once
     *
     * @param sections
     * @return
     */
    public void setSections(HashMap<String, ConfigSection> sections) {
        // TODO implement here
    }

    /**
     * Get the sections
     *
     * @return sections
     */
    public HashMap<String, ConfigSection> getSections() {
        return sections;
    }

    @Override
    public void goToSection(String sectionName) {
        if(sections.containsKey(sectionName)){
            Section newSection = Section.newInstance(data, sections.get(sectionName), Section.SectionType.recycler_view, this);
            mFragmentManager.beginTransaction().replace(this.container.getId(), newSection).addToBackStack(mainSection).commit();

        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}