package com.codingblocks.codingblocks.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rishabhkhanna on 01/07/17.
 */

public class APIBook {
    private static APIBook apiInstance;
    public Retrofit retrofit;

    private APIBook () {
        retrofit
                = new Retrofit.Builder().baseUrl("https://api.gitbook.com/book/coding-blocks/blocks-of-javascript/contents/")
                .addConverterFactory(
                        GsonConverterFactory.create()
                ).build();
    }

    public  static APIBook getInstance(){
        if(apiInstance == null){
            apiInstance = new APIBook();
        }
        return apiInstance;
    }
}
