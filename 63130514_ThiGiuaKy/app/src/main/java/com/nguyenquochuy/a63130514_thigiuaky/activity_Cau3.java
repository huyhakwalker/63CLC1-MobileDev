package com.nguyenquochuy.a63130514_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_Cau3 extends AppCompatActivity {

    ArrayList<ThanhVien> dsQG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);
        dsQG = new ArrayList<ThanhVien>();
        ThanhVien qg1 = new ThanhVien("Đoàn Nguyễn Công Thạch", "thach","Khanh Hoa");
        ThanhVien qg2 = new ThanhVien("Diệp Gia Hội", "hoi","Khanh Hoa");
        ThanhVien qg3 = new ThanhVien("Phan Tâm Hoài Lân", "lan","Khanh Hoa");
        ThanhVien qg4 = new ThanhVien("Võ Văn Dương", "duong","Khanh Hoa");
        ThanhVien qg5 = new ThanhVien("Võ Văn Thành", "thanh","Khanh Hoa");
        dsQG.add(qg1);
        dsQG.add(qg2);
        dsQG.add(qg3);
        dsQG.add(qg4);
        dsQG.add(qg5);
        ListView lvQG = findViewById(R.id.Nation);
        ThanhVienArrayAdapter adapter;
        adapter = new ThanhVienArrayAdapter(dsQG,this);
        lvQG.setAdapter(adapter);
        Button btnback = findViewById(R.id.btnback3);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(activity_Cau3.this,MainActivity.class);
                startActivity(back);
            }
        });
    }
}