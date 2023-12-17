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
    private Button trogiup;
    private List<Integer> lista = new ArrayList<>();
    private List<Integer> listb = new ArrayList<>();
    private List<Integer> listc = new ArrayList<>();
    private List<docCauHoiDe> listde;
    private List<docCauHoiTB> listtb;
    private List<docCauHoiKho> listkho;
    private int CurrentQuestion = 1;
    public static int FinalScore;
    Random rd = new Random();
    private int i = rd.nextInt(37);
    MediaPlayer ans_1, ans_2, ans_3, ans_4, ans_now,
                true_1, true_2, true_3, true_4,
                remove50;

    public static int getFinalScore() {
        return FinalScore;
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
        trogiup = findViewById(R.id.trogiup);

        ans_1 = MediaPlayer.create(this,R.raw.ans_1);
        ans_2 = MediaPlayer.create(this,R.raw.ans_2);
        ans_3 = MediaPlayer.create(this,R.raw.ans_3);
        ans_4 = MediaPlayer.create(this,R.raw.ans_4);
        ans_now = MediaPlayer.create(this,R.raw.ans_now);

        true_1 = MediaPlayer.create(this,R.raw.true_1);
        true_2 = MediaPlayer.create(this,R.raw.true_2);
        true_3 = MediaPlayer.create(this,R.raw.true_3);
        true_4 = MediaPlayer.create(this,R.raw.true_4);

        remove50 = MediaPlayer.create(this,R.raw.remove50);
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
        trogiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove50.start();
                trogiup();
                trogiup.setVisibility(View.GONE);
            }

        });
    }
    private void handleAnswerButtonClicked(Button clickedButton, MediaPlayer mediaPlayer) {
        String selectedAnswer = clickedButton.getText().toString();
        if (CurrentQuestion <= 5) {
            if (selectedAnswer.equals(listde.get(i).getDA())) {
                correctAnswer(clickedButton, mediaPlayer);
            } else {
                gameOver(clickedButton, listde.get(i).getDA().toString());
            }
        } else if (CurrentQuestion <= 10) {
            if (selectedAnswer.equals(listtb.get(i).getDA())) {
                correctAnswer(clickedButton, mediaPlayer);
            } else {
                gameOver(clickedButton, listtb.get(i).getDA().toString());
            }
        } else if (CurrentQuestion <= 15) {
            if (selectedAnswer.equals(listkho.get(i).getDA())) {
                correctAnswer(clickedButton, mediaPlayer);
            } else {
                gameOver(clickedButton, listkho.get(i).getDA().toString());
            }
        }
    }
    public void correctAnswer(Button trueButton, MediaPlayer player){
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
                    case 16:
                        Intent myintent = new Intent(MainActivity.this,EndActivity.class);
                        startActivity(myintent);
                        break;
                }
                hienthilai();
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
                FinalScore = CurrentQuestion;
                CurrentQuestion = 1;
            }
        }, 10500);
    }
    private void showDialogLose(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent myintent = new Intent(MainActivity.this,EndActivity.class);
                startActivity(myintent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void trogiup(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String ans1 = answerAButton.getText().toString();
                String ans2 = answerBButton.getText().toString();
                String ans3 = answerCButton.getText().toString();
                String ans4 = answerDButton.getText().toString();
                String c;
                int k = CurrentQuestion;
                if (CurrentQuestion <= 5) {
                    c = listde.get(i).getDA();
                    if(ans1.equals(c)){
                        answerBButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }if(ans2.equals(c)){
                        answerAButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }if(ans3.equals(c)){
                        answerAButton.setVisibility(View.GONE);
                        answerBButton.setVisibility(View.GONE);
                    }if(ans4.equals(c)){
                        answerBButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }
                } else if (CurrentQuestion <= 10) {
                    c = listtb.get(i).getDA();
                    if(ans1.equals(c)){
                        answerBButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }if(ans2.equals(c)){
                        answerAButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }if(ans3.equals(c)){
                        answerAButton.setVisibility(View.GONE);
                        answerBButton.setVisibility(View.GONE);
                    }if(ans4.equals(c)){
                        answerBButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }
                } else if (CurrentQuestion <= 15) {
                    c = listkho.get(i).getDA();
                    if(ans1.equals(c)){
                        answerBButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }if(ans2.equals(c)){
                        answerAButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }if(ans3.equals(c)){
                        answerAButton.setVisibility(View.GONE);
                        answerBButton.setVisibility(View.GONE);
                    }if(ans4.equals(c)){
                        answerBButton.setVisibility(View.GONE);
                        answerCButton.setVisibility(View.GONE);
                    }
                }
            }
        }, 4500);

    }
    private void hienthilai(){
        if (answerAButton.getVisibility() == View.GONE) {
            answerAButton.setVisibility(View.VISIBLE);
        }
        if (answerBButton.getVisibility() == View.GONE) {
            answerBButton.setVisibility(View.VISIBLE);
        }
        if (answerCButton.getVisibility() == View.GONE) {
            answerCButton.setVisibility(View.VISIBLE);
        }
        if (answerDButton.getVisibility() == View.GONE) {
            answerDButton.setVisibility(View.VISIBLE);
        }
    }
}





