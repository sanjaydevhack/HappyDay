package com.independentdev.together.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.independentdev.together.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = "SplashScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }
}
