package com.fiek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView lvUsers;
    UsersAdapter usersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        usersAdapter = new UsersAdapter(ListActivity.this);

        lvUsers = findViewById(R.id.lvUsers);
        lvUsers.setAdapter(usersAdapter);

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                readUsersFromDb();
//            }
//        };
//        Thread th = new Thread(runnable);
//        th.start();
        new LoadDataAsync().execute();

    }

    private void readUsersFromDb()
    {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SQLiteDatabase objDb = (new DatabaseHelper(ListActivity.this)).getReadableDatabase();
        Cursor c = objDb.query("Users",new String[]{"Id", "Name", "Surname", "Email"},
                "", new String[]{},"","","");
        if(c.getCount()>0)
        {
            c.moveToFirst();
            while (c.isAfterLast()==false)
            {
                usersAdapter.usersDataSet.add(new UserModel(c.getInt(0), c.getString(1),
                        c.getString(2), c.getString(3)));
                c.moveToNext();
            }
            c.close();
            objDb.close();
        }

    }

    public class LoadDataAsync extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            readUsersFromDb();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            usersAdapter.notifyDataSetChanged();
        }
    }
}