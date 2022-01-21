package com.learntodroid.simplealarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class mat_activity extends AppCompatActivity {

    Button btn_start, btn_answer0, btn_answer1, btn_answer2, btn_answer3;
    TextView tv_score, tv_questions, tv_timer, tv_bottommessage;
    ProgressBar prog_timer;

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
        tv_bottommessage = findViewById(R.id.tv_bottommessage);
        tv_questions = findViewById(R.id.tv_questions);
        tv_timer = findViewById(R.id.tv_timer);

        prog_timer = findViewById(R.id.prog_timer);

        tv_timer.setText("0sec");
        tv_questions.setText("");
        tv_bottommessage.setText("Press go");
        tv_score.setText("0pts");
        prog_timer.setProgress(0);


        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        btn_start.setOnClickListener(startButtonClickListener);
    }
}