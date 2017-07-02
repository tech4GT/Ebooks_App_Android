package com.codingblocks.codingblocks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;


import com.codingblocks.codingblocks.adapters.AllBooksAdapter;
import com.codingblocks.codingblocks.models.AuthorBooksCB;
import com.codingblocks.codingblocks.models.List;
import com.codingblocks.codingblocks.network.API;
import com.codingblocks.codingblocks.network.APIAllBooks;
import com.codingblocks.codingblocks.network.interfaces.GitbookAPI;

import java.util.ArrayList;

import im.delight.android.webview.AdvancedWebView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvAllBooks;
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAllBooks = (RecyclerView) findViewById(R.id.rvAllBooks);
        final ArrayList<List> allBooks = new ArrayList<>();
        final AllBooksAdapter allBooksAdapter = new AllBooksAdapter(this, allBooks);
        rvAllBooks.setLayoutManager(new LinearLayoutManager(this));
        rvAllBooks.setAdapter(allBooksAdapter);
        API.getInstance()
                .retrofit
                .create(GitbookAPI.class)
                .getAllBooks()
                .enqueue(new Callback<AuthorBooksCB>() {
                    @Override
                    public void onResponse(Call<AuthorBooksCB> call, Response<AuthorBooksCB> response) {
                        Log.d(TAG, "onResponse: "  + String.valueOf(response.body().getList().size()));
                        allBooks.addAll(response.body().getList());
                        allBooksAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<AuthorBooksCB> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        Toast.makeText(MainActivity.this, "Sorry Could not Fetch Books", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
