package com.nguyenquochuy.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> item = new ArrayList<Item>();
        item.add(new Item("Hoi", "diegiahoi@gmail.com",R.drawable.hoi));
        item.add(new Item("Duong", "vovanduong@gmail.com",R.drawable.duong));
        item.add(new Item("Lan", "phantamhoailan@gmail.com",R.drawable.lan));
        item.add(new Item("Thanh", "vovanthanh@gmail.com",R.drawable.thanh));
        item.add(new Item("Thach", "doannguyencongthach@gmail.com",R.drawable.thach));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),item));

    }
}