package com.nguyenquochuy.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    Button btnOK;
    EditText edtUserName;
    EditText edtPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        get();
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tendn = edtUserName.getText().toString();
                String mk = edtPassWord.getText().toString();
                if(tendn.equals("nguyenquochuy") && mk.equals("18022003")){
                    Intent iQuiz = new Intent(ActivityLogin.this,ActivityHome.class);
                    iQuiz.putExtra("tendangnhap",tendn);
                    startActivity(iQuiz);
                }
                else {
                    Toast.makeText(ActivityLogin.this,"Sai thông tin đăng nhập",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void get(){
        btnOK = findViewById(R.id.btnOK);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassWord = findViewById(R.id.edtPassWord);
    }
}