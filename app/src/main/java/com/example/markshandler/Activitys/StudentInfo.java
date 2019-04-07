package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.markshandler.Fragments.OldLecturesFragment;
import com.example.markshandler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentInfo extends AppCompatActivity {
    TextView studentName  ,  studentId , attendCount  ;
    Button delete ;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        studentId = findViewById(R.id.user_Id);
        studentName = findViewById(R.id.student_name_ofStudentInfo);
        attendCount = findViewById(R.id.number_attendance);
        delete = findViewById(R.id.delete_btn);

        studentName.setText(StudentAttentList.username);
        studentId.setText(StudentAttentList.userid);
        attendCount.setText(StudentAttentList.numOfAttend);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ref.child("OS Count").child("count").child(StudentAttentList.userid).child("count").setValue("0");
                ref.child("OS").child(OldLecturesFragment.idLectures).child(StudentAttentList.userid).setValue(null);


                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("OS").hasChild(OldLecturesFragment.idLectures)) {








                        } else {

                            ref.child("OS").child(OldLecturesFragment.idLectures).setValue("");


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
               finish();
                Intent m = new Intent(getApplicationContext(),StudentAttentList.class);
                startActivity(m);

            }
        });


    }

    @Override
    public void onBackPressed() {

        finish();
        Intent m = new Intent(this,StudentAttentList.class);
        startActivity(m);


    }
}
