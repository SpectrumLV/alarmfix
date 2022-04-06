package com.learntodroid.simplealarmclock;

import java.util.ArrayList;
import java.util.List;

public class GameMath {

    private List<Question> questions;
    private int numberCorrect;
    private int getNumberIncorrect;
    private int totalQuestions;
    private int score;



    private Question currentQuestion;


    public GameMath() {
        numberCorrect = 0;
        getNumberIncorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new Question(10);
        questions = new ArrayList<Question>();

    }

    public void makeNewQuestion() {
        currentQuestion = new Question(totalQuestions * 2 + 5);
        totalQuestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int submittedAnswer) {
        boolean isCorrect;
        if (currentQuestion.getAnswer() == submittedAnswer){
            numberCorrect++;
            isCorrect=true;
        }else{
            getNumberIncorrect++;
            isCorrect = false;
        }
        score = numberCorrect * 1 -getNumberIncorrect * 1;
        return isCorrect;
    }



    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getGetNumberIncorrect() {
        return getNumberIncorrect;
    }

    public void setGetNumberIncorrect(int getNumberIncorrect) {
        this.getNumberIncorrect = getNumberIncorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

}
