package com.example.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvType;

    ArrayList<Holiday> Sholiday = new ArrayList<Holiday>(Arrays.asList(new Holiday("New Year's Day", "1 Jan 2020", R.drawable.newyear), new Holiday("Labour Day", "1 May 2020", R.drawable.labourday), new Holiday("National Day", "9 Aug 2020", R.drawable.nationalday)));
    ArrayList<Holiday> ERholiday = new ArrayList<Holiday>(Arrays.asList(new Holiday("Chinese New Year", "25-26 Jan 2020", R.drawable.cny), new Holiday("Good Friday", "10 April 2020", R.drawable.goodfriday), new Holiday("Vesak Day", "7 May 2020", R.drawable.vesakday), new Holiday("Hari Raya Puasa", "24 May 2020", R.drawable.harirayapuasa), new Holiday("Hari Raya Haji", "31 July 2020", R.drawable.harirayahaji), new Holiday("Deepavali", "14 Nov 2020", R.drawable.deepavali), new Holiday("Christmas Day", "25 Dec 2020", R.drawable.christmas)));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView)findViewById(R.id.lvHolidays);
        tvType = (TextView)findViewById(R.id.tvType);

        Intent i = getIntent();
        final String holiday = i.getStringExtra("holiday");
        tvType.setText(holiday);

        if (holiday.equals("Secular")) {
            ArrayAdapter adapter = new HolidayAdapter(this, R.layout.row, Sholiday);
            lv.setAdapter(adapter);
        } else if (holiday.equals("Ethnic & Religion")) {
            ArrayAdapter adapter = new HolidayAdapter(this, R.layout.row, ERholiday);
            lv.setAdapter(adapter);
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (holiday.equals("Secular")) {
                    Toast.makeText(getApplicationContext(), Sholiday.get(position).getName() + " Date:" + Sholiday.get(position).getDate(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), ERholiday.get(position).getName() + " Date:" + ERholiday.get(position).getDate(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
