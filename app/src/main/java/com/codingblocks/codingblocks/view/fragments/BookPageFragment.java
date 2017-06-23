package com.codingblocks.codingblocks.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.codingblocks.R;

import us.feras.mdv.MarkdownView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookPageFragment extends Fragment {


    MarkdownView markdownView;
    public static final String TAG = "BookPageFragment";
    public BookPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_page, container, false);
        markdownView = (MarkdownView) root.findViewById(R.id.markdownView);
        Log.d(TAG, "onCreateView: ");
        markdownView.loadMarkdownFile("file:///android_asset/" +
                "blocks-of-javascript/01-getting-started/01-1-running-javascript-code.md"
                , "file:///android_asset/" + "blocks-of-javascript/styles/website.css");

        return root;
    }

}
