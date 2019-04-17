package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.markshandler.Adapters.AdapterDoneAssi;
import com.example.markshandler.Models.modelDoneAssi;
import com.example.markshandler.R;

import java.util.ArrayList;

public class StudentFinishAssi extends AppCompatActivity {

    String []y = {"Ebrahem Yousef" , "Magdy Mahmoud"};
    ListView listView ;
    ArrayList<modelDoneAssi> list = new ArrayList<>();

    AdapterDoneAssi adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_finish_assi);

        listView = findViewById(R.id.assi_done);

        list.add(new modelDoneAssi(y[0]));
        list.add(new modelDoneAssi(y[1]));


        adapter = new AdapterDoneAssi(StudentFinishAssi.this, R.layout.item_listview_doneassi , list);

        listView.setAdapter(adapter);
        listViewClic();
    }
    private void listViewClic() {


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent go = new Intent(StudentFinishAssi.this, StudentInfo.class);
                    startActivity(go);
                }

                else if (position == 1) {
                    startActivity(new Intent(StudentFinishAssi.this, StudentInfo.class));

                }
            }
        });

    }
}
