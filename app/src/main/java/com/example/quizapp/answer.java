package com.example.quizapp;

public class answer {

    private  int optionA,optionB,optionC,optionD,questionid,answerid;

    public answer(int questionid, int optionA, int optionB, int optionC, int optionD, int answerid) {
        this.questionid = questionid;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;

        this.answerid = answerid;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionid() {
        return questionid;
    }

    public int getAnswerid() {
        return answerid;
    }
}
