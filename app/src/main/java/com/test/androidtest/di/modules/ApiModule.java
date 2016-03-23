package com.test.androidtest.di.modules;

import com.test.androidtest.api.FruitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Karma on 23/03/16.
 */
@Module
public class ApiModule {
    @Singleton
    @Provides
    FruitService provideService(Retrofit retrofit) {
        return retrofit.create(FruitService.class);
    }
}
