package com.touchvie.touchvie_front.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 17/10/2016.
 */

public class PlacesShownList extends NoPaddingList {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= super.onCreateView(inflater, container, savedInstanceState);

        Bundle extras= getArguments();

        ArrayList<ImageRowData> rowData=(ArrayList<ImageRowData>)extras.getSerializable(Utils.ROW_DATA);
        super.setData(rowData);
        return view;
    }

}
