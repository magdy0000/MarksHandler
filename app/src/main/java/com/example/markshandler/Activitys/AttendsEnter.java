package com.example.markshandler.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.markshandler.R;

public class AttendsEnter extends AppCompatActivity {

    EditText code;
    Button attend;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attends_enter);
        
        code=findViewById(R.id.code_of_attend);
        attend=findViewById(R.id.attend);
        
        attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttendsEnter.this, "attended", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
