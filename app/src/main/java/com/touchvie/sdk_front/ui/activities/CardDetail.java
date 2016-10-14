package com.touchvie.sdk_front.ui.activities;

import android.content.res.Resources;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.touchvie.backend.TypeOfCard;
import com.touchvie.sdk_front.ui.utils.Utils;
import com.touchvie.sdkfront.R;
import com.touchvie.touchvie_front.builders.CardDetailJson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by Tagsonomy S.L. on 19/09/2016.
 */
public class CardDetail extends FragmentActivity {

    private static CardDetail instance=null;
    private FragmentManager mManager = null;
    private LinearLayout mContainer=null;


    /**
     * Returns the instance of the last CardDetailDive activity created.
     * @return CardDetailDive instance
     */
    public static CardDetail getInstance(){return instance;}

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        instance = this;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.carddetail);

        Bundle extras= getIntent().getExtras();

        TypeOfCard card=TypeOfCard.MOVIE;
        if(extras !=null){
            card=(TypeOfCard) extras.getSerializable(Utils.CARD_TYPE);

        }
        JSONObject configJson= getConfigJSON(card);

        mContainer = (LinearLayout) findViewById(R.id.carddetail);
        getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        mManager = getSupportFragmentManager();
        CardDetailJson cardDetail = new CardDetailJson(getApplicationContext());

        String cardId= getCardId(card);
        cardDetail.loadDataConfig(configJson).buildAll(cardId,mManager, mContainer);

    }

    private String getCardId(TypeOfCard card){

        return card.getName();

    }

    private JSONObject getConfigJSON(TypeOfCard card){

        String jsonString = null;

        int configFile;

        switch(card){
            case MOVIE:
                configFile=R.raw.movieconfig;
                break;
            default:
                configFile=R.raw.movieconfig;
                break;
        }

        try {
            Resources res = getApplicationContext().getResources();
            InputStream in_s = res.openRawResource(configFile);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            jsonString = new String(b);
        } catch (Exception e) {
            return null;
        }

        JSONObject configJson = null;
        try {
            configJson = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return configJson;

    }
}

