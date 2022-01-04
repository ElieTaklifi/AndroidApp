package com.example.my1app.model.model;

import java.util.List;

public class Question {

    //***Functions***//

    //Constractor
    public Question(String question, List<String> choiceList, int answerIndex) {
        mQuestion = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }

    //Get function
    public String getQuestion() {
        return mQuestion;
    }

    //Get function
    public List<String> getChoiceList() {
        return mChoiceList;
    }

    //Get function
    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    //******Members**********//
    private final String mQuestion;
    private final List<String> mChoiceList;
    private final int mAnswerIndex;
    //********//
}
