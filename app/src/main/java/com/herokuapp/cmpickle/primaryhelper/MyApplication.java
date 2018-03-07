package com.herokuapp.cmpickle.primaryhelper;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by cmpic on 3/3/2018.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        Stetho.initializeWithDefaults(this);
    }
}
