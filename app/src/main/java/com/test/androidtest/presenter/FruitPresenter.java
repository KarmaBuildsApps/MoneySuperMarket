package com.test.androidtest.presenter;

import com.test.androidtest.Service.DataService;

/**
 * Created by Karma on 23/03/16.
 */
public class FruitPresenter {
    private final FruitView view;
    private final DataService mService;
    private Object dataForAdapter;

    public FruitPresenter(FruitView view, DataService service) {
        this.view = view;
        this.mService = service;
    }

    public void getDataForAdapter() {
//        mService.getFruitData();
//        mService.getMovies();
        mService.getFood();
    }
}
