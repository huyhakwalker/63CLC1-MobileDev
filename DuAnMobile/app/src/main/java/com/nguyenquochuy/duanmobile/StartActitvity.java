package com.nguyenquochuy.duanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActitvity extends AppCompatActivity {

    private MediaPlayer bgmusic, welcome;
    Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        get();
        welcome.start();
        welcome.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                bgmusic.setLooping(true);
                bgmusic.start();
            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(StartActitvity.this,MainActivity.class);
                startActivity(myintent);
                welcome.pause();
                bgmusic.pause();
            }
        });
    }
    public void get(){
        bgmusic = MediaPlayer.create(this,R.raw.bgmusic);
        btn_start = findViewById(R.id.btn_start);
        welcome = MediaPlayer.create(this,R.raw.welcomegame);
    }
}