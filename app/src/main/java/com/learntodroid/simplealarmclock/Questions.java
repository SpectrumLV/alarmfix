package com.learntodroid.simplealarmclock;

public class Questions {
    public String mQuestions[] = {
            "Which is capital of Latvia?",
            "Which is capital of England?",
            "Which is capital of Russia?",
            "Which is capital of Spain?",
            "Which is capital of USA?",
            "Which is capital of Finnland?",
            "Which is capital of Canada?",
            "Which is capital of Lithuania?",
            "Which is capital of Japan?",
                "Which is capital of France?",
                "Which is capital of Italy?",
                "Which is capital of Germany?",
                "Which is capital of Thailand?",
                "Which is capital of New Zealand?",
                "Which is capital of South Africa?",
    };

    private String mChoices[] [] = {
            {"Helsinki", "Tokyo", "Rio", "Riga"},
            {"Helsinki", "Tokyo", "Rio", "London"},
            {"Helsinki", "Tokyo", "Rio", "Moscow"},
            {"Helsinki", "Tokyo", "Rio", "Madrid"},
            {"Helsinki", "Tokyo", "Rio", "Whasington Dc"},
            {"Africa", "Tokyo", "Rio", "Helsinki"},
            {"Helsinki", "Tokyo", "Rio", "Otava"},
            {"Helsinki", "Tokyo", "Rio", "Vilnius"},
            {"Helsinki", "Tokyo", "Rio", "Vilnius"},
            {"Helsinki", "Tokyo", "Rio", "Paris"},
            {"Helsinki", "Tokyo", "Rio", "Rome"},
            {"Helsinki", "Tokyo", "Rio", "Berlin"},
            {"Helsinki", "Tokyo", "Rio", "Bangkok"},
            {"Helsinki", "Tokyo", "Rio", "Wellington"},
            {"Helsinki", "Tokyo", "Rio", "Cape Town"},
    };

    private String mCorrectAnswers[] = {"Riga", "London","Moscow", "Madrid", "Washington Dc", "Helsinki", "Otava", "Vilnius", "Tokyo",
    "Paris", "Rome", "Berlin", "Bangkok", "Wellington", "Cape Town"};

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
