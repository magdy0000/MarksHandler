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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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

public class AssignmentOfStudent extends AppCompatActivity {

    Button upload , choosepdf;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    String text , image ;
    StorageReference reference ,  ref2 ;
    TextView textViewOfDesc  ;
    ImageView photoOfAssignment ;
    Uri filePath ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        upload = findViewById(R.id.upload_pic);
        textViewOfDesc =findViewById(R.id.text_of_assignment_desc);
        photoOfAssignment =findViewById(R.id.photo_of_assignment);
        choosepdf = findViewById(R.id.choosePdf);

        choosepdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosepdf();
            }
        });
        getDataOfAssignmentFromFireBase();


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPdf();
            }
        });

    }


    private void getDataOfAssignmentFromFireBase (){
        ref.child("OS Assignment").child("desc").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 text = dataSnapshot.getValue().toString();

                 textViewOfDesc.setText(text);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ref.child("OS Assignment").child("photo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                image = dataSnapshot.getValue().toString();
                Toast.makeText(AssignmentOfStudent.this, image+"", Toast.LENGTH_SHORT).show();
                Glide.with(AssignmentOfStudent.this).load(image).into(photoOfAssignment);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void choosepdf(){

        Intent in = new Intent();
        in.setAction(Intent.ACTION_GET_CONTENT);
        in.setType("application/pdf");
        startActivityForResult(in,1);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null )
        {


            filePath = data.getData();

        }

    }

    private void uploadPdf() {


        if (filePath != null ) {

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            ref2 = reference.child("OS Assignment Answer" + "userId");

            ref2.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();


                    final StorageReference filePath = ref2;

                    filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            String finalpath = uri.toString();



                            ref.child("OS Answer Assignment Students ").setValue(finalpath);
                            finish();
                            Intent m = new Intent(AssignmentOfStudent.this, Admin.class);
                            startActivity(m);



                        }
                    });


                }
            })
                    //-------------------------------------------=---------==-=--==========================================


                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });

        }
    }



}
