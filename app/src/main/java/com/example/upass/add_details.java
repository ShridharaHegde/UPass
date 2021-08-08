package com.example.upass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class add_details extends AppCompatActivity {


    ImageButton btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        EditText et_email = findViewById(R.id.editTextTextPersonName);
        EditText et_pass = findViewById(R.id.editTextTextPassword2);
        EditText et_url = findViewById(R.id.editTextTextPersonName2);
        btn1 = findViewById(R.id.imageButton3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PasswordData passwordData;

                try {
                    passwordData = new PasswordData(-1, et_email.getText().toString(), et_pass.getText().toString(), et_url.getText().toString());
                    Toast.makeText(add_details.this,passwordData.toString(),Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){

                    passwordData = new PasswordData(-1,"error", "error", "error");
                }
                DataBaseHandler dataBaseHandler = new DataBaseHandler(add_details.this);

                boolean success = dataBaseHandler.addOne(passwordData);
                Toast.makeText(add_details.this, "Success = "+ success,Toast.LENGTH_SHORT).show();

            }
        });





    }
}