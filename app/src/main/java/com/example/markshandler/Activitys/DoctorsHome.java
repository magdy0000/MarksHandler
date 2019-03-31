package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.markshandler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoctorsHome extends AppCompatActivity {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
     TextView nameSubject ;

     EditText code ;



     Button get , onAndOff ;

     Boolean control = false  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_home);

        nameSubject = findViewById(R.id.name_subject);

        nameSubject.setText("OS");

        code = findViewById(R.id.code_editText);
        onAndOff = findViewById(R.id.on_of_btn);
        get = findViewById(R.id.get_btn);






    }

    private void setOnOffBtn(){

        ref.child("OS").child(code.getText().toString().trim()).child("Attend Control").addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 control = (Boolean) dataSnapshot.getValue();
                setTextOfOnOffBtn();
                onAndOff.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });


    }

    private void check2 (){



        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("OS").hasChild(code.getText().toString().trim())) {

                    setOnOffBtn();



                } else {


                    ref.child(nameSubject.getText().toString().trim()).child(code.getText().toString().trim()).setValue("");
                    ref.child("OS").child(code.getText().toString().trim()).child("Attend Control").setValue(false);

                    setOnOffBtn();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    public void StartAtendance(View view) {

        check2();


    }
   private void setTextOfOnOffBtn (){
        if (control){
            onAndOff.setText("on");

        }else {

            onAndOff.setText("off");
        }


   }
    public void AttendControl(View view) {


        if (control){
            onAndOff.setText("off");
            control = false ;
            ref.child("OS").child(code.getText().toString().trim()).child("Attend Control").setValue(control);


        }else {
            onAndOff.setText("On");
            control = true ;
            ref.child("OS").child(code.getText().toString().trim()).child("Attend Control").setValue(control);

        }



    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(DoctorsHome.this, Login.class));
    }

}
