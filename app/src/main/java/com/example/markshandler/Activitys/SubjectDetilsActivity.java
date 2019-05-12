package com.example.markshandler.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.markshandler.Fragments.LectureFragment;
import com.example.markshandler.Fragments.SectionFragment;
import com.example.markshandler.R;

public class SubjectDetilsActivity extends AppCompatActivity {
    private Fragment fragment;
    private FragmentTransaction transaction;
    TextView lec;
    TextView sec;
    TextView subTittle  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detils);


       subTittle = findViewById(R.id.tittle);

        subTittle.setText(MainActivity.subjectName);

        fragment = new LectureFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.user_fragment, fragment, "Med_Data_Fragment");
        transaction.commitNow();
    }



    @Override
    public void onBackPressed() {


        Intent m = new Intent(this,MainActivity.class);
        startActivity(m);
        finish();


    }


}
