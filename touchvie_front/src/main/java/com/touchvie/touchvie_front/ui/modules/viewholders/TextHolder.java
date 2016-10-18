package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.views.ExpandableTextView;

/**
 * Created by Tagsonomy S.L. on 05/10/2016.
 */

public abstract class TextHolder extends ModuleHolder {

    protected TextView title;
    protected ExpandableTextView text;
    protected TextView link;
    protected ImageView more;
    protected TextView source;
    protected TextView sourceLink;
    protected ImageView sourceImage;
    protected TextView disclaimer;
    protected RelativeLayout sourceLay;
    protected FrameLayout separator;


    public TextHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.txtv_title);
        text = (ExpandableTextView) view.findViewById(R.id.xtxtv_body);
        link = (TextView) view.findViewById(R.id.txtv_text_link);
        more = (ImageView) view.findViewById(R.id.imgv_text_more);
        source = (TextView) view.findViewById(R.id.txtv_footer_source);
        sourceLink = (TextView) view.findViewById(R.id.txtv_footer_link);
        sourceImage = (ImageView) view.findViewById(R.id.imgv_footer_img);
        disclaimer = (TextView) view.findViewById(R.id.txtv_footer_disclaimer);
        sourceLay = (RelativeLayout) view.findViewById(R.id.rel_source_footer);
        separator = (FrameLayout) view.findViewById(R.id.flay_text_line);
    }


}
