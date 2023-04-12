package com.fiek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    String username = "", name = "", surname = "";
    TextView tvWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvWelcome = findViewById(R.id.tvWelcome);

        if(getIntent().hasExtra("username") && getIntent().hasExtra("name") &&
            getIntent().hasExtra("surname"))
        {
            username = getIntent().getExtras().getString("username");
            name = getIntent().getExtras().getString("name");
            surname = getIntent().getExtras().getString("surname");
            tvWelcome.setText("Welcome "+name+" "+surname);
        }
    }
}