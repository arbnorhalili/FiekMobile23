package com.fiek.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
    EditText etTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keypad_layout);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), btn1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
//
//        btnSend = (Button)findViewById(R.id.btnSend);
//        etTo = findViewById(R.id.etTo);
//
//        //btnSend.setText("Klikuar ne UI");
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "To: "+etTo.getText().toString(), Toast.LENGTH_LONG).show();
//                Log.i("CustomLogInfo","Eshte klikuar butoni SEND");
//            }
//        });
    }

}