package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.markshandler.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    EditText idlogin;
    EditText passlogin;
    boolean finder=false;
    Button login;


    String [] first={"101","102","103","104","105","106","107","108","109","110"};
    String [] second={"201","202","203","204","205","206","207","208","209","210"};
    String [] third={"301","302","303","304","305","306","307","308","309","310"};
    String [] fourth={"401","402","403","404","405","406","407","408","409","410"};
    String [] fifth={"501","502","503","504","505","506","507","508","509","510"};
    String [] sixth={"601","602","603","604","605","606","607","608","609","610"};
    String [] seventh={"701","702","703","704","705","706","707","708","709","710"};
    String [] eighth={"801","802","803","804","805","806","807","808","809","810"};

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    public  static  String userID , userName , semester ,findId ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idlogin=findViewById(R.id.editText_id);
        passlogin=findViewById(R.id.editText_pass);
        login=findViewById(R.id.login);






    }
    public void login(View view){
        String id= idlogin.getText().toString();

        if(idlogin.getText().toString().equals("Amr")) {

            Intent admin = new Intent(this, Admin.class);
            startActivity(admin);
        }

        else if(idlogin.getText().toString().equals("Ahmed")) {
            Intent user = new Intent(this, MainActivity.class);
            startActivity(user);
            userID = "3";
            userName = "Ahmed";
        }

        char [] id1;
        id1=id.toCharArray();

       if(id1[0]=='1'){
           semester="first";
           for(int i =0 ;i <first.length;i++) {

               if(idlogin.getText().toString().equals(first[i])){
               findId= idlogin.getText().toString();
               finder=true;

               Intent user = new Intent(this, MainActivity.class);
               startActivity(user);
               }
           }
           if(finder==false)
               idlogin.setError("Please make sure that a correct id");
       }

       else if(id1[0]=='2'){
           semester="second";
           for(int i =0 ;i <second.length;i++) {

               if (idlogin.getText().toString().equals(second[i])) {
                   findId = idlogin.getText().toString();
                   finder=true;
                   Intent user = new Intent(this, MainActivity.class);
                   startActivity(user);
               }
           }
               if(finder==false)
                   idlogin.setError("Please make sure that a correct id");
       }

     else if(id1[0]=='3'){
           semester="third";
           for(int i =0 ;i <third.length;i++) {

               if (idlogin.getText().toString().equals(third[i])) {
                   findId = idlogin.getText().toString();
                   finder=true;
                   Intent user = new Intent(this, MainActivity.class);
                   startActivity(user);
               }
           }
               if(finder==false)
                   idlogin.setError("Please make sure that a correct id");
       }

     else if(id1[0]=='4'){
           semester="fourth";
           for(int i =0 ;i <fourth.length;i++) {

               if(idlogin.getText().toString().equals(fourth[i])){
                   findId= idlogin.getText().toString();
                   finder=true;
                   Intent user = new Intent(this, MainActivity.class);
                   startActivity(user);
               }
           }
           if(finder==false)
               idlogin.setError("Please make sure that a correct id");
       }

     else if(id1[0]=='5'){
           semester="fifth";
           for(int i =0 ;i <fifth.length;i++) {

               if(idlogin.getText().toString().equals(fifth[i])){
                   findId= idlogin.getText().toString();
                   finder=true;
                   Intent user = new Intent(this, MainActivity.class);
                   startActivity(user);
               }
           }
           if(finder==false)
               idlogin.setError("Please make sure that a correct id");
       }

     else if(id1[0]=='6'){
           semester="sixth";
           for(int i =0 ;i <sixth.length;i++) {

               if(idlogin.getText().toString().equals(sixth[i])){
                   findId= idlogin.getText().toString();
                   finder=true;
                   Intent user = new Intent(this, MainActivity.class);
                   startActivity(user);
               }
           }
           if(finder==false)
               idlogin.setError("Please make sure that a correct id");
       }

     else if(id1[0]=='7'){
           semester="seventh";
           for(int i =0 ;i <seventh.length;i++) {

               if(idlogin.getText().toString().equals(seventh[i])){
                   findId= idlogin.getText().toString();
                   finder=true;
                   Intent user = new Intent(this, MainActivity.class);
                   startActivity(user);
               }
           }
           if(finder==false)
               idlogin.setError("Please make sure that a correct id");
       }

     else if(id1[0]=='8'){
           semester="eighth";
           for(int i =0 ;i <eighth.length;i++) {

               if(idlogin.getText().toString().equals(eighth[i])){
                   findId= idlogin.getText().toString();
                   finder=true;
                   Intent user = new Intent(this, MainActivity.class);
                   startActivity(user);
               }
           }
           if(finder==false)
               idlogin.setError("Please make sure that a correct id");
       }

     else
         {
           idlogin.setError("Please make sure that a correct id");
       }

    }
}
