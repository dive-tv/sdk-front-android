package com.touchvie.touchvie_front.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.touchvie_front.ui.adapters.ImageTextListAdapter;
import com.touchvie.touchvie_front.ui.modules.data.ImageRowData;

import java.util.ArrayList;


public class ImageTextList extends VerticalList {

    protected ImageTextListAdapter adapter;
    protected ArrayList<ImageRowData> data;

    public ImageTextList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment NoPaddingList.
     */
    public static ImageTextList newInstance() {
        ImageTextList fragment = new ImageTextList();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= super.onCreateView(inflater, container, savedInstanceState);

        mContainer.setPadding(0, mContainer.getPaddingTop(), 0, mContainer.getPaddingBottom());

        data=new ArrayList<>();
        adapter= new ImageTextListAdapter(data);
        super.setAdapter(adapter);

        return view;

    }

    protected void setData(ArrayList<ImageRowData> data){
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
