package com.test.androidtest.di.modules;

import com.test.androidtest.api.FruitService;
import com.test.androidtest.api.IFood;
import com.test.androidtest.api.IMovies;

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

    @Singleton
    @Provides
    IMovies provideIMovies(Retrofit retrofit) {
        return retrofit.create(IMovies.class);
    }

    @Singleton
    @Provides
    IFood provideIFood(Retrofit retrofit) {
        return retrofit.create(IFood.class);
    }
}
