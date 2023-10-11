package com.nguyenquochuy.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> danhsachNQH = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get();
        danhsachNQH.add("C");
        danhsachNQH.add("C#");
        danhsachNQH.add("Python");
        danhsachNQH.add("Java");
        danhsachNQH.add("Ruby");
        danhsachNQH.add("HTML");
        ArrayAdapter<String> adapterNQH = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,danhsachNQH);
        lvNQH.setAdapter(adapterNQH);
        lvNQH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mucchon = danhsachNQH.get(i);
                String chuoithongbao = "You selected " + mucchon;
                Toast.makeText(MainActivity.this,chuoithongbao,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void get(){
        lvNQH = findViewById(R.id.LVNQH);
    }
    ListView lvNQH;
}