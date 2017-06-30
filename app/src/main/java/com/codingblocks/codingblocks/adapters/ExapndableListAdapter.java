package com.codingblocks.codingblocks.adapters;

import android.animation.LayoutTransition;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.codingblocks.codingblocks.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rishabhkhanna on 30/06/17.
 */

public class ExapndableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> groupList;
    private HashMap<String, ArrayList<String>> listDataChild;

    public ExapndableListAdapter(Context context, ArrayList<String> groupList, HashMap<String, ArrayList<String>> listDataChild) {
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

        return listDataChild.get(groupList.get(groupPosition)).size();
    }

    @Override
    public String getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        return listDataChild.get(groupList.get(groupPosition)).get(childPosition);
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
        View root = li.inflate(android.R.layout.simple_list_item_1,null);
        TextView textView = (TextView) root.findViewById(android.R.id.text1);
        textView.setText(getGroup(groupPosition));
        return root;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = li.inflate(R.layout.sublist_layout,null);
        TextView textView = (TextView) root.findViewById(R.id.tvSublist);
        textView.setText(getChild(groupPosition,childPosition));
        return root;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
