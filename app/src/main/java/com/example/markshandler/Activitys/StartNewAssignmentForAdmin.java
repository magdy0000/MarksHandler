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
import android.widget.TextView;
import android.widget.Toast;

import com.example.markshandler.Fragments.OldLecturesFragment;
import com.example.markshandler.Models.ModelOfCountAttend;
import com.example.markshandler.Models.ModelOfDataOfAssignmentOfAdmin;
import com.example.markshandler.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class StartNewAssignmentForAdmin extends AppCompatActivity {

    Button uploadPic,uploadAssi;
    Uri filePath ;
    ImageView imageView ;
    StorageReference reference ,  ref ;
    EditText assimnentDisc ;
  
    
    DatabaseReference referenceData  = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_assignment);

        uploadAssi=findViewById(R.id.upload_the_assi_btn);
        uploadPic=findViewById(R.id.upload_pic_new_assi_btn);
        imageView = findViewById(R.id.image);
        assimnentDisc = findViewById(R.id.edittext_new_assignment);


        reference = FirebaseStorage.getInstance().getReference();

        uploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              chooseImage();
            }
        });

        uploadAssi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               uploadImage();
            }
        });
    }


    public  void chooseImage (){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2 && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {


            filePath = data.getData();








            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }


    private void uploadImage() {
        
      
             if (filePath != null && !assimnentDisc.getText().toString().equals(null)) {
                 
                 final ProgressDialog progressDialog = new ProgressDialog(this);
                 progressDialog.setTitle("Uploading...");
                 progressDialog.show();

                 ref = reference.child("OS/" + "assignmentPhoto");

                 ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                     @Override
                     public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                         progressDialog.dismiss();


                         final StorageReference filePath = ref;

                         filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                             @Override
                             public void onSuccess(Uri uri) {

                                 String finalpath = uri.toString();


                                 ModelOfDataOfAssignmentOfAdmin model = new ModelOfDataOfAssignmentOfAdmin();

                                 model.setDesc(assimnentDisc.getText().toString());
                                 model.setPhoto(finalpath);
                                 model.setCheck("true");

                                 referenceData.child("OS Assignment").setValue(model);
                                 finish();
                                 Intent m = new Intent(StartNewAssignmentForAdmin.this, Admin.class);
                                 startActivity(m);
                                 Toast.makeText(StartNewAssignmentForAdmin.this, "Assignment is uploaded ", Toast.LENGTH_SHORT).show();
                                 

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
         
    

   

            
   

    @Override
    public void onBackPressed() {
        finish();
        Intent m = new Intent(this, Admin.class);
        startActivity(m);


    }
}
