package com.example.markshandler.Activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.markshandler.Fragments.OldLecturesFragment;
import com.example.markshandler.Models.ModelOfAssignmentList;
import com.example.markshandler.Models.ModelOfCountAttend;
import com.example.markshandler.Models.ModelOfDataOfAssignmentOfAdmin;
import com.example.markshandler.Models.ModelOfUploadAssignment;
import com.example.markshandler.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class StartNewAssignmentForAdmin extends AppCompatActivity {

    EditText assignmentTittle , question  , firsrAnswer , secondAnswer  , thirdAnswer  , fourthAnswer , rightAnswer  ;
    ProgressBar progressBar ;
    LinearLayout parent ;

    ModelOfUploadAssignment upload  = new ModelOfUploadAssignment();

    int count = 0  ;
    DatabaseReference referenceData  = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_assignment);
        progressBar = findViewById(R.id.progress1);
        parent = findViewById(R.id.parent1);




        definition();





    }


    private void definition (){

        assignmentTittle = findViewById(R.id.edittext_assignmentTittle);
        question = findViewById(R.id.edittext_question);
        firsrAnswer = findViewById(R.id.firstAnswer);
        secondAnswer = findViewById(R.id.secondAnswer);
        thirdAnswer = findViewById(R.id.thirdAnswer)  ;
        fourthAnswer = findViewById(R.id.fourthAnswer);
        rightAnswer = findViewById(R.id.rightAnswer);


    }


    private void uploadAssignment(){


        upload.setQuestion(question.getText().toString().trim());
        upload.setFirst(firsrAnswer.getText().toString().trim());
        upload.setSecond(secondAnswer.getText().toString().trim());
        upload.setFourth(fourthAnswer.getText().toString().trim());
        upload.setThird(thirdAnswer.getText().toString().trim());
        upload.setRightAnswer(rightAnswer.getText().toString());

        referenceData.child(DoctorSubjects.subjectNameOfDoctor+" Assignment").child(assignmentTittle.getText().toString().trim()).child(count+"").setValue(upload)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                parent.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(StartNewAssignmentForAdmin.this, "Uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                parent.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(StartNewAssignmentForAdmin.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });





        ModelOfAssignmentList  data = new ModelOfAssignmentList();
        data.setTittle(assignmentTittle.getText().toString().trim());
        data.setCheck("false");


        referenceData.child(DoctorSubjects.subjectNameOfDoctor+" Assignment Tittle").child(assignmentTittle.getText().toString().trim()).setValue(data);




        count++ ;



    }

    private void checkIfFieldEmpty (){

        String tittle  = assignmentTittle.getText().toString().trim() ;
        String ques = question.getText().toString().trim() ;
        String first  = firsrAnswer.getText().toString().trim();
        String second = secondAnswer.getText().toString().trim();
        String third = thirdAnswer.getText().toString().trim();
        String forth = fourthAnswer.getText().toString().trim();
        String right = rightAnswer.getText().toString().trim();


        if (tittle.equals("")){
            assignmentTittle.setError("Required");

        }
        else if (ques.equals("")){
            question.setError("Required");

        }
       else if (first.equals("")){
            firsrAnswer.setError("Required");


        }else if (second.equals("")){

           secondAnswer.setError("Required");

        }else if(third.equals("")){

           thirdAnswer.setError("Required");
        }else if (forth.equals("")){
           fourthAnswer.setError("Required");

        }else if (right.equals("")){
           rightAnswer.setError("Required");

        }else if (!right.equals("1") && !right.equals("2")&&!right.equals("3")&&!right.equals("4") ){

           rightAnswer.setError("The Right Answer must be in between 1 to 4");

        }
        else {

            parent.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            uploadAssignment();

            question.setText("");
            firsrAnswer.setText("");
            secondAnswer.setText("");
            thirdAnswer.setText("");
            fourthAnswer.setText("");
            rightAnswer.setText("");
        }





    }

    @Override
    public void onBackPressed() {
        finish();
        Intent m = new Intent(this, Admin.class);
        startActivity(m);


    }

    public void upload(View view) {


        checkIfFieldEmpty();

    }
}
