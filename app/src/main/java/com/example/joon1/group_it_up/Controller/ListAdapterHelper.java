package com.example.joon1.group_it_up.Controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joon1.group_it_up.R;

/**
 * Created by Minky on 2018-03-03.
 */

public class ListAdapterHelper extends ArrayAdapter {
    private final Activity context;
    private final String[] tArray;
    private final String[] sArray;

    public ListAdapterHelper(Activity context, String[] tArray, String[] sArray) {
        super(context, R.layout.listview_row, tArray);

        this.context = context;
        this.tArray = tArray;
        this.sArray = sArray;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView titleText = (TextView) rowView.findViewById(R.id.titleView);
        TextView sportsText = (TextView) rowView.findViewById(R.id.sportsView);
//        ImageView image = (ImageView) rowView.findViewById(R.id.imageView);
        titleText.setText(tArray[position]);
        sportsText.setText(sArray[position]);
        return rowView;
    }
}
