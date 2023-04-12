package com.fiek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    List<User> users = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        readUserFromDb();
    }

    private void readUserFromDb()
    {
        SQLiteDatabase objDb = (new DatabaseHelper(UsersActivity.this)).getReadableDatabase();
        Cursor cursor = objDb.query("Users",new String[]{"Id", "Name", "Surname", "Email"},"",
                new String[]{},"","","");
        //select Id, Name, Surname, Email from Users
        cursor.moveToFirst();

        while(cursor.isAfterLast()==false)
        {
            int _id = cursor.getInt(0);
            String _name = cursor.getString(1), _surname = cursor.getString(2), _email = cursor.getString(3);
            User objUser = new User(_id, _name, _surname, _email);
            users.add(objUser);
            Log.i("UserInfo", objUser.toString());
            cursor.moveToNext();
        }
        cursor.close();
        objDb.close();
    }
}