package com.test.androidtest.di.components;

import com.test.androidtest.Service.DataService;
import com.test.androidtest.api.FruitService;
import com.test.androidtest.di.modules.ApiModule;
import com.test.androidtest.di.modules.NetModule;
import com.test.androidtest.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import retrofit2.Retrofit;

/**
 * Created by Karma on 23/03/16.
 */
@Singleton
@Component(modules = {NetModule.class, ApiModule.class})
public interface NetComponent {
    FruitService fruitService();

    Realm realm();

    void inject(DataService service);
}
