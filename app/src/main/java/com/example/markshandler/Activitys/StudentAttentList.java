package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.markshandler.Adapters.AdaptarOfListViewStudentAttendance;
import com.example.markshandler.Fragments.OldLecturesFragment;
import com.example.markshandler.Models.DataId;
import com.example.markshandler.Models.ModelOfAttentListForDoctors;
import com.example.markshandler.Models.ModelOfCountAttend;
import com.example.markshandler.Models.ModelOfStudentAttend;
import com.example.markshandler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentAttentList extends AppCompatActivity {
      ListView listView ;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    ArrayList<ModelOfAttentListForDoctors> list = new ArrayList<>();
    ArrayList<ModelOfCountAttend> list2 = new ArrayList<>();


    AdaptarOfListViewStudentAttendance adaptar  ;


     public static  String username , userid , numOfAttend ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attent_list);



        listView = findViewById(R.id.list_of_student_attendance);
        adaptar = new AdaptarOfListViewStudentAttendance(this , R.layout.item_of_student_attend_list,list);
        listView.setAdapter(adaptar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                username = list.get(position).getUserName();
                userid = list.get(position).getIdStudent();
                numOfAttend = list2.get(position).getCount();

                Intent in = new Intent(getApplicationContext() , StudentInfo.class);
                startActivity(in);
                finish();



            }
        });




        ref.child("OS Count").child("count").addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){


                    list2.add(dataSnapshot1.getValue(ModelOfCountAttend.class));




                }
                adaptar.notifyDataSetChanged();






            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });




        ref.child("OS").child(OldLecturesFragment.idLectures).addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){


                        list.add(dataSnapshot1.getValue(ModelOfAttentListForDoctors.class));




                    }
                    adaptar.notifyDataSetChanged();






            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

    }

    @Override
    public void onBackPressed() {

        finish();
        Intent m = new Intent(this,Admin.class);
        startActivity(m);


    }

}
