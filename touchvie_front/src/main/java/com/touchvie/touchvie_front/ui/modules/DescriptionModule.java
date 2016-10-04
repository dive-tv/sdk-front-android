package com.touchvie.touchvie_front.ui.modules;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.touchvie.backend.Card;
import com.touchvie.backend.Description;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.views.Module;

/**
 * Created by Tagsonomy S.L. on 16/09/2016.
 */
public class DescriptionModule extends Module {

    private TextView mTitle;
    private TextView mBody;
    private FrameLayout mSourceLine;
    private TextView mSource;

    /**
     * Default constructor
     */
    public DescriptionModule(View v) {
        super(v);
        mTitle = (TextView) v.findViewById(R.id.module_description_title);
        mBody = (TextView) v.findViewById(R.id.module_description_body);
        mSourceLine = (FrameLayout) v.findViewById(R.id.module_description_source_line);
        mSource = (TextView) v.findViewById(R.id.module_description_source);
    }

    /**
     * Gets the module title
     * @return
     */
    public TextView getTitle() {
        return mTitle;
    }

    public void setTitle(TextView mTitle) {
        this.mTitle = mTitle;
    }

    public TextView getBody() {
        return mBody;
    }

    public void setBody(TextView mBody) {
        this.mBody = mBody;
    }

    public FrameLayout getSourceLine() {
        return mSourceLine;
    }

    public void setSourceLine(FrameLayout mSourceLine) {
        this.mSourceLine = mSourceLine;
    }

    public TextView getSource() {
        return mSource;
    }

    public void setSource(TextView mSource) {
        this.mSource = mSource;
    }

    public void configure(DescriptionModule descriptionVH, Card cardData) {
        if (cardData != null && cardData.getDescription() != null) {
            Description description = cardData.getDescription();
            //Title
            if (description.getTitle() != null && description.getTitle().length() > 0) {
                descriptionVH.getTitle().setText(description.getTitle());
            }
            else{
                descriptionVH.getTitle().setText("");
            }
            //Body text
            if (description.getText() != null && description.getText().length() > 0){
                descriptionVH.getBody().setText(description.getText());
            }
            else{
                descriptionVH.getBody().setText("");
            }
            //Source
            if (description.getSource() != null && description.getSource().length() > 0) {
                descriptionVH.getSource().setText(description.getSource());
                descriptionVH.getSource().setVisibility(View.VISIBLE);
            } else {
                descriptionVH.getSource().setVisibility(View.GONE);
            }
        }
    }
}
