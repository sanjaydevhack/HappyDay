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

        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Roboto-Light.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Roboto-Light.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Roboto-Light.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Roboto-Light.ttf");
    }
}
