package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.markshandler.Adapters.AdapterDoneAssi;
import com.example.markshandler.Fragments.AssignmentFragment;
import com.example.markshandler.Models.ModelOfAssignmentList;
import com.example.markshandler.Models.ModelOfStudendAssignmentAnswer;
import com.example.markshandler.Models.modelDoneAssi;
import com.example.markshandler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentFinishAssi extends AppCompatActivity {


    ListView listView ;
    ArrayList<ModelOfStudendAssignmentAnswer> list = new ArrayList<>();
     Button assignmentControl  ;
    AdapterDoneAssi adapter ;
    String check  ;
     DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_finish_assi);

        listView = findViewById(R.id.assi_done);
        assignmentControl = findViewById(R.id.btn_for_open_or_close);

         getButtonControlData();
         getStudentData();



        adapter = new AdapterDoneAssi(StudentFinishAssi.this, R.layout.item_listview_doneassi , list);
        listView.setAdapter(adapter);
        listViewClick();
    }
    private void listViewClick() {



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                }

                else if (position == 1) {


                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        finish();
        Intent m = new Intent(this,Admin.class);
        startActivity(m);


    }

    private void getStudentData (){

        ref.child("OS Assignment Answer").child(AssignmentFragment.assignmentName+"Answer").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    list.add(dataSnapshot1.getValue(ModelOfStudendAssignmentAnswer.class));


                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    private void getButtonControlData(){
        ref.child("OS Assignment Tittle").child(AssignmentFragment.assignmentName).child("check").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 check = dataSnapshot.getValue().toString() ;

                 if (check.equals("false")) {
                     assignmentControl.setText("Available Now");
                 }else {

                     assignmentControl.setText("Closed");
                 }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void assignmentControl(View view) {
        if (check.equals("false")) {
            ref.child("OS Assignment Tittle").child(AssignmentFragment.assignmentName).child("check").setValue("true");
        }else {

            ref.child("OS Assignment Tittle").child(AssignmentFragment.assignmentName).child("check").setValue("false");
        }

    }
}
