package com.touchvie.touchvie_front.ui.modules.old;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.builders.Target;
import com.touchvie.touchvie_front.ui.listeners.CardDetailListener;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class NavigationModule extends RecyclerView.ViewHolder {

    private Button mButton;

    /**
     * Default constructor
     */
    public NavigationModule(View v) {
        super(v);
        mButton = (Button) v.findViewById(R.id.module_navigation_btn);
    }

    public Button getButton() {
        return mButton;
    }

    public void setButton(Button mButton) {
        this.mButton = mButton;
    }

    public void configure(Context context, NavigationModule relatedMoviesVH, final Target[] target, final CardDetailListener mListener) {
        if (target != null && target.length > 0) {
            //Button text
            if (target[0].getText() != null && target[0].getText().length() > 0) {
                relatedMoviesVH.getButton().setText(target[0].getText());
            } else {
                relatedMoviesVH.getButton().setText("");
            }
            //Button click listener
            relatedMoviesVH.getButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.goToSection(target[0].getSectionId());
                }
            });
        }
    }
}
