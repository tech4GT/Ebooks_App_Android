package com.codingblocks.codingblocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;


import im.delight.android.webview.AdvancedWebView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvAllBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAllBooks = (RecyclerView) findViewById(R.id.rvAllBooks);

    }

}
