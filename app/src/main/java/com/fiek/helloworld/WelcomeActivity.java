package com.fiek.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itemRegister:
                Intent intenti = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intenti);
                break;
            case R.id.itemListUsers:
                intenti = new Intent(WelcomeActivity.this, ListActivity.class);
                startActivity(intenti);
        }
        return true;
    }
}