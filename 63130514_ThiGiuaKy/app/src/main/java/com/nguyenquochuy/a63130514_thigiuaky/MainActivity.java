package com.nguyenquochuy.a63130514_thigiuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btncau1;
    Button btncau2;
    Button btncau3;
    Button btncau4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get();
        cau1();
        cau2();
        cau3();
        cau4();
    }
    public void get(){
        btncau1 =(Button) findViewById(R.id.btnCau1);
        btncau2 = findViewById(R.id.btnCau2);
        btncau3 = findViewById(R.id.btnCau3);
        btncau4 = findViewById(R.id.btnCau4);
    }
    public void cau1(){
        btncau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau1intent = new Intent(MainActivity.this,activity_Cau1.class);
                startActivity(cau1intent);
            }
        });
    }
    public void cau2(){
        btncau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau2intent = new Intent(MainActivity.this,activity_Cau2.class);
                startActivity(cau2intent);
            }
        });
    }
    public void cau3(){
        btncau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau3intent = new Intent(MainActivity.this,activity_Cau3.class);
                startActivity(cau3intent);
            }
        });
    }
    public void cau4(){
        btncau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cau4intent = new Intent(MainActivity.this,activity_Cau4.class);
                startActivity(cau4intent);
            }
        });
    }
}