package com.touchvie.sdkfront.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.sdkfront.R;
import com.touchvie.sdkfront.datatypes.ModuleData;
import com.touchvie.sdkfront.ui.utils.Utils;

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
     * Array of ModuleData, used to build Modules
     */
    private ModuleData[] moduleDataArray;

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
    public static Section newInstance() {
        return new Section();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        Bundle extras = getArguments();
        if (extras != null) {
            moduleDataArray = (ModuleData[]) extras.getSerializable(Utils.MODULEDATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.section_base, container, false);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }
}