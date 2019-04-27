package com.example.markshandler.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.markshandler.Fragments.AssignmentFragment;
import com.example.markshandler.Fragments.OldLecturesFragment;
import com.example.markshandler.Fragments.StartFragment;
import com.example.markshandler.R;

public class Admin extends AppCompatActivity {


    Fragment fragment;
    private FragmentTransaction transaction;
    Button ass , att ,lec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        ass=findViewById(R.id.assBtnFrag);
        att=findViewById(R.id.attBtnFrag);
        lec=findViewById(R.id.lecBtnFrag);

        fragment = new StartFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.doctorFra, fragment, "Med_Data_Fragment");
        transaction.commitNow();

        ass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new AssignmentFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.doctorFra, fragment, "Med_Data_Fragment");
                transaction.commitNow();
            }
        });


        lec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new OldLecturesFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.doctorFra, fragment, "Med_Data_Fragment");
                transaction.commitNow();
            }
        });

        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new StartFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.doctorFra, fragment, "Med_Data_Fragment");
                transaction.commitNow();
            }
        });




    }
}

