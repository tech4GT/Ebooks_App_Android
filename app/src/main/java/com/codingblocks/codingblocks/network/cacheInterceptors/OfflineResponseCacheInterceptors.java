package com.codingblocks.codingblocks.network.cacheInterceptors;

import android.content.Context;

import com.codingblocks.codingblocks.utils.UtilityMethods;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rishabhkhanna on 09/07/17.
 */

public class OfflineResponseCacheInterceptors implements Interceptor {

    Context context;
    public OfflineResponseCacheInterceptors(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request  = chain.request();
        if(!UtilityMethods.isNetworkConnected(context)){
            request = request.newBuilder()
                    .header("Cache-Control",
                            "public, only-if-cached, max-stale=" + 2419200)
                    .build();

        }
        return chain.proceed(request);
    }
}
