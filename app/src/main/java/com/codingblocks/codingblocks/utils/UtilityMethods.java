package com.codingblocks.codingblocks.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by rishabhkhanna on 09/07/17.
 */

public class UtilityMethods {
    public static boolean isNetworkConnected(Context context){
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(info != null && info.isConnected()){
            return true;
        }
        return false;
    }
}
