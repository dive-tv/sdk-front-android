package com.touchvie.touchvie_front.ui.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.touchvie.touchvie_front.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;

import eu.davidea.flexibleadapter.items.AbstractHeaderItem;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by Tagsonomy S.L. on 20/09/2016.
 */

public class SceneHeaderItem extends AbstractHeaderItem<SceneHeaderItem.HeaderViewHolder> {

private int order;//Custom order for sorting purpose
private String title;

public SceneHeaderItem(int order, String title) {
        this.order = order;
        this.title = title;
        setEnabled(false);
        }

@Override
public boolean equals(Object o) {
        return this == o;
        }

public int getOrder() {
        return order;
        }

public void setOrder(int order) {
        this.order = order;
        }

public String getTitle() {
        return title;
        }

public void setTitle(String title) {
        this.title = title;
        }

@Override
public int getLayoutRes() {
        return R.layout.scene_header;
        }

@Override
public HeaderViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new HeaderViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
        }

@Override
@SuppressWarnings("unchecked")
public void bindViewHolder(FlexibleAdapter adapter, HeaderViewHolder holder, int position, List payloads) {

        String title = this.title + " (" + adapter.getSectionItems(this).size() + ")";
        holder.title.setText(title);
}


static class HeaderViewHolder extends FlexibleViewHolder {

   TextView title;


    public HeaderViewHolder(View view, FlexibleAdapter adapter) {
        super(view, adapter, true);//True for sticky
        title=(TextView)view.findViewById(R.id.title);

    }
}

    @Override
    public String toString() {
        return "StaggeredHeaderItem[order=" + order + ", title=" + title + "]";
    }


}
