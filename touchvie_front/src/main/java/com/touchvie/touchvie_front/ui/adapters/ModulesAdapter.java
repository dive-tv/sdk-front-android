package com.touchvie.touchvie_front.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.Card;
import com.touchvie.touchvie_front.builders.ConfigModule;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.modules.viewholders.ModuleHolder;
import com.touchvie.touchvie_front.ui.views.Module;

import java.util.HashMap;


/**
 * Created by Tagsonomy S.L. on 15/09/2016.
 */
public class ModulesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final CardDetailListener mListener;
    private Card cardData;
    private final ConfigModule[] configModules;
    HashMap<String, Integer> classIndex= new HashMap<>();
    HashMap<Integer, String> indexClass= new HashMap<>();

    private Picasso mPicasso = null;

    private final String defaultModulePackage="com.touchvie.touchvie_front.ui.modules.";

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
        this.mPicasso=Picasso.with(context);
        getDifferentModulesNumber();
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.configModules.length;
    }

    //Returns the view type of the item at position for the purposes of view recycling.
    @Override
    public int getItemViewType(int position) {

        String key=configModules[position].getType();
        return (classIndex.containsKey(key)?classIndex.get(key):0);
    }

    protected void getDifferentModulesNumber(){
        if(configModules==null || configModules.length==0){
            return;
        }else{
            int index=0;

            for(ConfigModule configModule: configModules){
                String type=configModule.getType();
                if(classIndex.get(type)==null){
                    classIndex.put(type, index);
                    indexClass.put(index, type);
                    index++;
                }
            }
        }
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
        if(indexClass.size()==0){
            return null;
        }
        String moduleName=indexClass.get(viewType);
        if(!moduleName.contains(".")){
            moduleName=defaultModulePackage+moduleName;
        }
        try {
            viewHolder=((Module)(Class.forName(moduleName).newInstance())).getViewHolder(inflater, viewGroup);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //TODO: return empty viewholder
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace(); //TODO: return empty viewholder
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace(); //TODO: return empty viewholder
            return null;
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
            ((ModuleHolder)viewHolder).configure( cardData, mPicasso, context);
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
