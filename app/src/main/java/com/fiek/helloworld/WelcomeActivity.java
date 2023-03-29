package com.fiek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    String username = "";
    TextView tvWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvWelcome = findViewById(R.id.tvWelcome);

        if(getIntent().hasExtra("username"))
        {
            username = getIntent().getExtras().getString("username");
            tvWelcome.setText("Welcome "+username);
        }
    }
}