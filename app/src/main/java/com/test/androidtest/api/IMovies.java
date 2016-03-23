package com.test.androidtest.api;

import com.test.androidtest.model.testmodel.Movies;
import com.test.androidtest.utilities.Constant;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by Karma on 11/02/16.
 */
public interface IMovies {
    @Headers("token: f90384c1-5a26-4a76-9f3b-fc0b37fe06f8")
    @GET(Constant.MOVIE_QUERY)
    Observable<Movies> getMovies();
}
