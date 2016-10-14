package com.touchvie.touchvie_front.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.touchvie.backend.Image;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.adapters.SwipeGalleryAdapter;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SwipeGallery extends Fragment {


    private ImageView mClose;
    private ViewPager mPager;

    private OnSwipeGalleryListener mListener;

    public SwipeGallery() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     * @return A new instance of fragment SwipeGallery.
     */


    public static SwipeGallery newInstance() {
        SwipeGallery fragment = new SwipeGallery();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_swipe_gallery, container, false);

        mClose=(ImageView)view.findViewById(R.id.txtv_sgallery_close);
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Bundle extras=getArguments();
        ArrayList<Image> images= null;
        if(extras !=null){
            images=(ArrayList<Image>)extras.getSerializable(Utils.IMAGES);
        }
        mPager=(ViewPager) view.findViewById(R.id.pager);
        SwipeGalleryAdapter adapter= new SwipeGalleryAdapter(getContext(), images, mListener);
        mPager.setAdapter(adapter);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSwipeGalleryListener) {
            mListener = (OnSwipeGalleryListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSwipeGalleryListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnSwipeGalleryListener {
        void closeGallery();
        void loadWeb(String url);
    }
}
