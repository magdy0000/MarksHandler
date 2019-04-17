package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.markshandler.R;

public class StartNewAssignment extends AppCompatActivity {

    Button uploadPic,uploadAssi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_assignment);

        uploadAssi=findViewById(R.id.upload_the_assi_btn);
        uploadPic=findViewById(R.id.upload_pic_new_assi_btn);

        uploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 2);
            }
        });

        uploadAssi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartNewAssignment.this, "Done .. !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
