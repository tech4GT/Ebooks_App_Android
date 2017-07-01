package com.codingblocks.codingblocks.network.interfaces;


import com.codingblocks.codingblocks.models.AuthorBooksCB;
import com.codingblocks.codingblocks.models.BookData;
import com.codingblocks.codingblocks.models.Contents;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by rishabhkhanna on 30/06/17.
 */

public interface GitbookAPI {
    @GET("blocks-of-javascript/contents")
    Call<Contents> getContent();

    @GET
    Call<BookData> getBook(
            @Url String url
    );
    @GET("")
    Call<AuthorBooksCB> getAllBooks();
}
