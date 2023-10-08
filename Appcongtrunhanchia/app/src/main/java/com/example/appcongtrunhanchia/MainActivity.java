package com.example.appcongtrunhanchia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText a;
    EditText b;
    TextView kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAB();
    }
    void getAB(){
        a = findViewById(R.id.edtA);
        b = findViewById(R.id.edtB);
        kq = (TextView) findViewById(R.id.kq);
    }
    public void Xulycong(View v){
        String A = a.getText().toString();
        String B = b.getText().toString();
        Float soA = Float.parseFloat(A);
        Float soB = Float.parseFloat(B);
        Float ketqua = soA + soB;
        String op = String.valueOf(ketqua);
        kq.setText(op);
    }
    public void Xulytru(View v){
        String A = a.getText().toString();
        String B = b.getText().toString();
        Float soA = Float.parseFloat(A);
        Float soB = Float.parseFloat(B);
        Float ketqua = soA - soB;
        String op = String.valueOf(ketqua);
        kq.setText(op);
    }
    public void Xulynhan(View v){
        String A = a.getText().toString();
        String B = b.getText().toString();
        Float soA = Float.parseFloat(A);
        Float soB = Float.parseFloat(B);
        Float ketqua = soA * soB;
        String op = String.valueOf(ketqua);
        kq.setText(op);
    }
    public void Xulychia(View v){
        String A = a.getText().toString();
        String B = b.getText().toString();
        Float soA = Float.parseFloat(A);
        Float soB = Float.parseFloat(B);
        if(soB == 0){
            kq.setText("Không thể chia cho 0");
        }
        else{
            Float ketqua = soA / soB;
            String op = String.valueOf(ketqua);
            kq.setText(op);
        }
    }
}