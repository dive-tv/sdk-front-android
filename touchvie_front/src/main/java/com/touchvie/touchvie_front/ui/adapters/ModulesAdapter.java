package com.touchvie.touchvie_front.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.backend.CardData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.builders.ConfigModule;
import com.touchvie.touchvie_front.ui.modules.DescriptionModule;
import com.touchvie.touchvie_front.ui.modules.ImageModule;
import com.touchvie.touchvie_front.ui.modules.RelatedMoviesModule;
import com.touchvie.touchvie_front.ui.modules.TitleModule;


/**
 * Created by Tagsonomy S.L. on 15/09/2016.
 */
public class ModulesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private CardData cardData;
    private final ConfigModule[] configModules;

    public ModulesAdapter(Context context, CardData cardData, ConfigModule[] configModules) {
        this.context = context;
        this.cardData = cardData;
        this.configModules = configModules;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.configModules.length;
    }

    //Returns the view type of the item at position for the purposes of view recycling.
    @Override
    public int getItemViewType(int position) {
        switch (configModules[position].getType()) {
            case "Header":
                return 0;
            case "Description":
                return 1;
            case "RelatedMovies":
                return 2;
        }
        return 0;
    }

    /**
     * This method creates different RecyclerView.ViewHolder objects based on the item view type.\
     *
     * @param viewGroup ViewGroup container for the item
     * @param viewType  type of view to be inflated
     * @return viewHolder to be inflated
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case 0: //HeaderModule
                ViewGroup vImageModule = (ViewGroup) inflater.inflate(R.layout.module_image, viewGroup, false);
                viewHolder = new ImageModule(vImageModule);
                break;
            case 1: //DescriptionModule
                ViewGroup vDescriptionModule = (ViewGroup) inflater.inflate(R.layout.module_description, viewGroup, false);
                viewHolder = new DescriptionModule(vDescriptionModule);
                break;
            case 2: //RelatedMoviesModule
                ViewGroup vRelatedMoviesModule = (ViewGroup) inflater.inflate(R.layout.module_title, viewGroup, false);
                viewHolder = new RelatedMoviesModule(vRelatedMoviesModule);
                break;
            default: //HeaderModule for test
                ViewGroup vDefaultModule = (ViewGroup) inflater.inflate(R.layout.module_title, viewGroup, false);
                viewHolder = new TitleModule(vDefaultModule);
                break;
        }
        return viewHolder;
    }

    /**
     * This method internally calls onBindViewHolder(ViewHolder, int) to update the
     * RecyclerView.ViewHolder contents with the item at the given position
     * and also sets up some private fields to be used by RecyclerView.
     *
     * @param viewHolder The type of RecyclerView.ViewHolder to populate
     * @param position   Item position in the viewgroup.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case 0:
                ImageModule imageVH = (ImageModule) viewHolder;
                imageVH.configure(imageVH, position);
                break;
            case 1:
                DescriptionModule descriptionVH = (DescriptionModule) viewHolder;
                descriptionVH.configure(descriptionVH, cardData);
                break;
            case 2:
                RelatedMoviesModule relatedMoviesVH = (RelatedMoviesModule) viewHolder;
                relatedMoviesVH.configure(context, relatedMoviesVH, cardData);
                break;
            default:
                TitleModule defaultVH = (TitleModule) viewHolder;
                defaultVH.configure(defaultVH, position);
                break;
        }
    }
}
