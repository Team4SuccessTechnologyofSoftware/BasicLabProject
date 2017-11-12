package com.example.steve.basiclabproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
//sa
public class Search extends AppCompatActivity {

    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        ExpandableListViewAdapter adapter = new ExpandableListViewAdapter(Search.this);
        expandableListView.setAdapter(adapter);
    }
}
