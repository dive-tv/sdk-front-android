package com.touchvie.touchvie_front.ui.managers;


import android.content.Context;
import android.os.Parcel;
import android.support.v4.app.FragmentManager;
import android.widget.LinearLayout;

import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.touchvie_client.interfaces.OauthObjectInterface;
import com.touchvie.touchvie_front.builders.BaseCardDetailBuilder;
import com.touchvie.touchvie_front.builders.ConfigModule;
import com.touchvie.touchvie_front.builders.ConfigSection;
import com.touchvie.touchvie_front.ui.fragments.Section;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;

import java.util.HashMap;

/**
 *
 */
public class CardDetailManager implements CardDetailListener  {

    private final CardDetailManager instance;
    private final Context context;
    /**
     * Card Type
     */
    public int type;

    /**
     * Dictionary of Sections in the Card
     * Key: Section name
     * Value: Section
     */
    public HashMap<String, ConfigSection> configSectionsDict = new HashMap<>();

    private final FragmentManager mFragmentManager;
    private final LinearLayout container;
    private String mainSection;
    private CardDetail data;

    /**
     * Default constructor
     *
     * @param context
     * @param data
     * @param idSection
     * @param mainKey
     * @param manager   :   fragment manager
     * @param container : Linear layout
     */
    public CardDetailManager(Context context, CardDetail data, HashMap<String, ConfigSection> idSection, String mainKey, FragmentManager manager, LinearLayout container) {
        this.mFragmentManager = manager;
        this.context = context;
        this.container = container;
        this.data = data;
        instance = this;

        for (String id : idSection.keySet()) {
            ConfigSection section = idSection.get(id);
            for (ConfigModule module : section.getConfigModules()) {
                if (true /*ModuleValidator.validate(data, module )*/) {
                    setConfigSection(section);
                    if (section.isMain()) {
                        mainSection = id;
                    }
                }
            }
        }

        Section newSection = Section.newInstance(this.data, configSectionsDict.get(mainSection), Section.SectionType.recycler_view, instance);
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
    public void setConfigSection(ConfigSection section) {
        configSectionsDict.put(section.getTitle(), section);
    }

    /**
     * Set multiple sections at once
     *
     * @param configSection
     * @return
     */
    public void setConfigSections(HashMap<String, ConfigSection> configSection) {
        // TODO implement here
    }

    /**
     * Get the sections
     *
     * @return sections
     */
    public HashMap<String, ConfigSection> getSections() {
        return configSectionsDict;
    }

    @Override
    public void goToSection(String sectionName) {
        if (configSectionsDict.containsKey(sectionName)) {
            Section newSection = Section.newInstance(data, configSectionsDict.get(sectionName), Section.SectionType.recycler_view, instance);
            mFragmentManager.beginTransaction().replace(this.container.getId(), newSection).addToBackStack(mainSection).commit();
        }
    }

    @Override
    public void goToNewCard(String cardId, OauthObjectInterface auth) {
        BaseCardDetailBuilder cardDetail = new BaseCardDetailBuilder(context, auth) {
            @Override
            protected BaseCardDetailBuilder getThis() {
                return null;
            }
        };
        cardDetail.buildAll(cardId, mFragmentManager, container);

    }

    @Override
    public Section requestSectionForTab(String sectionName) {
        if (configSectionsDict.containsKey(sectionName)) {
            return Section.newInstance(data, configSectionsDict.get(sectionName), Section.SectionType.linear_layout, instance);
        }
        return null;
    }

    @Override
    public String requestSectionTitleForTab(String sectionName) {
        if (configSectionsDict.containsKey(sectionName)) {
            return configSectionsDict.get(sectionName).getTitle();
        }
        return null;
    }

    @Override
    public FragmentManager requestFragmentManager() {
        return mFragmentManager;
    }
    
}