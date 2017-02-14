package com.independentdev.ink.app;

import android.app.Application;

import com.independentdev.ink.util.FontsOverride;

/**
 * Created by sanjayjith.madhavan on 2/6/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Scene-Regular.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Scene-Regular.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Scene-Regular.ttf");
        //FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Roboto-Light.ttf");
    }
}
