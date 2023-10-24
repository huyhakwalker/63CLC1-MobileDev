package com.nguyenquochuy.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildActivity extends AppCompatActivity {
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        get();
        back();
    }
    public void get(){
        btnback = findViewById(R.id.btnback);
    }
    public void back(){
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(ChildActivity.this,MainActivity.class);
                startActivity(myintent);
            }
        });
    }
}