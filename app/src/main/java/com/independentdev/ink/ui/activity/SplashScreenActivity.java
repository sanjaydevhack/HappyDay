package com.independentdev.ink.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.independentdev.ink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends Activity {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();

    @BindView(R.id.splashScreenIMV)
    ImageView splashScreenIMV;
    @BindView(R.id.splashTV)
    TextView splashTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/GloriaHallelujah.ttf");
        splashTV.setTypeface(font);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 3000);
    }
}
