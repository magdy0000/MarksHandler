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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detils);
        lec=findViewById(R.id.Lec_color);
        sec=findViewById(R.id.Sec_color);

        fragment = new SectionFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.user_fragment, fragment, "Med_Data_Fragment");
        transaction.commitNow();
    }

    public void Section(View view) {
        fragment = new SectionFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.user_fragment, fragment, "Med_Data_Fragment");
        transaction.commitNow();

        sec.setBackgroundResource(R.color.LightOrange);
        lec.setBackgroundResource(R.color.whit);



    }

    public void Lecture(View view) {
        fragment = new LectureFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.user_fragment, fragment, "Med_Data_Fragment");
        transaction.commitNow();

        lec.setBackgroundResource(R.color.LightOrange);
        sec.setBackgroundResource(R.color.whit);


    }
    @Override
    public void onBackPressed() {


        Intent m = new Intent(this,MainActivity.class);
        startActivity(m);
        finish();


    }


}
