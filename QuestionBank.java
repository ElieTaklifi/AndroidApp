package com.example.my1app.model.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class QuestionBank implements Serializable {

    //***Functions***//

    //Function that shuffle all the questions in our array
    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;
        Collections.shuffle(mQuestionList);
    }

    //Function return the index of the current question
    public Question getCurrentQuestion() {
        return mQuestionList.get(mQuestionIndex);
    }

    //Function return the index of the next question
    public Question getNextQuestion() {
        mQuestionIndex++;
        return getCurrentQuestion();
    }

    //******//

    //******Members*********//
    private final List<Question> mQuestionList;
    private int mQuestionIndex;
    //**********************//
}