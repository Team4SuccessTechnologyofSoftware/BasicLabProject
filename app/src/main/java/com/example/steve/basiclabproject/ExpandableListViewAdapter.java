package com.example.steve.basiclabproject;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
//by lefterissad
/**
 * Created by Firnen on 5/11/2017.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    String[] groupNames = {"Homes","Vehicles","Computers ","Musical Organs","Personal Objects","Clothes"};
    String[] [] childNames = {
            {"Apartement","Residence","Country House"}
            ,{"Cars","Motorbikes","Bicycles"}
            ,{"PC","laptop","Computer/Laptop parts","Mobile Phones"}
            ,{"Guitars","Basses","Drums","Pneumatics","Classical Organs"}
            ,{"Furnitures","Home Devices","Jewells","Design","Hobbies"}
            ,{"Women","Men","Girls","Boys"}
    };
    Context context;
    public ExpandableListViewAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getGroupCount() {
        return groupNames.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return childNames[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return groupNames[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return childNames[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText(groupNames[i]);
        textView.setPadding(100,0,0,0);
        textView.setTextColor(Color.WHITE);
        return textView;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final TextView textView = new TextView(context);
        textView.setText(childNames[i][i1]);
        textView.setPadding(100,0,0,0);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(30);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,textView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        return textView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
