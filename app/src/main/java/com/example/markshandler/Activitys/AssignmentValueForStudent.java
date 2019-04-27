package com.example.markshandler.Activitys;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.markshandler.Models.ModelOfAssignmentList;
import com.example.markshandler.Models.ModelOfUploadAssignment;
import com.example.markshandler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AssignmentValueForStudent extends AppCompatActivity {
  RadioGroup radioGroup ;
  RadioButton rd1 , rd2 , rd3 , rd4  ;
  TextView textView  ;
  Button button ;
   int counter = 0 ;
   int score = 0 ;
    int answerNr;
  ArrayList<ModelOfUploadAssignment> list = new ArrayList<>();
  DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_value_for_student);
        definition();
        getData();


     radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(RadioGroup group, int checkedId) {

             RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
             answerNr = radioGroup.indexOfChild(rbSelected) + 1;


         }
     });

    }



    private void definition (){
        textView = findViewById(R.id.question);
        radioGroup = findViewById(R.id.radio_group);
        rd1 = findViewById(R.id.radio_button1);
        rd2 = findViewById(R.id.radio_button2);
        rd3 = findViewById(R.id.radio_button3);
        rd4 = findViewById(R.id.radio_button4);
        button = findViewById(R.id.btn);

    }



    private void getData(){
    ref.child("OS Assignment").child(AssignmentOfStudent.assignmentName).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                list.add(dataSnapshot1.getValue(ModelOfUploadAssignment.class));
                setData();

                if(list.size()==1){
                    button.setText("finish");
                }


            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });


    }

    private void setData (){

        textView.setText(list.get(counter).getQuestion());
        rd1.setText(list.get(counter).getFirst());
        rd2.setText(list.get(counter).getSecond());
        rd3.setText(list.get(counter).getThird());
        rd4.setText(list.get(counter).getFourth());


    }

    private void checkAnswers(){




        String right = String.valueOf(answerNr);

         if(list.get(counter).getRightAnswer().equals(right)){
              score++ ;


         }


    }



    public void nextAndFinish(View view) {


        if (rd1.isChecked() || rd2.isChecked() || rd3.isChecked() || rd4.isChecked()) {


            if (counter < list.size() - 1) {
                counter++;
                checkAnswers();
                setData();
                radioGroup.clearCheck();
            } else {

              //here upload score
            }

            if (counter == list.size() - 1) {
                button.setText("Finish");


            }

        } else {
            Toast.makeText(this, "Choose Answer", Toast.LENGTH_SHORT).show();


        }
    }
}
