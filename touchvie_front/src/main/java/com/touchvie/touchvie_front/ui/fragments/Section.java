package com.touchvie.touchvie_front.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.backend.CardData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.builders.ConfigSection;
import com.touchvie.touchvie_front.ui.adapters.ModulesAdapter;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.utils.Utils;
import com.touchvie.touchvie_front.ui.views.Module;
import com.touchvie.touchvie_front.ui.views.RecyclerListLayout;

import java.util.ArrayList;

/**
 *
 */
public class Section extends Fragment {

    public enum SectionType {recycler_view, linear_layout}

    private SectionType sectionType;

    /**
     * The Section instance
     */
    private Section instance = null;

    /**
     * List of Modules in this Section
     */
    protected ArrayList<Module> modules;

    /**
     * Adapter which will create the modules from the data
     */
    private ModulesAdapter modulesAdapter;

    /**
     * Layout Manager used to control the RecyclerView
     */
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * CardData object, with all the data of the card
     */
    private CardData cardData;

    /**
     * Module configuration file
     */
    private ConfigSection configSection;

    /**
     * Interface to communicate with Card Detail
     */
    private CardDetailListener mListener;

    /**
     * Set the Modules in this Section
     *
     * @param modules
     * @return
     */
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    /**
     * Get Modules from this Section
     *
     * @return
     */
    public ArrayList<Module> getModules() {
        return modules;
    }


    public ConfigSection getConfigSection() {
        return configSection;
    }

    /**
     * Set a new Module on this Section
     *
     * @param module
     * @return
     */
    public void setModule(Module module) {
        // TODO implement here
    }

    /**
     * Default constructor
     */
    public Section() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment Home.
     */
    public static Section newInstance(CardData data, ConfigSection configSection, SectionType sectionType, CardDetailListener listener) {
        Section fragment = new Section();
        Bundle extras = new Bundle();
        extras.putSerializable(Utils.CARD_DATA, data);
        extras.putSerializable(Utils.CONFIG_SECTION, configSection);
        extras.putSerializable(Utils.SECTION_TYPE, sectionType);
        extras.putParcelable(Utils.CARD_DETAIL_LISTENER, listener);
        fragment.setArguments(extras);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        Bundle extras = getArguments();
        if (extras != null) {
            cardData = (CardData) extras.getSerializable(Utils.CARD_DATA);
            configSection = (ConfigSection) extras.getSerializable(Utils.CONFIG_SECTION);
            sectionType = (SectionType) extras.getSerializable(Utils.SECTION_TYPE);
            mListener = (CardDetailListener) extras.getParcelable(Utils.CARD_DETAIL_LISTENER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        modulesAdapter = new ModulesAdapter(getContext(), cardData, configSection.getConfigModules(), mListener);
        System.out.println("KKKKKKKKKKKKKK Section onCreateView");
        sectionType=SectionType.recycler_view;
        switch (sectionType) {
            case recycler_view:
                System.out.println("KKKKKKKKKKKKKK Section recycler");
                view = inflater.inflate(R.layout.section_base_recycler, container, false);
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                mLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(modulesAdapter);
                break;
            case linear_layout:
                System.out.println("KKKKKKKKKKKKKK Section linear");
                view = inflater.inflate(R.layout.section_base_linear, container, false);
                RecyclerListLayout recyclerListLayout = (RecyclerListLayout) view.findViewById(R.id.recycler_list_layout);
                recyclerListLayout.setList(modulesAdapter, false);
                break;
            default:
                view = inflater.inflate(R.layout.section_base_recycler, container, false);
                RecyclerView defaultView = (RecyclerView) view.findViewById(R.id.recycler_view);
                mLayoutManager = new LinearLayoutManager(getContext());
                defaultView.setLayoutManager(mLayoutManager);
                defaultView.setAdapter(modulesAdapter);
                break;
        }

        return view;
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
        this.sectionType = sectionType;
    }
}