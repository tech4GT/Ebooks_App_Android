package com.codingblocks.codingblocks.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rishabhkhanna on 30/06/17.
 */

public class API {
    private static API apiInstance;
    public Retrofit retrofit;

    private API () {
        retrofit
                 = new Retrofit.Builder().baseUrl("https://api.gitbook.com/book/coding-blocks/")
                .addConverterFactory(
                        GsonConverterFactory.create()
                ).build();
    }

    public  static API getInstance(){
        if(apiInstance == null){
            apiInstance = new API();
        }
        return apiInstance;
    }
}
