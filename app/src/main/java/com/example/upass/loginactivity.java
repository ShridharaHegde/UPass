package com.example.upass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginactivity extends AppCompatActivity {

    Button btn1, btn2;
    EditText master;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        btn2 = findViewById(R.id.createacc_btn);
        btn1 = findViewById(R.id.continue_btn);
        master = findViewById(R.id.editTextTextEmailAddress);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(master.getText().toString().equals("admin") ) {

                    Intent intent = new Intent(loginactivity.this, app_home.class);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(loginactivity.this, create_account.class);
                startActivity(intent);

            }
        });
    }
}