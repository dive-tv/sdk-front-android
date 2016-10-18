package com.touchvie.touchvie_front.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.touchvie.touchvie_front.R;

public abstract class VerticalList extends Fragment {

    protected LinearLayout mContainer;
    protected RecyclerView mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_vertical_list, container, false);
        mContainer=(LinearLayout) view.findViewById(R.id.lay_container);
        mList=(RecyclerView)view.findViewById(R.id.rlay_list_list);
        return view;
    }

    protected void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter){
        mList.setAdapter(adapter);
    }

}
