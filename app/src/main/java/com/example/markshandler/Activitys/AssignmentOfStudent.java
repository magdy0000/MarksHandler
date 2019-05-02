package com.example.markshandler.Activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.markshandler.Adapters.AdapterOfListOfAssignment;
import com.example.markshandler.Adapters.Adapteradmin;
import com.example.markshandler.Models.DataControl;
import com.example.markshandler.Models.ModelOfAssignmentList;
import com.example.markshandler.Models.ModelOfDataOfAssignmentOfAdmin;
import com.example.markshandler.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;

public class AssignmentOfStudent extends AppCompatActivity {

     public static String assignmentName  ;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

   ListView listView  ;
   ArrayList<ModelOfAssignmentList> list  = new ArrayList<>();

   AdapterOfListOfAssignment adapter ;
   int pos  ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        listView =findViewById(R.id.listOfAssignment);

        adapter = new AdapterOfListOfAssignment(this , R.layout.item_of_list_of_assignment ,list );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                
              assignmentName = list.get(position).getTittle();
              pos = position ;
              checkIfChildIsFound();
              



            }
        });



         getDataAssignmentList();





    }
    private void getDataAssignmentList(){


        ref.child("OS Assignment Tittle").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    list.add(dataSnapshot1.getValue(ModelOfAssignmentList.class));

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void checkIfChildIsFound(){

        if(list.get(pos).getCheck().equals("false")) {



            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("OS Assignment Answer").hasChild(assignmentName + "Answer")) {


                        checkForStudentThatAlread();


                    } else {


                            startActivity(new Intent(AssignmentOfStudent.this, AssignmentValueForStudent.class));

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }else {


                Toast.makeText(AssignmentOfStudent.this, "Assignment is not available now ", Toast.LENGTH_SHORT).show();

        }

    }

    private void checkForStudentThatAlread (){
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("OS Assignment Answer").child(assignmentName+"Answer").hasChild("3")) {


                    Toast.makeText(AssignmentOfStudent.this, "You are already Answered", Toast.LENGTH_SHORT).show();


                } else {

                        startActivity(new Intent(AssignmentOfStudent.this, AssignmentValueForStudent.class));



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






    }




}
