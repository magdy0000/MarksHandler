package com.example.markshandler.Activitys;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.markshandler.Models.DoctorAttend;
import com.example.markshandler.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserHome extends AppCompatActivity {

    EditText codeFormStudent ;
    
    boolean checks ;

    Boolean control1 ;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DoctorAttend n = new DoctorAttend();
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
                 if (dataSnapshot.child("OS").child(codeFormStudent.getText().toString().trim()).child(Login.userID).hasChild("checkOne")) {

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


            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("OS").hasChild(codeFormStudent.getText().toString().trim())) {


                        checkOne();


                    } else {

                        Toast.makeText(UserHome.this, "wrong code", Toast.LENGTH_SHORT).show();


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



    }






    private void check1  () {





            ref.child("OS").child(codeFormStudent.getText().toString().trim()).child("Attend Control").addListenerForSingleValueEvent( new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    control1 = (Boolean) dataSnapshot.getValue();

                    if (control1) {

                      DoctorAttend d = new DoctorAttend();

                      d.setUserName(Login.userName);
                      d.setCheckOne("false");



                        ref.child("OS").child(codeFormStudent.getText().toString().trim()).child(Login.userID).setValue(d);
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


        ref.child("OS").child("count").child(Login.userID).child("count").addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String x  =  dataSnapshot.getValue().toString();




              int z = Integer.parseInt(x);

              z = z + 1 ;
                String y = String.valueOf(z);

                DoctorAttend d = new DoctorAttend();

                d.setUserName(Login.userName);
                d.setCount(y);

              ref.child("OS").child("count").child(Login.userID).setValue(d);

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
                if (dataSnapshot.child("OS").child("count").hasChild(Login.userID)) {



                   count2();




                } else {


                    ref.child("OS").child("count").child(Login.userID).child("count").setValue("1");
                    ref.child("OS").child("count").child(Login.userID).child("userName").setValue(Login.userName);


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
