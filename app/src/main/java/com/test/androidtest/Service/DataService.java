package com.test.androidtest.Service;

import android.content.Context;
import android.util.Log;

import com.test.androidtest.adapter.FruitAdapter;
import com.test.androidtest.api.FruitService;
import com.test.androidtest.api.IFood;
import com.test.androidtest.api.IMovies;
import com.test.androidtest.model.Fruit;
import com.test.androidtest.model.Fruits;
import com.test.androidtest.model.foodModelTest.Food;
import com.test.androidtest.model.testmodel.Movies;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Karma on 23/03/16.
 */
public class DataService {
    @Inject
    Realm mRealm;
    @Inject
    FruitService mFruitService;
    @Inject
    IFood iFood;
    @Inject
    IMovies iMovies;
    private FruitAdapter mFruitAdapter;
    public static final String TAG = DataService.class.getSimpleName();

    public DataService(FruitAdapter adapter) {
        this.mFruitAdapter = adapter;
    }

    public void getFruitData() {
        Observable<Fruits> observable = mFruitService.getFruits();


        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fruits>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError " + e.getMessage());
                    }

                    @Override
                    public void onNext(Fruits fruits) {

                        Log.d(TAG, "onNext " + fruits.getFruits());

                        for (Fruit fruit : fruits.getFruits()) {
                            mFruitAdapter.addFruit(fruit);
                        }
                    }
                });
    }

    public void getMovies() {
        Observable<Movies> observable = iMovies.getMovies();


        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movies>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError " + e.getMessage());
                    }

                    @Override
                    public void onNext(Movies movies) {
                        Log.d(TAG, "onNext " + movies.getTitle());
                    }
                });
    }

    public void getFood() {
        Observable<Food> observable = iFood.getFood();
        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Food>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError " + e.getMessage());
                    }

                    @Override
                    public void onNext(Food food) {
                        Log.d(TAG, "onNext " + food.getHits().size());
                    }
                });
    }
}
