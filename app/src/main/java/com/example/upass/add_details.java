package com.example.upass;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class add_details extends AppCompatActivity {


    ImageButton btn1;
    Button btn2;
    Switch sw1;
    int max = 125;
    int min = 33;
    String fill = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        EditText et_email = findViewById(R.id.editTextTextPersonName);
        EditText et_pass = findViewById(R.id.editTextTextPassword2);
        EditText et_url = findViewById(R.id.editTextTextPersonName2);
        btn1 = findViewById(R.id.imageButton3);
        btn2 = findViewById(R.id.button3);
        sw1 = findViewById(R.id.switch1);


        //Generates password when clicked on Generate button
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=0; i<8; i++){
                    Random random = new Random();
                    int rn = random.nextInt(max - min) + min;
                    int rand = (int)rn;
                    char ch =  (char) rand;
                    fill = fill + ch;

                }

                et_pass.setText(fill, TextView.BufferType.EDITABLE);
                fill = "";
            }
        });

        //Adds data to database
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

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    et_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    et_pass.setTextColor(Color.WHITE);

                } else {

                    et_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    et_pass.setTextColor(Color.WHITE);

                }
            }
        });

    }
}