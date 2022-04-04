package com.learntodroid.simplealarmclock;

import android.graphics.drawable.Drawable;

import java.util.Random;

public class Questions {
    public String mQuestions[] = {
            "What is the capital of Latvia?",
            "What is the capital of England?",
            "What is the capital of Russia?",
            "What is the capital of Spain?",
            "What is the capital of the USA?",
            "What is the capital of Finland?",
            "What is the capital of Canada?",
            "What is the capital of Lithuania?",
            "What is the capital of Japan?",
                "What is the capital of France?",
                "What is the capital of Italy?",
                "What is the capital of Germany?",
                "What is the capital of Thailand?",
                "What is the capital of New Zealand?",
                "What is the capital of South Africa?",
    };

    private String mChoices[] [] = {
            {"Helsinki", "Tokyo", "Paris", "Riga"},
            {"London", "New York", "Rio","Helsinki"},
            {"Helsinki", "Moscow", "Rio", "Tokyo"},
            {"Helsinki", "Tokyo", "Madrid", "Rio"},
            {"Helsinki", "Tokyo", "New York", "Washington Dc"},
            {"Helsinki", "Tokyo", "Rio", "Africa"},
            {"Singapore", "Ottawa", "Rio", "Dubai"},
            {"Helsinki", "Tokyo", "Rio", "Vilnius"},
            {"Helsinki", "Tokyo", "Rio", "Vilnius"},
            {"Paris", "Tokyo", "Rio", "Helsinki"},
            {"Helsinki", "Rome", "Rio", "Tokyo"},
            {"Helsinki", "Rome", "Berlin", "Rio"},
            {"Bangkok", "Tokyo", "Rio", "Helsinki"},
            {"Helsinki", "Tokyo", "Wellington", "Rio"},
            {"Cape Town", "Tokyo", "Singapore", "Japan"},
    };

    private String mCorrectAnswers[] = {"Riga", "London","Moscow", "Madrid", "Washington Dc", "Helsinki", "Ottawa", "Vilnius", "Tokyo",
    "Paris", "Rome", "Berlin", "Bangkok", "Wellington", "Cape Town"};

    public int images[] = {
            R.drawable.riga1,
            R.drawable.london2,
            R.drawable.moscow3,
            R.drawable.madrid4,
            R.drawable.washington5,
            R.drawable.helsinki6,
            R.drawable.ottawa7,
            R.drawable.vilnus8,
            R.drawable.tokyo9,
            R.drawable.paris10,
            R.drawable.rome11,
            R.drawable.berlin12,
            R.drawable.bangkok13,
            R.drawable.wellington14,
            R.drawable.capetown15,
    };

    public String getQuestions(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1 (int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2 (int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3 (int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4 (int a){
        String choice = mChoices[a][3];
        return choice;
    }


    public String getCorrectAnswer(int a){
        String answer =mCorrectAnswers[a];
        return answer;
    }


}
