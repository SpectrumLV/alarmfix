package com.learntodroid.simplealarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.learntodroid.simplealarmclock.activities.MainActivity;

public class mat_activity extends AppCompatActivity {

    Button btn_start,btn_answer0, btn_answer1, btn_answer2, btn_answer3;
    TextView tv_score, tv_questions, tv_timer,tv_bottommessage;
    ProgressBar prog_timer;

    GameMath g = new GameMath();

    int secondsRemaining = 30;


    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long l) {
            secondsRemaining--;
            tv_timer.setText(Integer.toString(secondsRemaining) + "sec");
            prog_timer.setProgress(30 - secondsRemaining);

            if (g.getScore() == 40){
                Intent intent = new Intent(mat_activity.this, ActivitySuccess.class);
                startActivity(intent);
                finish();
                timer.cancel();
            }

        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottommessage.setText("Time is up" + g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));
            btn_start.setVisibility(View.VISIBLE);


            Intent intent = new Intent(mat_activity.this, FailedTask.class);
            startActivity(intent);
            finish();


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat);

        btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);


        tv_score = findViewById(R.id.tv_score);
        tv_questions = findViewById(R.id.tv_questions);
        tv_timer = findViewById(R.id.tv_timer);
        tv_bottommessage = findViewById(R.id.tv_bottommessage);

        prog_timer = findViewById(R.id.prog_timer);

        btn_answer0.setVisibility(View.INVISIBLE);
        btn_answer1.setVisibility(View.INVISIBLE);
        btn_answer2.setVisibility(View.INVISIBLE);
        btn_answer3.setVisibility(View.INVISIBLE);


        tv_timer.setText("Osec");
        tv_questions.setText("");
        tv_bottommessage.setText("Press Go");
        tv_score.setText("0pts");

        View.OnClickListener startButtonClickListener =  new View.OnClickListener() {
            @Override




            public void onClick(View view) {
                Button start_button = (Button) view;

                start_button.setVisibility(View.INVISIBLE);
                secondsRemaining = 30;
                g = new GameMath();

                btn_answer0.setVisibility(View.VISIBLE);
                btn_answer1.setVisibility(View.VISIBLE);
                btn_answer2.setVisibility(View.VISIBLE);
                btn_answer3.setVisibility(View.VISIBLE);
                nextTurn();
                timer.start();
            }
        };

        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button buttonClicked = (Button) view;

                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());

                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()));
                nextTurn();



            }
        };

        btn_start.setOnClickListener(startButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);

    }


    private void nextTurn(){
        //create a new question
        //set text or answer button
        //enable answer button
        //start the timer
        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestion().getAnswerArray();
        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        tv_questions.setText(g.getCurrentQuestion().getQuestionPhrase());

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        tv_bottommessage.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));


    }


}