package com.example.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv =  findViewById(R.id.lvHoliday);

        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic & Religion");

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String holiday = al.get(i);
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("holiday", holiday);
                startActivity(intent);
            }
        });

    }
}
