package com.touchvie.touchvie_front.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.touchvie.backend.Card;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.builders.ConfigModule;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.modules.TextModule;
import com.touchvie.touchvie_front.ui.modules.old.DescriptionModule;
import com.touchvie.touchvie_front.ui.modules.old.ImageModule;
import com.touchvie.touchvie_front.ui.modules.old.NavigationModule;
import com.touchvie.touchvie_front.ui.modules.old.RelatedMoviesModule;
import com.touchvie.touchvie_front.ui.modules.old.TabsModule;
import com.touchvie.touchvie_front.ui.modules.old.TitleModule;
import com.touchvie.touchvie_front.ui.modules.viewholders.ModuleHolder;


/**
 * Created by Tagsonomy S.L. on 15/09/2016.
 */
public class ModulesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final CardDetailListener mListener;
    private Card cardData;
    private final ConfigModule[] configModules;

    /**
     * Constructor
     * @param context
     * @param cardData
     * @param configModules
     * @param mListener
     */

    public ModulesAdapter(Context context, Card cardData, ConfigModule[] configModules, CardDetailListener mListener) {

        this.context = context;
        this.cardData = cardData;
        this.configModules = configModules;
        this.mListener = mListener;
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
            case "header":
                return 0;
            case "description":
                return 1;
            case "relatedMovies":
                return 2;
            case "navigation":
                return 3;
            case "tabs":
                return 4;
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
           /* case 0: //Header Module
                ViewGroup vImageModule = (ViewGroup) inflater.inflate(R.layout.module_image, viewGroup, false);
                viewHolder = new ImageModule(vImageModule);
                break;
            case 1: //Description Module
                ViewGroup vDescriptionModule = (ViewGroup) inflater.inflate(R.layout.module_description, viewGroup, false);
                viewHolder = new DescriptionModule(vDescriptionModule);
                break;
            case 2: //Related Movies Module
                ViewGroup vRelatedMoviesModule = (ViewGroup) inflater.inflate(R.layout.module_related_movies, viewGroup, false);
                viewHolder = new RelatedMoviesModule(vRelatedMoviesModule);
                break;
            case 3: //Navigation Module
                ViewGroup vNavigationModule = (ViewGroup) inflater.inflate(R.layout.module_navigation, viewGroup, false);
                viewHolder = new NavigationModule(vNavigationModule);
                break;
            case 4: //Tabs Module
                ViewGroup vTabsModule = (ViewGroup) inflater.inflate(R.layout.module_tabs, viewGroup, false);
                viewHolder = new TabsModule(vTabsModule);
                break;
            default: //HeaderModule for test
                ViewGroup vDefaultModule = (ViewGroup) inflater.inflate(R.layout.module_title, viewGroup, false);
                viewHolder = new TitleModule(vDefaultModule);
                break;
                */
            default:
                TextModule textModule=new TextModule();
                viewHolder=textModule.getViewHolder(inflater, viewGroup);
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

        if(viewHolder instanceof ModuleHolder){
            ((ModuleHolder)viewHolder).configure( cardData);
        }

      /*  if (viewHolder instanceof ImageModule) {
            ImageModule imageVH = (ImageModule) viewHolder;
            imageVH.configure(imageVH, position);

        } else if (viewHolder instanceof DescriptionModule) {
            DescriptionModule descriptionVH = (DescriptionModule) viewHolder;
            descriptionVH.configure(descriptionVH, cardData);

        } else if (viewHolder instanceof RelatedMoviesModule) {
            RelatedMoviesModule relatedMoviesVH = (RelatedMoviesModule) viewHolder;
            relatedMoviesVH.configure(context, relatedMoviesVH, cardData, mListener);

        } else if (viewHolder instanceof NavigationModule) {
            NavigationModule navigationVH = (NavigationModule) viewHolder;
            navigationVH.configure(context, navigationVH, configModules[position].getTargets(), mListener);

        } else if (viewHolder instanceof TabsModule) {
            TabsModule tabsVH = (TabsModule) viewHolder;
            tabsVH.configure(context, tabsVH, configModules[position].getTargets(), mListener);
        }
        */
    }
}
