package com.learntodroid.simplealarmclock;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.AnnotatedElement;
import java.util.Random;

public class activity_quiz extends AppCompatActivity {
    Button answer1, answer2, answer3, answer4;
    ProgressBar prog_timer;
    TextView tv_timer, score, question;
    ImageView image;

    int secondsRemaining = 30;

    private  Questions mQuestions = new Questions();
    private String mAnswer;
    private int mScore = 0;
    private int mQestonsLength = mQuestions.mQuestions.length;

    Random r;


    CountDownTimer timer = new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long l) {
            secondsRemaining--;
            prog_timer.setProgress(30-secondsRemaining);
            tv_timer.setText("Time left: " + Integer.toString(secondsRemaining));

            if (mScore == 5){
                Intent intent = new Intent(activity_quiz.this, ActivitySuccess.class);
                startActivity(intent);
                finish();
                timer.cancel();
            }


        }


        @Override
        public void onFinish() {

            Intent intent = new Intent(activity_quiz.this, FailedTask.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score =  findViewById(R.id.score);
        question =  findViewById(R.id.question);
        tv_timer = findViewById(R.id.tv_timer);
        prog_timer = findViewById(R.id.progressBar);

        secondsRemaining = 30;
        timer.start();
        image = findViewById(R.id.image);

        score.setText("Score: " + mScore + "/5");

        updateQuestoin(r.nextInt(mQestonsLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore+ "/5");
                    updateQuestoin(r.nextInt(mQestonsLength));
                }
                else{
                    mScore--;
                    Toast.makeText(activity_quiz.this, "Are you sure about that?", Toast.LENGTH_SHORT).show();
                    score.setText("Score: " + mScore+ "/5");
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore+ "/5");
                    updateQuestoin(r.nextInt(mQestonsLength));
                }
                else{
                    mScore--;
                    Toast.makeText(activity_quiz.this, "Are you sure about that?", Toast.LENGTH_SHORT).show();
                    score.setText("Score: " + mScore+ "/5");
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore+ "/5");
                    updateQuestoin(r.nextInt(mQestonsLength));
                }
                else{
                    mScore--;
                    Toast.makeText(activity_quiz.this, "Are you sure about that?", Toast.LENGTH_SHORT).show();
                    score.setText("Score: " + mScore+ "/5");
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore+ "/5");
                    updateQuestoin(r.nextInt(mQestonsLength));
                }else{
                    mScore--;
                    Toast.makeText(activity_quiz.this, "Are you sure about that?", Toast.LENGTH_SHORT).show();
                    score.setText("Score: " + mScore+ "/5");
                }
            }
        });

    }

    private void updateQuestoin(int num) {
        question.setText(mQuestions.getQuestions(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));
        image.setImageDrawable(getResources().getDrawable(mQuestions.images[num]));
        mAnswer = mQuestions.getCorrectAnswer(num);

    }


}