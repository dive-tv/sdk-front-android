package com.touchvie.sdk_front.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.touchvie.sdkfront.R;
import com.touchvie.touchvie_front.ui.utils.Utils;


/**
 * Created by Tagsonomy S.L. on 22/09/2016.
 */
public class Splash extends FragmentActivity {

    private static Splash instance=null;
    private Button mCarouselBtn;
    private Button mCardDetailBtn;

    /**
     * Returns the instance of the last Splash activity created.
     * @return Splash instance
     */
    public static Splash getInstance(){return instance;}

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        instance = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);

        getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        mCarouselBtn = (Button) findViewById(R.id.splash_btn_carousel);
        mCardDetailBtn = (Button) findViewById(R.id.splash_btn_card_detail);

        
        mCarouselBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardDetail = new Intent(Splash.this, DiveCarousel.class);
                startActivity(cardDetail);
            }
        });

        mCardDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardDetail = new Intent(Splash.this, CardDetailDive.class);
                startActivity(cardDetail);
            }
        });
    }


}
