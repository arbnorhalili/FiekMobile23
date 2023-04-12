package com.fiek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        LoginDb(username, password);
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

    private void LoginDb(String email, String password)
    {
        SQLiteDatabase objDb = (new DatabaseHelper(LoginRelativeActivity.this)).getReadableDatabase();
        Cursor cursor = objDb.query("Users",new String[]{"Email", "Password", "Name", "Surname"},
                "Email=?", new String[]{ email }, "","","");

        //select Email, Password, Name, Surname from Users where Email = email
        if(cursor.getCount()==0)
        {
            Toast.makeText(LoginRelativeActivity.this, "Kredencialet jane gabim",
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            cursor.moveToFirst();
            String dbEmail = cursor.getString(0);
            String dbPassword = cursor.getString(1);
            String dbName = cursor.getString(2);
            String dbSurname = cursor.getString(3);

            if(dbPassword.equals(password))
            {
                Intent intenti = new Intent(LoginRelativeActivity.this,WelcomeActivity.class);
                intenti.putExtra("username", email);
                intenti.putExtra("name", dbName);
                intenti.putExtra("surname", dbSurname);
                startActivity(intenti);
            }
            else
            {
                Toast.makeText(LoginRelativeActivity.this, "Kredencialet jane gabim",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}