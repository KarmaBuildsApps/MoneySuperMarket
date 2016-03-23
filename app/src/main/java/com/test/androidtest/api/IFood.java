package com.test.androidtest.api;

import com.test.androidtest.model.foodModelTest.Food;
import com.test.androidtest.model.testmodel.Movies;
import com.test.androidtest.utilities.Constant;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Karma on 23/03/16.
 */
public interface IFood {
    @GET(Constant.FOOD_QUERY)
    Observable<Food> getFood();
}
