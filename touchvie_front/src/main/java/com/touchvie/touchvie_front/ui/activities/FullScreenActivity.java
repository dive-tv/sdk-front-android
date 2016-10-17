package com.touchvie.touchvie_front.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.touchvie.backend.Image;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.FullScreenFragment;
import com.touchvie.touchvie_front.ui.fragments.SwipeGallery;
import com.touchvie.touchvie_front.ui.utils.Utils;

import java.util.ArrayList;

import static com.touchvie.touchvie_front.ui.FullScreenFragment.NONE;

public class FullScreenActivity extends FragmentActivity implements SwipeGallery.OnSwipeGalleryListener{


    private FragmentTransaction mFt = null;
    private FragmentManager mManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen);

        mManager = getSupportFragmentManager();
        FullScreenFragment fragment=NONE;

        Bundle extras= getIntent().getExtras();
        if(extras !=null){
            fragment=(FullScreenFragment) extras.getSerializable(Utils.FULLSCREEN_FRAGMENT);
            switch(fragment){
                case SWIPE_GALLERY:
                    loadSwipeGallery((ArrayList<Image>) extras.getSerializable(Utils.IMAGES), extras.getInt(Utils.POSITION));
                    break;
                case NONE:
                    finish();
                    break;
                default:
                    finish();
                    break;
            }
        }


    }


    private void loadSwipeGallery(ArrayList<Image> images, int position){

     /*   if (!RestManager.getInstance().isNetworkOnline()) {
            return;
        } */
        SwipeGallery gallery= new SwipeGallery();

        Bundle args = new Bundle();
        args.putSerializable(Utils.IMAGES, images);
        args.putInt(Utils.POSITION, position);
        gallery.setArguments(args);

        mFt = mManager.beginTransaction();
        mFt.replace(R.id.flay_layer1, gallery);

        mFt.addToBackStack(Utils.SWIPE_GALLERY).commit();
    }

    @Override
    public void closeGallery() {

        mManager.popBackStack();
        this.finish();
    }

    @Override
    public void loadWeb(String url) {

    }
}
