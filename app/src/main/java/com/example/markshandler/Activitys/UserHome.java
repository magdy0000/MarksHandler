package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.markshandler.Models.ModelOfStudentAttend;
import com.example.markshandler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserHome extends AppCompatActivity {

    EditText codeFormStudent ;
    
    boolean checks ;

    String control1 ;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    ModelOfStudentAttend n = new ModelOfStudentAttend();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attends_enter);


        codeFormStudent = findViewById(R.id.code_of_attend);




    }


     private void checkOne (){

         ref.addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 if (dataSnapshot.child(MainActivity.subjectName+" Attendance").child(codeFormStudent.getText().toString().trim()).child(Login.userID).hasChild("checkOne")) {

                     Toast.makeText(UserHome.this, "You are already attended", Toast.LENGTH_SHORT).show();



                 } else {


                     check1();

                 }
             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });


     }
    public void confirm(View view) {

        if(!codeFormStudent.getText().toString().equals("")) {


            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(MainActivity.subjectName + " Attendance").hasChild(codeFormStudent.getText().toString().trim())) {


                        checkOne();


                    } else {

                        Toast.makeText(UserHome.this, "wrong code", Toast.LENGTH_SHORT).show();


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }else {

             codeFormStudent.setError("Enter Lecture Code ");
        }
    }






    private void check1  () {





            ref.child(MainActivity.subjectName+ " Control").child(codeFormStudent.getText().toString().trim()).child("attendControl").addListenerForSingleValueEvent( new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    control1 = (String) dataSnapshot.getValue();



                    if (control1.equals("true")) {

                      ModelOfStudentAttend d = new ModelOfStudentAttend();

                      d.setIdStudent(Login.userID);
                      d.setUserName(Login.userName);
                      d.setCheckOne("false");



                        ref.child(MainActivity.subjectName+" Attendance").child(codeFormStudent.getText().toString().trim()).child(Login.userID).setValue(d);
                     count();


                    } else {

                        Toast.makeText(UserHome.this, "Attendance has been close ", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {


                }
            });

    }
    private void count2 (){


        ref.child(MainActivity.subjectName+" Count").child("count").child(Login.userID).child("count").addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String x  =  dataSnapshot.getValue().toString();




              int z = Integer.parseInt(x);

              z = z + 1 ;
                String y = String.valueOf(z);

                ModelOfStudentAttend d = new ModelOfStudentAttend();

                d.setUserName(Login.userName);
                d.setCount(y);

              ref.child(MainActivity.subjectName+" Count").child("count").child(Login.userID).setValue(d);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

    }
    private void count (){

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(MainActivity.subjectName+" Count").child("count").hasChild(Login.userID)) {



                   count2();




                } else {


                    ref.child(MainActivity.subjectName+" Count").child("count").child(Login.userID).child("count").setValue("1");
                    ref.child(MainActivity.subjectName+" Count").child("count").child(Login.userID).child("userName").setValue(Login.userName);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void onBackPressed() {




           finish();

       Intent m = new Intent(this,Login.class);
       startActivity(m);


    }

}
