package com.example.steve.basiclabproject;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by ADIS HP on 2/12/2017.
 */

public class advertisementsAdapter extends ArrayAdapter<String> {

    private Context mContext = null;
    private TextView name=null,desc=null,price=null;



    public advertisementsAdapter(@NonNull Context context, @NonNull String[] objects) {
        super(context,R.layout.advertisement_custom_listview, objects);
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
          View mView= LayoutInflater.from(mContext).inflate(R.layout.advertisement_custom_listview,parent);
          name = (TextView) mView.findViewById(R.id.SellAdvName);
          desc = (TextView) mView.findViewById(R.id.SellAdvDesc);
          price = (TextView) mView.findViewById(R.id.SellAdvPrice);
          name.setText(getItem(position).split(",")[0]);
          desc.setText(getItem(position).split(",")[1]);
          price.setText(getItem(position).split(",")[2]);


        return mView;
    }
}
