package com.learntodroid.simplealarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.learntodroid.simplealarmclock.activities.RingActivity;

public class ActivitySuccess extends AppCompatActivity {
    private ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        button = (ImageButton) findViewById(R.id.btn_more);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivitySuccess.this, RingActivity.class);
                startActivity(intent);
            }
        });


        button = (ImageButton) findViewById(R.id.btn_spotify);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.spotify.music");
                if(launchIntent != null){
                    startActivity(launchIntent);
                }else {
                    Toast.makeText(ActivitySuccess.this, "You do not have spotify installed!", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}