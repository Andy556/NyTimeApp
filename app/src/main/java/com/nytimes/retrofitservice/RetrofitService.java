package com.nytimes.retrofitservice;

import com.nytimes.model.ArticleList;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sujith on 6/19/2019.
 */

public interface RetrofitService {


    /*Feeds*/
    @GET("all-sections/7.json?")
//    Call<List<ArticleList>> homefeeds(@Query("api-key") String api_key);
    Call<ResponseBody> homefeeds(@Query("api-key") String api_key);



}
