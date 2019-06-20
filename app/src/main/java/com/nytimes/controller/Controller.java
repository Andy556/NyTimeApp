package com.nytimes.controller;

import android.app.Application;

import com.nytimes.utils.FontsOverride;


/**
 * Created by Sujith on 6/19/2019.
 */

public class Controller extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "SERIF", "fonts/ProximaNova-Light.otf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/ProximaNova-Regular.otf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/ProximaNova-Semibold.otf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/ProximaNova-Semibold.otf");


    }
}