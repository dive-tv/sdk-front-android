package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.TypeOfContainer;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.Container;
import com.touchvie.backend.carddetail.containers.Text;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.utils.Utils;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class FullCuriosityHolder extends ModuleHolder {

    protected TextView mTitle;
    protected TextView mText;

    /**
     * Default constructor
     *
     * @param itemView
     */

    public FullCuriosityHolder(View itemView) {

        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.txtv_fcuriosity_title);
        mText = (TextView) itemView.findViewById(R.id.txtv_fcuriosity_text);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        mTitle.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_BOLD));
        mText.setTypeface(Utils.getFont(context, Utils.TypeFaces.LATO_REGULAR));


        if(cardData.getTitle() !=null){
            mTitle.setText(cardData.getTitle());
        }else{
            mTitle.setVisibility(View.GONE);
        }

        boolean found=false;
        if (cardData.getInfo() != null) {
            for (Container container : cardData.getInfo()) {
                if (TypeOfContainer.DESCRIPTION.getName().equals(container.getType())) {
                    if (container.getData() != null && container.getData().length==1 ) {
                        Text containerText = (Text) container.getData()[0];
                        mText.setText(containerText.getText());
                        found=true;
                    }
                    break;
                }
            }
        }
        if(!found){
            mText.setVisibility(View.GONE);
        }

        //TODO: get data from carddata and insert into texts.

    }

}