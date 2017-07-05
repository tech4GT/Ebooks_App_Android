package com.codingblocks.codingblocks.adapters;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.codingblocks.codingblocks.R;
import com.codingblocks.codingblocks.models.Chapter;
import com.codingblocks.codingblocks.utils.GetSharedPrefsValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rishabhkhanna on 30/06/17.
 */

public class ExapndableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<Chapter> groupList;
    private HashMap<String, ArrayList<Chapter>> listDataChild;
    public static final String TAG = "Expandable List View";
    public ExapndableListAdapter(Context context, ArrayList<Chapter> groupList, HashMap<String, ArrayList<Chapter>> listDataChild) {
        this.context = context;
        this.groupList = groupList;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return listDataChild.get(groupList.get(groupPosition).getTitle()).size();
    }

    @Override
    public Chapter getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Chapter getChild(int groupPosition, int childPosition) {
        return listDataChild.get(groupList.get(groupPosition).getTitle()).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = li.inflate(R.layout.navigation_group_list_layout,null);
        TextView textView = (TextView) root.findViewById(R.id.tvGroupList);
        textView.setText(getGroup(groupPosition).getTitle());
        if(GetSharedPrefsValue.getTheme(context)){
            textView.setTextColor(Color.parseColor("#364149"));
        }else{
            textView.setTextColor(Color.parseColor("#c1c6d7"));
        }

        return root;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = li.inflate(R.layout.sublist_layout,null);
        TextView textView = (TextView) root.findViewById(R.id.tvSublist);
        Chapter thisChapter = getChild(groupPosition,childPosition);
        if (thisChapter == getChild(groupPosition,0)){

            Log.d(TAG, "getChildView: " + thisChapter.getLevel().charAt(0));
            textView.setText(String.valueOf(Integer.parseInt(String.valueOf(thisChapter.getLevel().charAt(2))) - 1)+ ". Introduction");
        }else {
            textView.setText(thisChapter.getTitle());
        }

        if(GetSharedPrefsValue.getTheme(context)){
            textView.setTextColor(Color.parseColor("#364149"));
        }else{
            textView.setTextColor(Color.parseColor("#c1c6d7"));
        }

        return root;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
