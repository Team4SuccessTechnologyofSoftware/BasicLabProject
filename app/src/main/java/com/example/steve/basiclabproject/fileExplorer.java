package com.example.steve.basiclabproject;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
import static com.example.steve.basiclabproject.R.layout.activity_file_explorer;

public class fileExplorer extends ListActivity {

    private String path;
    String  filename;
    private static final int OK_CODE = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_file_explorer);

        // Use the current directory as title
        path = "/";
        if (getIntent().hasExtra("path")) {
            path = getIntent().getStringExtra("path");
        }
        setTitle(path);

        // Read all files sorted into the values-array
        List values = new ArrayList();
        File dir = new File(path);
        if (!dir.canRead()) {
            setTitle(getTitle() + " (inaccessible)");
        }
        String[] list = dir.list();
        if (list != null) {
            for (String file : list) {
                if (!file.startsWith(".")) {
                    values.add(file);
                }
            }
        }
        Collections.sort(values);

        // Put the data into the list
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_2, android.R.id.text1, values);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
         filename = (String) getListAdapter().getItem(position);
        if (path.endsWith(File.separator)) {
            filename = path + filename;
        } else {
            String filen = path + File.separator + filename;
            filename = filen;
            finish();
        }
         if (new File(filename).isDirectory()) {
             Intent intent = new Intent(this, fileExplorer.class);
             intent.putExtra("path", filename);
             startActivity(intent);
         }

    }

    @Override
    public void finish(){
        Intent data = new Intent(this,sellActivity.class);
        //data.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        data.putExtra("fileNa",filename);
        startActivity(data);
    }
}
