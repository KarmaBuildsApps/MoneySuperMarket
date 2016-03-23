package com.test.androidtest.di.modules;

import android.app.Application;


import com.test.androidtest.utilities.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Karma on 23/03/16.
 */
@Module
public class NetModule {
    private Application application;

    public NetModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Realm provideRealm() {
        return Realm.getInstance(application);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constant.FOOD_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
