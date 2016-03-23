package com.test.androidtest.Service;

import android.util.Log;

import com.test.androidtest.adapter.FruitAdapter;
import com.test.androidtest.api.FruitService;
import com.test.androidtest.model.Fruit;
import com.test.androidtest.model.FruitItem;
import com.test.androidtest.model.Fruits;

import java.util.ArrayList;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
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
                            addInRealmAndUpdateAdapter(fruit);
                        }
                    }
                });
    }

    private void addInRealmAndUpdateAdapter(Fruit fruit) {
        String id = fruit.getId();
        if (mRealm.where(FruitItem.class).equalTo("id", id).count() != 0) {
            mFruitAdapter.addFruit(fruit);
            FruitItem fruitItem = new FruitItem();
            fruitItem.setId(fruit.getId());
            fruitItem.setName(fruit.getName());
            fruitItem.setPrice(fruit.getPrice());
            mRealm.beginTransaction();
            mRealm.copyToRealmOrUpdate(fruitItem);
            mRealm.commitTransaction();
        }
    }

    public ArrayList<Fruit> getFruitsInRealm() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        RealmResults<FruitItem> realmResults = mRealm.where(FruitItem.class).findAll();
        for (int i = 0; i < realmResults.size(); i++) {
            Fruit fruit = new Fruit();
            FruitItem fruitItem = realmResults.get(i);
            fruit.setId(fruitItem.getId());
            fruit.setName(fruitItem.getName());
            fruit.setPrice(fruitItem.getPrice());
            fruits.add(fruit);
        }
        return fruits;
    }


}
