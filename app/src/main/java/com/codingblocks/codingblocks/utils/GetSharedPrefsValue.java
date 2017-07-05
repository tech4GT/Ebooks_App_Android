package com.codingblocks.codingblocks.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.codingblocks.codingblocks.R;

/**
 * Created by rishabhkhanna on 05/07/17.
 */

public class GetSharedPrefsValue {
    public static Boolean getTheme(Context context){
        boolean themeId = false;
        SharedPreferences sharedPreferences  = context.getSharedPreferences(Constants.THEME_PREFS, Context.MODE_PRIVATE);
        themeId = sharedPreferences.getBoolean(Constants.THEME_KEY,false);
        return themeId;
    }
}
