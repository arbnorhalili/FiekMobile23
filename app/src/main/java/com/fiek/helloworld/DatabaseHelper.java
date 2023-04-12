package com.fiek.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "FiekDB", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Users(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name text," +
                "Surname text, Email text, Password text)");

        sqLiteDatabase.execSQL("create table Notes(Id INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT NOT NULL, " +
                "Description TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("create table Notes(Id INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT NOT NULL, " +
                "Description TEXT NOT NULL)");
    }
}
