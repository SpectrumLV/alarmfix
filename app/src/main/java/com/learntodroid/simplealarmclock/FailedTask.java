package com.learntodroid.simplealarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learntodroid.simplealarmclock.activities.RingActivity;

public class FailedTask extends AppCompatActivity{
    private MediaPlayer mediaPlayer;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed_task);

        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
        mediaPlayer.setLooping(true);

        mediaPlayer.start();

        button = (Button) findViewById(R.id.btn_tryagain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FailedTask.this, RingActivity.class);
                startActivity(intent);
                mediaPlayer.stop();
            }
        });
    }
}