package com.example.upass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class app_home extends AppCompatActivity {

    Button b1,b2;
    ImageButton b3;
    ArrayAdapter dataArrayAdapter;
    ListView lv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);

        b1 = findViewById(R.id.acc_btn);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.imageButton);
        lv_list = findViewById(R.id.lv_list);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseHandler dataBaseHandler = new DataBaseHandler(app_home.this);
                List<PasswordData> all = dataBaseHandler.returnAll();

                dataArrayAdapter = new ArrayAdapter<PasswordData>(app_home.this, android.R.layout.simple_list_item_1,all);
                lv_list.setAdapter(dataArrayAdapter);
                Toast.makeText(app_home.this,all.toString(),Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(app_home.this, add_details.class);
                startActivity(intent);
            }
        });
    }
}