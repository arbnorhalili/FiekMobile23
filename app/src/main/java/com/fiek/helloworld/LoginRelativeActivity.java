package com.fiek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginRelativeActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin, btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnReset = findViewById(R.id.btnReset);

        btnLogin.setOnClickListener(this);
        btnReset.setOnClickListener(this);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkCredentials(etUsername.getText().toString(), etPassword.getText().toString());
//            }
//        });
    }

    private void checkCredentials(String username, String password)
    {
        if(username.equals("admin") && password.equals("admin"))
        {
            Intent intenti = new Intent(LoginRelativeActivity.this,WelcomeActivity.class);
            intenti.putExtra("username", etUsername.getText().toString());
            startActivity(intenti);
        }
        else
        {
            Toast.makeText(LoginRelativeActivity.this, "Kredencialet jane gabim",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnLogin:
                checkCredentials(etUsername.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.btnReset:
                etUsername.setText("");
                etPassword.setText("");
                break;
        }
    }
}