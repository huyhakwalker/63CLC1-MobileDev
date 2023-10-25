package com.nguyenquochuy.a63130514_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_Cau2 extends AppCompatActivity {

    ArrayList<String> danhsachNQH = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);
        get();
        danhsachNQH.add("Gà rán");
        danhsachNQH.add("Heo quay");
        danhsachNQH.add("Trứng lộn");
        danhsachNQH.add("Mứt dừa");
        danhsachNQH.add("Nem nướng");
        danhsachNQH.add("Bún riêu");
        ArrayAdapter<String> adapterNQH = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,danhsachNQH);
        lvNQH.setAdapter(adapterNQH);
        lvNQH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mucchon = danhsachNQH.get(i);
                String chuoithongbao = "You selected " + mucchon;
                Toast.makeText(activity_Cau2.this,chuoithongbao,Toast.LENGTH_SHORT).show();
            }
        });
        Button btnback = findViewById(R.id.btnback2);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(activity_Cau2.this,MainActivity.class);
                startActivity(back);
            }
        });
    }
    public void get(){
        lvNQH = findViewById(R.id.LVNQH);
    }
    ListView lvNQH;
}