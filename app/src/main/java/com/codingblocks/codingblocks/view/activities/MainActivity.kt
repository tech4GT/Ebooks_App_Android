package com.codingblocks.codingblocks.view.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.PersistableBundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast


import com.codingblocks.codingblocks.R
import com.codingblocks.codingblocks.adapters.AllBooksAdapter
import com.codingblocks.codingblocks.interfaces.onItemClickListener
import com.codingblocks.codingblocks.models.AuthorBooksCB
import com.codingblocks.codingblocks.models.List
import com.codingblocks.codingblocks.network.API
import com.codingblocks.codingblocks.network.interfaces.GitbookAPI
import com.codingblocks.codingblocks.utils.Constants
import com.codingblocks.codingblocks.utils.UtilityMethods
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    internal val progressBar by lazy {
        indeterminateProgressDialog("Fetching your books", "Loading")
    }
    lateinit internal var allBooks: ArrayList<List>
    lateinit internal var allBooksAdapter: AllBooksAdapter
    internal var themeId = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        themeId = getSharedPreferences(Constants.THEME_PREFS, Context.MODE_PRIVATE).getBoolean(Constants.THEME_KEY, false).apply {
            when (this) {
                true -> setTheme(R.style.AppTheme_white)
            }
        }
        Log.d(TAG, "onCreate: created" + themeId)
        setContentView(R.layout.activity_main)

        allBooks = ArrayList()
        allBooksAdapter = AllBooksAdapter(this, allBooks)
        rvAllBooks.layoutManager = LinearLayoutManager(this)
        rvAllBooks.adapter = allBooksAdapter
        fetchBooks()

        swipeRefreshAllBooks.setOnRefreshListener {
            swipeRefreshAllBooks.isRefreshing = false
            allBooks.clear()
            fetchBooks()
        }


        allBooksAdapter.setClickListener {
            startActivity(Intent(this@MainActivity, BookBaseActivity::class.java)
                    .putExtra(Constants.BOOK_ID_KEY, it.name)
                    .putExtra(Constants.BOOK_AUTHOR_KEY, it.author.username)
                    .putExtra(Constants.BOOK_NAME, it.title))
            recreate()
        }

        Log.d(TAG, "onCreate: " + this.cacheDir)
        Log.d(TAG, "onCreate: " + this.applicationContext.cacheDir)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        Log.d(TAG, "onSaveInstanceState: ")
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        super.onPause()
    }

    fun fetchBooks() {
        when (UtilityMethods.isNetworkConnected(this)) {
            true -> doAsync {
                uiThread {
                    progressBar.show()
                }
                API.getInstance(this@MainActivity)
                        .retrofit
                        .create(GitbookAPI::class.java)
                        .allBooks.execute().body()?.let {
                    allBooks.addAll(it?.list)
                }
                uiThread {
                    allBooksAdapter.notifyDataSetChanged()
                    progressBar.dismiss()
                }
            }
        }
    }


    fun toggleTheme() {
        getSharedPreferences(Constants.THEME_PREFS, Context.MODE_PRIVATE).apply {

            if (this.getBoolean(Constants.THEME_KEY, false)) edit().putBoolean(Constants.THEME_KEY, false).commit()
            else edit().putBoolean(Constants.THEME_KEY, true).commit()

            recreate()

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.chose_theme -> toggleTheme()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.base_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}