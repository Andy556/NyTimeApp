package com.nytimes.utils;


import com.nytimes.retrofitservice.RetrofitService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sujith on 6/19/2019.
 */

public class Constants {


    public static final String BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/";
    public static final String API_KEY = "A3XAdR0I3HDL9vzGP96vvUnTgp740xA5";
    public static final String RESULTS = "results";


    public static OkHttpClient getinfo() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).addInterceptor(logging).build();
    }


    public static final RetrofitService retrofitService = new Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(getinfo()).build().create(RetrofitService.class);


}
