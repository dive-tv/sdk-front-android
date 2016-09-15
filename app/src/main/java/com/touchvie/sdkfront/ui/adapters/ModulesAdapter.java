package com.touchvie.sdkfront.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.touchvie.sdkfront.datatypes.ModuleData;
import com.touchvie.sdkfront.ui.Module;

/**
 * Created by rodrigo.moral on 15/09/2016.
 */
public class ModulesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ModuleData[] moduleDataArray;

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public ModulesAdapter(ModuleData[] moduleData) {
        this.moduleDataArray = moduleData;
    }

    @Override
    public ModulesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
