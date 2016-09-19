package com.touchvie.touchvie_front.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.backend.CardData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.builders.ConfigModule;
import com.touchvie.touchvie_front.ui.adapters.ModulesAdapter;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 *
 */
public class Section extends Fragment {

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
     * CardData object, with all the data of the card
     */
    private CardData cardData;

    /**
     * Module configuration file
     */
    private ConfigModule[] configModules;

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
    public static Section newInstance(CardData data, ConfigModule[] config) {
        Section fragment = new Section();
        Bundle extras = new Bundle();
        extras.putSerializable(Utils.CARD_DATA, data);
        extras.putSerializable(Utils.CONFIG_MODULES, config);
        fragment.setArguments(extras);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        Bundle extras = getArguments();
        if(extras!=null){
            cardData = (CardData) extras.getSerializable(Utils.CARD_DATA);
            configModules = (ConfigModule[]) extras.getSerializable(Utils.CONFIG_MODULES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.section_base, container, false);
        modulesAdapter = new ModulesAdapter(cardData, configModules);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }
}