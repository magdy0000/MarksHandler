package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.markshandler.Models.DataControl;
import com.example.markshandler.Models.DataId;
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

     String control = "false"  ;


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

        ref.child("OS Control").child(code.getText().toString().trim()).child("attendControl").addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 control = (String) dataSnapshot.getValue();
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
                if (dataSnapshot.child("OS Control").hasChild(code.getText().toString().trim())) {

                    setOnOffBtn();



                } else {

                    DataControl control = new DataControl();

                    control.setId(code.getText().toString().trim());
                    control.setAttendControl("false");

                    ref.child(nameSubject.getText().toString().trim()).child(code.getText().toString().trim()).setValue("");
                    ref.child("OS Control").child(code.getText().toString().trim()).setValue(control);

                    setOnOffBtn();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private  void  check3 (){
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("OS")) {


                    check2();


                } else {

                    ref.child("OS Control").setValue(null);
                      check2();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    public void StartAtendance(View view) {
        if (!code.getText().toString().trim().equals("")) {
            check3();
        }else {
            Toast.makeText(this, "please enter the code to start lecture", Toast.LENGTH_SHORT).show();
            
        }


    }
   private void setTextOfOnOffBtn (){
        if (control.equals("true")){
            onAndOff.setText("on");

        }else {

            onAndOff.setText("off");
        }


   }
    public void AttendControl(View view) {


        if (control.equals("true")){
            onAndOff.setText("off");
            control = "false" ;


            ref.child("OS Control").child(code.getText().toString().trim()).child("attendControl").setValue(control);


        }else {
            onAndOff.setText("On");
            control = "true" ;

            ref.child("OS Control").child(code.getText().toString().trim()).child("attendControl").setValue(control);

        }



    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(DoctorsHome.this, Admin.class));
    }

}
