package com.example.appbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText    w;
    EditText    h;
    TextView    r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getinfo();
    }
    void getinfo(){
        w = findViewById(R.id.weight);
        h = findViewById(R.id.height);
        r =(TextView)findViewById(R.id.result);
    }
    public void xuly(View v){
        String W = w.getText().toString();
        String H = h.getText().toString();
        Float cannang = Float.parseFloat(W);
        Float chieucao = Float.parseFloat(H);
        Float ketqua = cannang/(chieucao*chieucao);
        if(ketqua<18.5){
            r.setText(ketqua.toString());
            Toast.makeText(this,"Cân nặng thấp (gầy)",Toast.LENGTH_LONG).show();
        } else if (ketqua>=18.5 && ketqua < 25) {
            r.setText(ketqua.toString());
            Toast.makeText(this,"Bình Thường",Toast.LENGTH_LONG).show();
        } else if (ketqua==25) {
            r.setText(ketqua.toString());
            Toast.makeText(this,"Thừa cân",Toast.LENGTH_LONG).show();
        } else if (ketqua>25 && ketqua<30) {
            r.setText(ketqua.toString());
            Toast.makeText(this,"Béo phì",Toast.LENGTH_LONG).show();
        }else if (ketqua>=30 && ketqua<35){
            r.setText(ketqua.toString());
            Toast.makeText(this,"Béo phì độ I",Toast.LENGTH_LONG).show();
        } else if (ketqua>=35 && ketqua < 40) {
            r.setText(ketqua.toString());
            Toast.makeText(this,"Béo phì độ II",Toast.LENGTH_LONG).show();
        }
    }

}