package com.test.androidtest.utilities;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class Constant {

    public static final String HOST = "192.168.0.27";
    public static final int PORT = 8080;
    public static final String BASE_URL = "http://" + HOST + ":" + PORT + "/simple-fruit-api/api/";

    //Test api

    public final static String TEST_BASE_URL = "http://tmdb-api.appspot.com/";
    public final static String MOVIE_QUERY = "views/movie/upcoming";
    public final static String MOVIE_LIST_PARCEL = "parcelableMovieSection";

    public final static String FOOD_BASE_URL = "https://api.nutritionix.com";
    public final static String FOOD_QUERY = "/v1_1/search/cheddar%20cheese?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat&appId=03a90625&appKey=e633e59393b7f6dc4b03d71e621159d9";
}
