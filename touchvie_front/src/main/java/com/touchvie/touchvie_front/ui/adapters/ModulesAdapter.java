package com.touchvie.touchvie_front.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.backend.CardData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.builders.ConfigModule;
import com.touchvie.touchvie_front.ui.modules.ImageModule;


/**
 * Created by rodrigo.moral on 15/09/2016.
 */
public class ModulesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private CardData cardData;
    private final ConfigModule[] configModules;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public ModulesAdapter(CardData cardData, ConfigModule[] configModules) {
        this.cardData = cardData;
        this.configModules = configModules;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case 0: //ImageModule
                ViewGroup vImageModule = (ViewGroup) inflater.inflate(R.layout.module_image, parent, false);
                ImageModule vhImageModule = new ImageModule(vImageModule);
                return vhImageModule;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
