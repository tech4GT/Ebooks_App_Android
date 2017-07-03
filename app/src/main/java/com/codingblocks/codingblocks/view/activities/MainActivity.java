package com.codingblocks.codingblocks.view.activities;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.codingblocks.codingblocks.R;
import com.codingblocks.codingblocks.adapters.AllBooksAdapter;
import com.codingblocks.codingblocks.interfaces.onItemClickListener;
import com.codingblocks.codingblocks.models.AuthorBooksCB;
import com.codingblocks.codingblocks.models.List;
import com.codingblocks.codingblocks.network.API;
import com.codingblocks.codingblocks.network.interfaces.GitbookAPI;
import com.codingblocks.codingblocks.utils.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvAllBooks;
    SwipeRefreshLayout swipeRefreshLayoutAllBooks;
    public static final String TAG = "MainActivity";
    ArrayList<List> allBooks;
    AllBooksAdapter allBooksAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAllBooks = (RecyclerView) findViewById(R.id.rvAllBooks);
        swipeRefreshLayoutAllBooks = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshAllBooks);
        allBooks = new ArrayList<>();
        allBooksAdapter = new AllBooksAdapter(this, allBooks);
        rvAllBooks.setLayoutManager(new LinearLayoutManager(this));
        rvAllBooks.setAdapter(allBooksAdapter);
        fetchBooks();

        onItemClickListener onItemClickListener = new onItemClickListener() {
            @Override
            public void onItemClicklistener(List thisBook) {
                Intent i = new Intent(MainActivity.this,BookBaseActivity.class);
                i.putExtra(Constants.BOOK_ID_KEY,thisBook.getName());
                i.putExtra(Constants.BOOK_AUTHOR_KEY,thisBook.getmAuthor().getUsername());
                i.putExtra(Constants.BOOK_NAME,thisBook.getTitle());
                startActivity(i);
            }
        };
        allBooksAdapter.setClickListener(onItemClickListener);
        swipeRefreshLayoutAllBooks.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayoutAllBooks.setRefreshing(false);
                allBooks.clear();
                fetchBooks();
            }
        });

    }

    public void fetchBooks(){
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
