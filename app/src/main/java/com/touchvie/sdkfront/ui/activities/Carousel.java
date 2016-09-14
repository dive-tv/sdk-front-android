package com.touchvie.sdkfront.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.touchvie.sdkfront.R;
import com.touchvie.sdkfront.builders.CardDetailBuilder;
import com.touchvie.sdkfront.builders.CardDetailJson;

import org.json.JSONObject;

public class Carousel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        
    }
}
