package com.test.androidtest;

import android.app.Application;

import com.test.androidtest.di.components.DaggerNetComponent;
import com.test.androidtest.di.components.NetComponent;
import com.test.androidtest.di.modules.ApiModule;
import com.test.androidtest.di.modules.NetModule;

/**
 * Created by Karma on 23/03/16.
 */
public class MyApplication extends Application {
    NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
