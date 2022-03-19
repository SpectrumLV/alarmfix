package com.learntodroid.simplealarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learntodroid.simplealarmclock.activities.RingActivity;

public class FailedTask extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed_task);

        button = (Button) findViewById(R.id.btn_tryagain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FailedTask.this, RingActivity.class);
                startActivity(intent);
            }
        });
    }
}