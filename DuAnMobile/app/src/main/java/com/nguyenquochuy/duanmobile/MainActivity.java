package com.nguyenquochuy.duanmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private TextView tvScore;
    private TextView tvContentQuestion;
    private Button answerAButton;
    private Button answerBButton;
    private Button answerCButton;
    private Button answerDButton;
    private List<Integer> lista = new ArrayList<>();
    private List<Integer> listb = new ArrayList<>();
    private List<Integer> listc = new ArrayList<>();
    private List<docCauHoiDe> listde;
    private List<docCauHoiTB> listtb;
    private List<docCauHoiKho> listkho;
    private int CurrentQuestion = 1;
    Random rd = new Random();
    private int i = rd.nextInt(37);

    MediaPlayer ans_1, ans_2, ans_3, ans_4, ans_now,
                true_1, true_2, true_3, true_4,
                star1, star2, star3, star4, star5, star6, star7,star8,star9,star10,star11,star12,star13,star14,star15;
    public int getCurrentQuestion() {
        return CurrentQuestion;
    }

    private int checkTrungCauDe() {
        int index;
        do {
            index = rd.nextInt(37);
        } while (lista.contains(index));
        lista.add(index);
        return index;
    }
    private int checkTrungCauTB() {
        int index;
        do {
            index = rd.nextInt(10);
        } while (listb.contains(index));
        listb.add(index);
        return index;
    }
    private int checkTrungCauKho() {
        int index;
        do {
            index = rd.nextInt(10);
        } while (listc.contains(index));
        listc.add(index);
        return index;
    }
    private void nextQuestion() {
        if(CurrentQuestion<=5){
            if(!listde.isEmpty()){
                i = checkTrungCauDe();
                loadCauHoiDe();
            }
        } else if (CurrentQuestion<=10) {
            if(!listtb.isEmpty()){
                i = checkTrungCauTB();
                loadCauHoiTB();
            }
        }
        else if (CurrentQuestion<=15) {
            if(!listkho.isEmpty()){
                i = checkTrungCauKho();
                loadCauHoiKho();
            }
        }
    }
    private void setDefaultColor(){
        answerAButton.setBackgroundResource(R.drawable.btn_bg_blue);
        answerBButton.setBackgroundResource(R.drawable.btn_bg_blue);
        answerCButton.setBackgroundResource(R.drawable.btn_bg_blue);
        answerDButton.setBackgroundResource(R.drawable.btn_bg_blue);
    }
    @SuppressLint("SetTextI18n")
    private void loadCauHoiDe(){
        if(listde != null && !listde.isEmpty()){
            tvQuestion.setText("Câu hỏi " + CurrentQuestion);
            tvContentQuestion.setText(listde.get(i).getNoidung());
            answerAButton.setText(listde.get(i).getDA1());
            answerBButton.setText(listde.get(i).getDA2());
            answerCButton.setText(listde.get(i).getDA3());
            answerDButton.setText(listde.get(i).getDA4());
            setDefaultColor();
        }
    }
    @SuppressLint("SetTextI18n")
    private void loadCauHoiTB(){
        if(listtb != null && !listtb.isEmpty()){
            tvQuestion.setText("Câu hỏi " + CurrentQuestion);
            tvContentQuestion.setText(listtb.get(i).getNoidung());
            answerAButton.setText(listtb.get(i).getDA1());
            answerBButton.setText(listtb.get(i).getDA2());
            answerCButton.setText(listtb.get(i).getDA3());
            answerDButton.setText(listtb.get(i).getDA4());
            setDefaultColor();
        }
    }

    @SuppressLint("SetTextI18n")
    private void loadCauHoiKho(){
        if(listkho != null && !listkho.isEmpty()){
            tvQuestion.setText("Câu hỏi " + CurrentQuestion);
            tvContentQuestion.setText(listkho.get(i).getNoidung());
            answerAButton.setText(listkho.get(i).getDA1());
            answerBButton.setText(listkho.get(i).getDA2());
            answerCButton.setText(listkho.get(i).getDA3());
            answerDButton.setText(listkho.get(i).getDA4());
            setDefaultColor();
        }
    }
    private void initUI(){
        tvQuestion = findViewById(R.id.tv_question);
        tvContentQuestion = findViewById(R.id.tv_content_question);
        tvScore = findViewById(R.id.tv_score);
        answerAButton = findViewById(R.id.btn_answer1);
        answerBButton = findViewById(R.id.btn_answer2);
        answerCButton = findViewById(R.id.btn_answer3);
        answerDButton = findViewById(R.id.btn_answer4);

        ans_1 = MediaPlayer.create(this,R.raw.ans_1);
        ans_2 = MediaPlayer.create(this,R.raw.ans_2);
        ans_3 = MediaPlayer.create(this,R.raw.ans_3);
        ans_4 = MediaPlayer.create(this,R.raw.ans_4);
        ans_now = MediaPlayer.create(this,R.raw.ans_now);

        true_1 = MediaPlayer.create(this,R.raw.true_1);
        true_2 = MediaPlayer.create(this,R.raw.true_2);
        true_3 = MediaPlayer.create(this,R.raw.true_3);
        true_4 = MediaPlayer.create(this,R.raw.true_4);

        star1 = MediaPlayer.create(this,R.raw.start_cau1);
        star2 = MediaPlayer.create(this,R.raw.start_cau2);
        star3 = MediaPlayer.create(this,R.raw.start_cau3);
        star4 = MediaPlayer.create(this,R.raw.start_cau4);
        star5 = MediaPlayer.create(this,R.raw.start_cau5);
        star6 = MediaPlayer.create(this,R.raw.start_cau6);
        star7 = MediaPlayer.create(this,R.raw.start_cau7);
        star8 = MediaPlayer.create(this,R.raw.start_cau8);
        star9 = MediaPlayer.create(this,R.raw.start_cau9);
        star10 = MediaPlayer.create(this,R.raw.start_cau10);
        star11 = MediaPlayer.create(this,R.raw.start_cau11);
        star12 = MediaPlayer.create(this,R.raw.start_cau12);
        star13 = MediaPlayer.create(this,R.raw.start_cau13);
        star14 = MediaPlayer.create(this,R.raw.start_cau14);
        star15 = MediaPlayer.create(this,R.raw.start_cau15);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        listde = docCauHoiDe.layDSCauHoiDe(this);
        listtb = docCauHoiTB.layDSCauHoiTB(this);
        listkho = docCauHoiKho.layDSCauHoiKho(this);
        if(CurrentQuestion<=5){
            if (!listde.isEmpty()) {
                loadCauHoiDe();
            }
        } else if (CurrentQuestion<=10) {
            if (!listtb.isEmpty()) {
                loadCauHoiTB();
            }
        } else if (CurrentQuestion<=15) {
            if (!listkho.isEmpty()) {
                loadCauHoiKho();
            }
        }
        answerAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerButtonClicked(answerAButton, true_1);
                answerAButton.setBackgroundResource(R.drawable.btn_bg_orange);
                ans_1.start();
                ans_1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        ans_now.start();
                    }
                });
            }
        });

        answerBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerButtonClicked(answerBButton, true_2);
                answerBButton.setBackgroundResource(R.drawable.btn_bg_orange);
                ans_2.start();
                ans_2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        ans_now.start();
                    }
                });
            }
        });

        answerCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerButtonClicked(answerCButton, true_3);
                answerCButton.setBackgroundResource(R.drawable.btn_bg_orange);
                ans_3.start();
                ans_3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        ans_now.start();
                    }
                });
            }
        });

        answerDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerButtonClicked(answerDButton, true_4);
                answerDButton.setBackgroundResource(R.drawable.btn_bg_orange);
                ans_4.start();
                ans_4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        ans_now.start();
                    }
                });
            }
        });
    }
    private void handleAnswerButtonClicked(Button clickedButton, MediaPlayer mediaPlayer) {
        String selectedAnswer = clickedButton.getText().toString();
        if (CurrentQuestion <= 5) {
            if (selectedAnswer.equals(listde.get(i).getDA())) {
                correctAnswer(clickedButton, mediaPlayer);
                //setScore(CurrentQuestion);
            } else {
                gameOver(clickedButton, listde.get(i).getDA().toString());
            }
        } else if (CurrentQuestion <= 10) {
            if (selectedAnswer.equals(listtb.get(i).getDA())) {
                correctAnswer(clickedButton, mediaPlayer);
                //setScore(CurrentQuestion);
            } else {
                gameOver(clickedButton, listtb.get(i).getDA().toString());
            }
        } else if (CurrentQuestion <= 15) {
            if (selectedAnswer.equals(listkho.get(i).getDA())) {
                correctAnswer(clickedButton, mediaPlayer);
                //setScore(CurrentQuestion);
            } else {
                gameOver(clickedButton, listkho.get(i).getDA().toString());
            }
        }
    }
    private void correctAnswer(Button trueButton, MediaPlayer player){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                trueButton.setBackgroundResource(R.drawable.btn_bg_green);
                player.start();
            }
        }, 10000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CurrentQuestion++;
                nextQuestion();
                switch (CurrentQuestion){
                    case 1:
                        tvScore.setText("200.000");
                        break;
                    case 2:
                        tvScore.setText("400.000");
                        break;
                    case 3:
                        tvScore.setText("600.000");
                        break;
                    case 4:
                        tvScore.setText("1.000.000");
                        break;
                    case 5:
                        tvScore.setText("2.000.000");
                        break;
                    case 6:
                        tvScore.setText("3.000.000");
                        break;
                    case 7:
                        tvScore.setText("6.000.000");
                        break;
                    case 8:
                        tvScore.setText("10.000.000");
                        break;
                    case 9:
                        tvScore.setText("14.000.000");
                        break;
                    case 10:
                        tvScore.setText("22.000.000");
                        break;
                    case 11:
                        tvScore.setText("30.000.000");
                        break;
                    case 12:
                        tvScore.setText("40.000.000");
                        break;
                    case 13:
                        tvScore.setText("60.000.000");
                        break;
                    case 14:
                        tvScore.setText("85.000.000");
                        break;
                    case 15:
                        tvScore.setText("150.000.000");
                        break;
                }
            }
        }, 13000);
    }
    private void gameOver(Button loseButton, String message){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loseButton.setBackgroundResource(R.drawable.btn_bg_red);
            }
        }, 10000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialogLose("Game Over! Đáp án đúng là " + message);
            }
        }, 11000);
    }
    private void showDialogLose(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CurrentQuestion = 1;
                dialog.dismiss();
                Intent myintent = new Intent(MainActivity.this,EndActivity.class);
                startActivity(myintent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}





