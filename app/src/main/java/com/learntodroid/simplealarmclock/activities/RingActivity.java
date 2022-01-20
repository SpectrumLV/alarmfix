package com.learntodroid.simplealarmclock.activities;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.learntodroid.simplealarmclock.R;
import com.learntodroid.simplealarmclock.activity_phys;
import com.learntodroid.simplealarmclock.activity_quiz;
import com.learntodroid.simplealarmclock.createalarm.TimePickerUtil;
import com.learntodroid.simplealarmclock.data.Alarm;
import com.learntodroid.simplealarmclock.mat_activity;
import com.learntodroid.simplealarmclock.service.AlarmService;

import java.util.Calendar;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RingActivity extends AppCompatActivity {
    @BindView(R.id.activity_ring_dismiss) Button dismiss;
    @BindView(R.id.activity_ring_snooze) Button snooze;
    @BindView(R.id.activity_ring_clock) ImageView clock;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);


        button = (Button) findViewById(R.id.math_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openActivity2();
            }
        });

        button = (Button) findViewById(R.id.quiz_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        button = (Button) findViewById(R.id.phys_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });



        ButterKnife.bind(this);

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentService = new Intent(getApplicationContext(), AlarmService.class);
                getApplicationContext().stopService(intentService);
                finish();
            }
        });

        snooze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.MINUTE, 10);

                Alarm alarm = new Alarm(
                        new Random().nextInt(Integer.MAX_VALUE),
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        "Snooze",
                        System.currentTimeMillis(),
                        true,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false
                );

                alarm.schedule(getApplicationContext());

                Intent intentService = new Intent(getApplicationContext(), AlarmService.class);
                getApplicationContext().stopService(intentService);
                finish();
            }
        });

        animateClock();
    }

    public void openActivity2() {
        Intent intent = new Intent(this, mat_activity.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, activity_quiz.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, activity_phys.class);
        startActivity(intent);
    }

    private void animateClock() {
        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(clock, "rotation", 0f, 20f, 0f, -20f, 0f);
        rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimation.setDuration(800);
        rotateAnimation.start();
    }
}
