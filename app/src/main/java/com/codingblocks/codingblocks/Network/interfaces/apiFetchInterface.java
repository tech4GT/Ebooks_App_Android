package com.codingblocks.codingblocks.Network.interfaces;

import com.codingblocks.codingblocks.models.Contents;
import com.vladsch.flexmark.ast.Content;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rishabhkhanna on 30/06/17.
 */

public interface apiFetchInterface {
    @GET("blocks-of-javascript/contents")
    Call<Contents> getContent();

}
