package com.nguyenquochuy.duanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    TextView tv_score_end;
    MediaPlayer endmusic, wingames;

    Button btn_choilai, btn_trangchu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        get();
        MainActivity m = new MainActivity();
        switch (m.getCurrentQuestion()) {
            case 1:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 200.000");
                endmusic.start();
                break;
            case 2:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 400.000");
                endmusic.start();
                break;
            case 3:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 600.000");
                endmusic.start();
                break;
            case 4:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 1.000.000");
                endmusic.start();
                break;
            case 5:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 2.000.000");
                endmusic.start();
                break;
            case 6:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 3.000.000");
                endmusic.start();
                break;
            case 7:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 6.000.000");
                endmusic.start();
                break;
            case 8:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 10.000.000");
                endmusic.start();
                break;
            case 9:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 14.000.000");
                endmusic.start();
                break;
            case 10:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 22.000.000");
                endmusic.start();
                break;
            case 11:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 30.000.000");
                endmusic.start();
                break;
            case 12:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 40.000.000");
                endmusic.start();
                break;
            case 13:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 60.000.000");
                endmusic.start();
                break;
            case 14:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 85.000.000");
                endmusic.start();
                break;
            case 15:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 150.000.000");
                wingames.start();
                break;
        }
        btn_trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(EndActivity.this,StartActitvity.class);
                startActivity(myintent);
                endmusic.pause();
            }
        });
        btn_choilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(EndActivity.this,MainActivity.class);
                startActivity(myintent);
                endmusic.pause();
            }
        });
    }
    public void get(){
        tv_score_end = findViewById(R.id.tv_score_end);
        endmusic = MediaPlayer.create(this,R.raw.sound_ket_thuc);
        wingames = MediaPlayer.create(this,R.raw.win_games);
        btn_choilai = findViewById(R.id.btn_choilai);
        btn_trangchu = findViewById(R.id.btn_trangchu);
    }
}