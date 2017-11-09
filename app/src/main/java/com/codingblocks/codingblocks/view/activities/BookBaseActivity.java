package com.codingblocks.codingblocks.view.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.codingblocks.codingblocks.network.API;
import com.codingblocks.codingblocks.network.interfaces.GitbookAPI;
import com.codingblocks.codingblocks.R;
import com.codingblocks.codingblocks.adapters.ExapndableListAdapter;

import com.codingblocks.codingblocks.models.BookData;
import com.codingblocks.codingblocks.models.Chapter;
import com.codingblocks.codingblocks.models.Contents;
import com.codingblocks.codingblocks.utils.Constants;
import com.codingblocks.codingblocks.utils.UtilityMethods;
import com.codingblocks.codingblocks.view.fragments.BookPageFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookBaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ExpandableListView expandableListView;
    public static final String TAG = "BookBase";
    Fragment fragment;
    String bookIntro = "";
    boolean themeId = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences  = getSharedPreferences(Constants.THEME_PREFS, Context.MODE_PRIVATE);
        themeId = sharedPreferences.getBoolean(Constants.THEME_KEY,false);
        if(themeId){
            setTheme(R.style.AppTheme_NoActionBar_white);
        }
        setContentView(R.layout.activity_book_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        Intent i = getIntent();
        final String bookId = i.getStringExtra(Constants.BOOK_ID_KEY);
        final String bookAuthor = i.getStringExtra(Constants.BOOK_AUTHOR_KEY);
        String bookName = i.getStringExtra(Constants.BOOK_NAME);
        actionBar.setTitle(bookName);

        final ArrayList<Chapter> groupList = new ArrayList<>();
        final HashMap<String, ArrayList<Chapter>> childMap = new HashMap<>();
        final ExapndableListAdapter exapndableListAdapter = new ExapndableListAdapter(this, groupList, childMap);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableListView = (ExpandableListView) findViewById(R.id.evNavigationList);

        if(themeId){
            expandableListView.setBackgroundColor(Color.parseColor("#fafafa"));
        }else{
            expandableListView.setBackgroundColor(Color.parseColor("#2d3143"));

        }
        if(UtilityMethods.isNetworkConnected(this)) {
            API.getInstance(BookBaseActivity.this)
                    .retrofit
                    .create(GitbookAPI.class)
                    .getThisBookChapters(bookAuthor, bookId)
                    .enqueue(new Callback<Contents>() {
                        @Override
                        public void onResponse(Call<Contents> call, Response<Contents> response) {

                            Log.d(TAG, "onResponse: " + response);

                            Pattern pattern = Pattern.compile("(?<=^| )\\d+(\\.\\d+)?(?=$| )");
                            String thisGroup = "";
                            ArrayList<Chapter> thisGroupChild = new ArrayList<Chapter>();
                            if (response.body() != null) {
                                bookIntro = response.body().getSections().get(0).getContent();

                                if (response.body().getProgress().getChapters() != null) {
                                    for (Chapter chapter : response.body().getProgress().getChapters()) {
                                        if (pattern.matcher(chapter.getLevel()).matches()) {
                                            thisGroup = chapter.getTitle();
                                            groupList.add(chapter);
                                            thisGroupChild = new ArrayList<Chapter>();
                                            Log.d(TAG, "onResponse: if" + thisGroup);

                                            if (chapter.getIndex() != 0) {
                                                thisGroupChild.add(chapter);
                                            }
                                            childMap.put(thisGroup, thisGroupChild);
                                        } else {
                                            thisGroupChild.add(chapter);
                                            childMap.put(thisGroup, thisGroupChild);
                                            Log.d(TAG, "onResponse: else" + chapter.getTitle());
                                        }
                                    }
                                }
                                fragment = BookPageFragment.getInstance(bookIntro, themeId);
                                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.add(R.id.flBookFrame, fragment);
                                fragmentTransaction.commit();

                                exapndableListAdapter.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onFailure(Call<Contents> call, Throwable t) {

                        }
                    });
        }


        expandableListView.setAdapter(exapndableListAdapter);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        drawer.addDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.d(TAG, "onChildClick: " + v.toString());
                if (childMap.get(groupList.get(groupPosition).getTitle()).get(childPosition) != null) {
                    Chapter thisChapter = childMap.get(groupList.get(groupPosition).getTitle()).get(childPosition);
                    thisChapter.setPath(thisChapter.getPath().replace(".md", ".json"));
                    Log.d(TAG, "onChildClick: " + thisChapter.getPath());
                    String[] chapters = thisChapter.getPath().split("\\/");
                    Log.d(TAG, "onChildClick: " + chapters[0] + " " + chapters[1]);
                    if (UtilityMethods.isNetworkConnected(BookBaseActivity.this)) {
                        API.getInstance(BookBaseActivity.this).retrofit
                                .create(GitbookAPI.class)
                                .getThisBookContent(
                                        bookAuthor,
                                        bookId,
                                        chapters[0],
                                        chapters[1]
                                )
                                .enqueue(new Callback<BookData>() {
                                    @Override
                                    public void onResponse(Call<BookData> call, Response<BookData> response) {
                                        Log.d(TAG, "onResponse: " + response.body());
                                        ((BookPageFragment) fragment).replacePage((response.body().getSections().get(0).getContent()));
                                    }

                                    @Override
                                    public void onFailure(Call<BookData> call, Throwable t) {
                                        Log.d(TAG, "onFailure: " + t.getMessage());
                                    }
                                });
                    }
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Log.d("TAG", "onNavigationItemSelected: " + item.getTitle());


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
