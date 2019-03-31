package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.markshandler.R;

public class Login extends AppCompatActivity {

    EditText username , password ;
    Button login  ;

   public  static    String userID , userName  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username_editText);
        password = findViewById(R.id.password_editText);
        login = findViewById(R.id.login_btn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().trim().equals("1")){
                     userID = "11";
                     userName = "Magdy";

                    startActivity(new Intent(Login.this, UserHome.class));
                    finish();



                }else
                {

                    startActivity(new Intent(Login.this, DoctorsHome.class));
                    finish();
                }

            }
        });




    }
}
