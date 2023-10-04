package com.example.xulysukien1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWiget();
    }
    void getWiget(){
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
    }
    public void XuLyLogin(View v){
        //B1: Lấy dữ liệu từ 2 EditText
        String tenDN = user.getText().toString();
        String mk = pass.getText().toString();
        //B2: Xử lí
        String ketqua;
        if(tenDN.equals("63130514")){
            if(mk.equals("12345678")){
                ketqua = "Login Success";
            }
            else{
                ketqua = "Login fail, Error Password";
            }
        }
        else {
            ketqua = "Login fail, Error Username";
        }
        //B3: Xuất kết quả
        Toast.makeText(this,ketqua,Toast.LENGTH_LONG).show();
    }
}