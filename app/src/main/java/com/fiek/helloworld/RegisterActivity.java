package com.fiek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etPassword, etRepeatPassword, etName, etSurname;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeGuiElements();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database = (new DatabaseHelper(RegisterActivity.this)).getReadableDatabase();
                ContentValues cv = new ContentValues();
                cv.put(Users.Name, etName.getText().toString());
                cv.put("Surname", etSurname.getText().toString());
                cv.put("Email", etEmail.getText().toString());
                cv.put("Password", etPassword.getText().toString());

                long result = database.insert("Users", "", cv);
                //database.execSQL("insert into Users (Name, Surname, Email, Password) values ('','','','')");
                if(result>0)
                    Toast.makeText(RegisterActivity.this, "Perdoruesi u regjistrua me sukses.", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(RegisterActivity.this, "Regjistrimi deshtoi.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initializeGuiElements()
    {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRepeatPassword = findViewById(R.id.etRepeatPassword);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        btnRegister = findViewById(R.id.btnRegister);
    }

    static class Users
    {
        public static String Name = "Name";
    }
}