package com.nguyenquochuy.duanmobile;

import java.util.List;

public class Question {
    private int Number;
    private String content;
    private List<Answer> listAnswer;

    public Question(int number, String content, List<Answer> listAnswer) {
        Number = number;
        this.content = content;
        this.listAnswer = listAnswer;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(List<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }
}
