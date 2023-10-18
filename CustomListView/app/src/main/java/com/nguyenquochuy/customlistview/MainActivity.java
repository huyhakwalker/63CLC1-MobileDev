package com.nguyenquochuy.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> dsQG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsQG = new ArrayList<Country>();
        Country qg1 = new Country("Viet Nam", "img_2",100000000);
        Country qg2 = new Country("My", "img_1",1000000000);
        Country qg3 = new Country("Russia", "img",100000000);
        dsQG.add(qg1);
        dsQG.add(qg2);
        dsQG.add(qg3);
        ListView lvQG = findViewById(R.id.Nation);
        CountryArrayAdapter adapter;
        adapter = new CountryArrayAdapter(dsQG,this);
        lvQG.setAdapter(adapter);
    }
}