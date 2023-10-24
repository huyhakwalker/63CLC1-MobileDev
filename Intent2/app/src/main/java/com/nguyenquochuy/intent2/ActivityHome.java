package com.nguyenquochuy.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityHome extends AppCompatActivity {
    Intent intentTuLogin = getIntent();
    TextView tvTenDN = findViewById(R.id.tvUserName);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        nhan();
    }
    public void nhan(){
        String tendnnhanduoc = intentTuLogin.getStringExtra("tendangnhap");
        tvTenDN.setText(tendnnhanduoc);
    }
}