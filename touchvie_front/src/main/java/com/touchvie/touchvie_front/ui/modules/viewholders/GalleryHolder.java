package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.Image;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.GalleryAdapter;
import com.touchvie.touchvie_front.ui.utils.Utils;
import com.touchvie.touchvie_front.ui.views.GridViewAutoHeight;

import java.util.ArrayList;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public class GalleryHolder extends ModuleHolder {

    private TextView mTitle;
    private TextView mSeeAll;
    private GridViewAutoHeight mGrid;

    /**
     * Default constructor
     *
     * @param itemView
     */
    public GalleryHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.txtv_seeall_title);
        mSeeAll = (TextView) itemView.findViewById(R.id.txtv_seeall_button);
        mGrid = (GridViewAutoHeight) itemView.findViewById(R.id.gvah_gallery_images);
    }

    @Override
    public void configure(Card cardData, Picasso picasso, Context context) {

        mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        mTitle.setText(context.getResources().getString(R.string.gallery));

        mSeeAll.setText(context.getResources().getString(R.string.see_all_gallery));
        mSeeAll.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));
        if (cardData.getContainers() != null) {
            boolean found = false;
            for (Container container : cardData.getContainers()) {
                if (TypeOfContainer.GALLERY.getName().equals(container.getContentType())) {
                    ArrayList<Image> images = new ArrayList<>(); //TODO: get images from card data!!!!!!
                    GalleryAdapter adapter = new GalleryAdapter(context, images);
                    mGrid.setAdapter(adapter);
                    found = true;
                    break;
                }
            }
            if (!found) {
                mSeeAll.setVisibility(View.GONE);
            }
        } else {
            mSeeAll.setVisibility(View.GONE);
            ArrayList<Image> images = new ArrayList<>(); //TODO: get images from card data!!!!!!
            for (int i = 0; i < 6; i++) {
                images.add(new Image());
                images.get(images.size() - 1).setFull("");
            }
            GalleryAdapter adapter = new GalleryAdapter(context, images);
            mGrid.setAdapter(adapter);
        }
    }
}
