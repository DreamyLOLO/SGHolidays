package com.example.sgholidays;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> Holiday;
    private Context context;
    private TextView tvHolidayName;
    private TextView tvHolidayDate;
    private ImageView ivHoliday;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);
        Holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvHolidayName = (TextView)rowView.findViewById(R.id.tvHolidayName);
        tvHolidayDate = (TextView)rowView.findViewById(R.id.tvHolidayDate);
        ivHoliday = (ImageView)rowView.findViewById(R.id.ivHoliday);

        Holiday currentholiday = Holiday.get(position);

        tvHolidayName.setText(currentholiday.getName());
        tvHolidayDate.setText(currentholiday.getDate());
        ivHoliday.setImageResource(currentholiday.getImage());

        return rowView;

    }



}
