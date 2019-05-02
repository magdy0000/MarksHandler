package com.example.markshandler.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.markshandler.Adapters.AdapterDoctorSubjects;
import com.example.markshandler.Adapters.Adapteruser;
import com.example.markshandler.Helper.DoctorData;
import com.example.markshandler.Models.DoctorSubjectsModel;
import com.example.markshandler.Models.modeluser;
import com.example.markshandler.R;

import java.util.ArrayList;

public class DoctorSubjects extends AppCompatActivity {

    ListView listView;
    ArrayList<DoctorSubjectsModel> list = new ArrayList<>();
    AdapterDoctorSubjects adapter ;
    String [] data;
    public  static  String subjectNameOfDoctor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_subjects);
        switch (Login.idlogin.getText().toString()){

            case "9001":
                data=DoctorData.D1001;
                break;

            case "9002":
                data=DoctorData.D1002;
                break;

            case "9003":
                data=DoctorData.D1003;
                break;

            case "9004":
                data=DoctorData.D1004;
                break;

            case "9005":
                data=DoctorData.D1005;
                break;

            case "9006":
                data=DoctorData.D1006;
                break;

            case "9007":
                data=DoctorData.D1007;
                break;

            case "9008":
                data=DoctorData.D1008;
                break;

            case "9009":
                data=DoctorData.D1009;
                break;

            case "9010":
                data=DoctorData.D1010;
                break;

            case "9011":
                data=DoctorData.D1011;
                break;

            case "9012":
                data=DoctorData.D1012;
                break;

            case "9013":
                data=DoctorData.D1013;
                break;

            case "9014":
                data=DoctorData.D1014;
                break;

            case "9015":
                data=DoctorData.D1015;
                break;

            case "9016":
                data=DoctorData.D1016;
                break;

            case "9017":
                data=DoctorData.D1017;
                break;

            case "9018":
                data=DoctorData.D1018;
                break;

            case "9019":
                data=DoctorData.D1019;
                break;

            case "9020":
                data=DoctorData.D1020;
                break;

            case "9021":
                data=DoctorData.D1021;
                break;

            case "9022":
                data=DoctorData.D1022;
                break;

            case "9023":
                data=DoctorData.D1023;
                break;

            case "9024":
                data=DoctorData.D1024;
                break;

            case "9025":
                data=DoctorData.D1025;
                break;

            case "9026":
                data=DoctorData.D1026;
                break;

            case "9027":
                data=DoctorData.D1027;
                break;

            case "9028":
                data=DoctorData.D1028;
                break;

            case "9029":
                data=DoctorData.D1029;
                break;

            case "9030":
                data=DoctorData.D1030;
                break;

        }
        ListView();
    }


    public void ListView(){


        listView = findViewById(R.id.ListViewDoctorSubjects);
        for(int i = 0; i < data.length; i++){

            list.add(new DoctorSubjectsModel(data[i]));
        }

        adapter = new AdapterDoctorSubjects(this , R.layout.item_of_listview_doctor_subjects , list);

        listView.setAdapter(adapter);
        listViewClick();
    }

    private void listViewClick() {


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //news and events
                  subjectNameOfDoctor =  list.get(position).subject_text;
                Intent go = new Intent(DoctorSubjects.this, Admin.class);
                startActivity(go);
                finish();


                //about us

            }
        });



    }


}
