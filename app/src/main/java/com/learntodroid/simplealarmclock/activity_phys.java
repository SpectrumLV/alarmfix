package com.learntodroid.simplealarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class activity_phys extends AppCompatActivity {

    Button button;
    ProgressBar prog_timer;
    TextView tv_timer;

    int secondsRemaining = 30;


    CountDownTimer timer = new CountDownTimer(3000,1000) {
        @Override
        public void onTick(long l) {
            secondsRemaining--;
            prog_timer.setProgress(30-secondsRemaining);
            tv_timer.setText(Integer.toString(secondsRemaining) + "sec");
        }


        @Override
        public void onFinish() {

            Intent intent = new Intent(activity_phys.this, FailedTask.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phys);


        prog_timer = findViewById(R.id.prog_timer);
        button = (Button) findViewById(R.id.btn_done);
        tv_timer = findViewById(R.id.tv_timer);
        secondsRemaining = 30;
        timer.start();

       // if(secondsRemaining == 15) {
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity_phys.this, ActivitySuccess.class);
                    startActivity(intent);

                }
            });

       // }


    }
}