package com.learntodroid.simplealarmclock.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.learntodroid.simplealarmclock.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView time, time2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.time);
        time2 = findViewById(R.id.time2);


        Timer timer = new Timer();



        timer.schedule( new TimerTask() {
            public void run() {
                Calendar currentTime = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                String dateTime = simpleDateFormat.format(currentTime.getTime());
                String[] splitted = dateTime.split(":");
                time.setText(splitted[0]);
                time2.setText(splitted[1]);
            }
        }, 0, 60*1000);

//

    }

}
