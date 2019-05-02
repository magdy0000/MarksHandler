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
import com.example.markshandler.Models.ModelOfStudendAssignmentAnswer;
import com.example.markshandler.Models.ModelOfUploadAssignment;
import com.example.markshandler.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
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
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelOfUploadAssignment> list = new ArrayList<>();

    ModelOfStudendAssignmentAnswer answer =  new ModelOfStudendAssignmentAnswer();

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


             if (list.size() == 1) {

                 button.setText("finish");


             }


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



        Toast.makeText(this,counter+ "contert", Toast.LENGTH_SHORT).show();
         String right = String.valueOf(answerNr);
         Toast.makeText(this, right+"radio", Toast.LENGTH_SHORT).show();
         Toast.makeText(this, list.get(counter).getRightAnswer()+"", Toast.LENGTH_SHORT).show();



         if(list.get(counter).getRightAnswer().equals(right)){

              score++ ;




         }


    }



    public void nextAndFinish(View view) {


        if (rd1.isChecked() || rd2.isChecked() || rd3.isChecked() || rd4.isChecked()) {


            if(list.size()!=1) {


                if (counter < list.size() - 1) {

                    checkAnswers();
                    radioGroup.clearCheck();
                    counter++;
                    setData();

                } else {
                   checkAnswers();

                     answer.setId(Login.userID);
                     answer.setName(Login.userName);
                     answer.setScore(score);
                    ref.child("OS Assignment Answer").child(AssignmentOfStudent.assignmentName + "Answer").child("3").setValue(answer).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(), "Your answer is uploaded", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });


                    //here upload score
                }

                if (counter == list.size() - 1) {
                    button.setText("Finish");


                }
            }else {

                checkAnswers();
                answer.setId(Login.userID);
                answer.setName(Login.userName);
                answer.setScore(score);
                ref.child("OS Assignment Answer").child(AssignmentOfStudent.assignmentName + "Answer").child("3").setValue(answer).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(), "Your answer is uploaded", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }

        } else {
            Toast.makeText(this, "Choose Answer", Toast.LENGTH_SHORT).show();


        }
    }
}
