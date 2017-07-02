package com.codingblocks.codingblocks.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rishabhkhanna on 02/07/17.
 */

public class APIAllBooks {
    private static APIAllBooks apiAllBooks;
    public Retrofit retrofit;

    private APIAllBooks(){
        retrofit =
                new Retrofit.Builder()
                .baseUrl("https://api.gitbook.com/author")
                .addConverterFactory(
                        GsonConverterFactory.create()
                ).build();
    }

    public static APIAllBooks getInstance(){
        if(apiAllBooks == null){
            apiAllBooks = new APIAllBooks();
        }
        return apiAllBooks;
    }

}
