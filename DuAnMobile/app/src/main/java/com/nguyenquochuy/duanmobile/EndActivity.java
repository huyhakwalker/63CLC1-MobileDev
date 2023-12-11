package com.nguyenquochuy.duanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    TextView tv_score_end;
    MediaPlayer endmusic, wingames;

    Button btn_choilai, btn_trangchu;
    int set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        get();
        MainActivity m = new MainActivity();
        set = m.getCurrentQuestion();
        switch (set) {
            case 1:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 200.000");
                break;
            case 2:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 400.000");
                break;
            case 3:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 600.000");
                break;
            case 4:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 1.000.000");
                break;
            case 5:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 2.000.000");
                break;
            case 6:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 3.000.000");
                break;
            case 7:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 6.000.000");
                break;
            case 8:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 10.000.000");
                break;
            case 9:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 14.000.000");
                break;
            case 10:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 22.000.000");
                break;
            case 11:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 30.000.000");
                break;
            case 12:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 40.000.000");
                break;
            case 13:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 60.000.000");
                break;
            case 14:
                tv_score_end.setText("Điểm số cuối cùng của bạn là: 85.000.000");
                break;
        }
        endmusic.start();

    }
    public void get(){
        tv_score_end = findViewById(R.id.tv_score_end);
        endmusic = MediaPlayer.create(this,R.raw.sound_ket_thuc);
        wingames = MediaPlayer.create(this,R.raw.win_games);
        btn_choilai = findViewById(R.id.btn_choilai);
        btn_trangchu = findViewById(R.id.btn_trangchu);
    }
}