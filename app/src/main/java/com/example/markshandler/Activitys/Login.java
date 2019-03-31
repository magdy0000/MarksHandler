package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.markshandler.R;

public class Login extends AppCompatActivity {

    EditText idlogin;
    EditText passlogin;
    Button login;

   public  static    String userID , userName  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idlogin=findViewById(R.id.editText_id);
        passlogin=findViewById(R.id.editText_pass);
        login=findViewById(R.id.login);







    }
    public void login(View view){
        if (idlogin.getText().toString().equals("1")){

            Intent admin=new Intent(this,Admin.class);
            startActivity(admin);
        }

        else if(idlogin.getText().toString().equals("2")){

            Intent user=new Intent(this,MainActivity.class);
            startActivity(user);
        }

        else{

            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
