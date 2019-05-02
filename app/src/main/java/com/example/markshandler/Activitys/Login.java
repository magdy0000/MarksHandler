package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.markshandler.Helper.StudentsData;
import com.example.markshandler.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    EditText idlogin;
    EditText passlogin;
    boolean finder=false;
    Button login;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    public  static  String userID , userName , semester ;


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


        char [] id1;
        id1=id.toCharArray();

       if(id1[0]=='1'){
           semester="first";
           for(int i =0 ;i < StudentsData.first.length;i++) {

               if(idlogin.getText().toString().equals(StudentsData.first[i])){
               userID= idlogin.getText().toString();
               userName=StudentsData.firstnames[i];
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
           for(int i =0 ;i <StudentsData.second.length;i++) {

               if (idlogin.getText().toString().equals(StudentsData.second[i])) {
                   userID = idlogin.getText().toString();
                   userName=StudentsData.secondnames[i];
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
           for(int i =0 ;i <StudentsData.third.length;i++) {

               if (idlogin.getText().toString().equals(StudentsData.third[i])) {
                   userID = idlogin.getText().toString();
                   userName=StudentsData.thirdnames[i];
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
           for(int i =0 ;i <StudentsData.fourth.length;i++) {

               if(idlogin.getText().toString().equals(StudentsData.fourth[i])){
                   userID= idlogin.getText().toString();
                   userName=StudentsData.fourthnames[i];
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
           for(int i =0 ;i <StudentsData.fifth.length;i++) {

               if(idlogin.getText().toString().equals(StudentsData.fifth[i])){
                   userID= idlogin.getText().toString();
                   userName=StudentsData.fifthnames[i];
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
           for(int i =0 ;i <StudentsData.sixth.length;i++) {

               if(idlogin.getText().toString().equals(StudentsData.sixth[i])){
                   userID= idlogin.getText().toString();
                   userName=StudentsData.sixthnames[i];
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
           for(int i =0 ;i <StudentsData.seventh.length;i++) {

               if(idlogin.getText().toString().equals(StudentsData.seventh[i])){
                   userID= idlogin.getText().toString();
                   userName=StudentsData.seventhnames[i];
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
           for(int i =0 ;i <StudentsData.eighth.length;i++) {

               if(idlogin.getText().toString().equals(StudentsData.eighth[i])){
                   userID= idlogin.getText().toString();
                   userName=StudentsData.eighthnames[i];
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
