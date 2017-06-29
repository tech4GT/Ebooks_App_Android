package com.codingblocks.codingblocks.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.codingblocks.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.ExternalStyleSheet;


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
        markdownView = (MarkdownView) root.findViewById(R.id.markdown_view);
        Log.d(TAG, "onCreateView: ");
        markdownView.addStyleSheet(ExternalStyleSheet.fromAsset("blocks-of-javascript/styles/website.css",null));
        markdownView.loadMarkdownFromAsset("blocks-of-javascript/01-getting-started/01-1-running-javascript-code.md");

//        listAssetFiles("blocks-of-javascript");
//        for (File file : files){
//            Log.d(TAG, "onCreateView: " + file.getName());
//        }
//        String[] f = new String[0];
//        ArrayList<String[]> innerFiles = new ArrayList<>();
//
//        try {
//            f = getActivity().getAssets().list("blocks-of-javascript");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (String f1 : f){
//            Log.d(TAG, "onCreateView: File name : " + f1);
//            try {
//                innerFiles.add(getActivity().getAssets().list("blocks-of-javascript/" + f1));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        for (String[] f3 : innerFiles){
//            for (String f4 : f3){
//                Log.d(TAG, "onCreateView: " + f4);
//            }
//        }

        return root;
    }

    private List<File> getListFiles(File parentDir) {
        ArrayList<File> inFiles = new ArrayList<File>();
        File[] files = parentDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                inFiles.addAll(getListFiles(file));
            } else {
                if(file.getName().endsWith(".csv")){
                    inFiles.add(file);
                }
            }
        }
        return inFiles;
    }

    private boolean listAssetFiles(String path) {

        String [] list;
        try {
            list = getActivity().getAssets().list(path);
            if (list.length > 0) {
                // This is a folder
                for (String file : list) {
                    if (!listAssetFiles(path + "/" + file))
                        return false;
                }
            } else {
                // This is a file
                // TODO: add file name to an array list
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

}
