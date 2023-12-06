package com.nguyenquochuy.duanmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    }
    private TextView tvQuestion;
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

    private int CurrentQuestion = 0;

    Random rd = new Random();
    private int i = rd.nextInt(37);
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
    private void loadCauHoiDe(){
        if(listde != null && !listde.isEmpty()){
            tvQuestion.setText(CurrentQuestion);
            tvContentQuestion.setText(listde.get(i).getNoidung());
            answerAButton.setText(listde.get(i).getDA1());
            answerBButton.setText(listde.get(i).getDA2());
            answerCButton.setText(listde.get(i).getDA3());
            answerDButton.setText(listde.get(i).getDA4());
        }
    }
    private void loadCauHoiTB(){
        if(listtb != null && !listtb.isEmpty()){
            tvQuestion.setText(CurrentQuestion);
            tvContentQuestion.setText(listde.get(i).getNoidung());
            answerAButton.setText(listde.get(i).getDA1());
            answerBButton.setText(listde.get(i).getDA2());
            answerCButton.setText(listde.get(i).getDA3());
            answerDButton.setText(listde.get(i).getDA4());
        }
    }
    private void loadCauHoiKho(){
        if(listkho != null && !listkho.isEmpty()){
            tvQuestion.setText(CurrentQuestion);
            tvContentQuestion.setText(listde.get(i).getNoidung());
            answerAButton.setText(listde.get(i).getDA1());
            answerBButton.setText(listde.get(i).getDA2());
            answerCButton.setText(listde.get(i).getDA3());
            answerDButton.setText(listde.get(i).getDA4());
        }
    }
    private void initUI(){
        tvQuestion = findViewById(R.id.tv_question);
        tvContentQuestion = findViewById(R.id.tv_content_question);
        answerAButton = findViewById(R.id.btn_answer1);
        answerBButton = findViewById(R.id.btn_answer2);
        answerCButton = findViewById(R.id.btn_answer3);
        answerDButton = findViewById(R.id.btn_answer4);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        listde = docCauHoiDe.layDSCauHoiDe();
        listtb = docCauHoiTB.layDSCauHoiTB();
        listkho = docCauHoiKho.layDSCauHoiKho();
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
                handleAnswerButtonClicked(answerAButton);
            }
        });

        answerBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerButtonClicked(answerBButton);
            }
        });

        answerCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerButtonClicked(answerCButton);
            }
        });

        answerDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerButtonClicked(answerDButton);
            }
        });
    }
    private void handleAnswerButtonClicked(Button clickedButton) {
        String selectedAnswer = clickedButton.getText().toString();
        if (CurrentQuestion <= 5) {
            if (selectedAnswer.equals(listde.get(i).getDA())) {
                Toast.makeText(this, "Chúc mừng bạn đã trả lời đúng", Toast.LENGTH_SHORT).show();
                CurrentQuestion++;
                nextQuestion();
                //setScore(CurrentQuestion);
            } else {
                Toast.makeText(this, "Sai", Toast.LENGTH_SHORT).show();
            }
        } else if (CurrentQuestion <= 10) {
            if (selectedAnswer.equals(listtb.get(i).getDA())) {
                Toast.makeText(this, "Chúc mừng bạn đã trả lời đúng", Toast.LENGTH_SHORT).show();
                CurrentQuestion++;
                nextQuestion();
                //setScore(CurrentQuestion);
            } else {
                Toast.makeText(this, "Sai", Toast.LENGTH_SHORT).show();
            }
        } else if (CurrentQuestion <= 15) {
            if (selectedAnswer.equals(listkho.get(i).getDA())) {
                Toast.makeText(this, "Chúc mừng bạn đã trả lời đúng", Toast.LENGTH_SHORT).show();
                CurrentQuestion++;
                nextQuestion();
                //setScore(CurrentQuestion);
            } else {
                Toast.makeText(this, "Sai", Toast.LENGTH_SHORT).show();
            }
        }
    }


//    private void setDataQuestion(Question question) {
//        if(question == null){
//            return;
//        }
//        mQuestion = question;
//        String titleQuestion = "Question " + question.getNumber();
//        tvQuestion.setText(titleQuestion);
//        tvContentQuestion.setText(question.getContent());
//        tvAnswer1.setText(question.getListAnswer().get(0).getContent());
//        tvAnswer2.setText(question.getListAnswer().get(1).getContent());
//        tvAnswer3.setText(question.getListAnswer().get(2).getContent());
//        tvAnswer4.setText(question.getListAnswer().get(3).getContent());
//
//        tvAnswer1.setOnClickListener(this);
//        tvAnswer2.setOnClickListener(this);
//        tvAnswer3.setOnClickListener(this);
//        tvAnswer4.setOnClickListener(this);
//    }
//    private void checkAnswer(TextView textView, Question question, final Answer answer){
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(answer.isCorrect()){
//                    textView.setBackgroundResource(R.drawable.bg_green_corner_30);
//                    nexQuestion();
//                }
//                else {
//                    textView.setBackgroundResource(R.drawable.bg_red_corner_30);
////                    showAnswerCorrect(question);
//                    gameOver();
//                }
//            }
//        }, 1000);
//    }

//    private void gameOver() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showDialog("Game Over");
//            }
//        }, 1000);
//    }

//    private void showAnswerCorrect(Question question) {
//        if(question == null || question.getListAnswer() == null || question.getListAnswer().isEmpty()){
//            return;
//        }
//        if(question.getListAnswer().get(0).isCorrect()){
//            tvAnswer1.setBackgroundResource(R.drawable.bg_green_corner_30);
//        } else if (question.getListAnswer().get(1).isCorrect()) {
//            tvAnswer2.setBackgroundResource(R.drawable.bg_green_corner_30);
//        } else if (question.getListAnswer().get(2).isCorrect()){
//            tvAnswer3.setBackgroundResource(R.drawable.bg_green_corner_30);
//        } else if (question.getListAnswer().get(3).isCorrect()) {
//            tvAnswer4.setBackgroundResource(R.drawable.bg_green_corner_30);
//        }
//    }


//    private void showDialog(String message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(message);
//        builder.setCancelable(false);
//
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                CurrentQuestion = 0;
//                setDataQuestion(mListQuestion.get(currentQuestion));
//                dialog.dismiss();
//            }
//        });
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
}









