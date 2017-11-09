package com.codingblocks.codingblocks.network.cacheInterceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by rishabhkhanna on 09/07/17.
 */

public class ResponseCacheInterceptor implements Interceptor {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .header("Cache-Control","public, max-age=" + 60)
                .build();
    }
}
