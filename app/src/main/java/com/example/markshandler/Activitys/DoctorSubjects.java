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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_subjects);
        switch (Login.idlogin.getText().toString()){

            case "1001":
                data=DoctorData.D1001;
                break;

            case "1002":
                data=DoctorData.D1002;
                break;

            case "1003":
                data=DoctorData.D1003;
                break;

            case "1004":
                data=DoctorData.D1004;
                break;

            case "1005":
                data=DoctorData.D1005;
                break;

            case "1006":
                data=DoctorData.D1006;
                break;

            case "1007":
                data=DoctorData.D1007;
                break;

            case "1008":
                data=DoctorData.D1008;
                break;

            case "1009":
                data=DoctorData.D1009;
                break;

            case "1010":
                data=DoctorData.D1010;
                break;

            case "1011":
                data=DoctorData.D1011;
                break;

            case "1012":
                data=DoctorData.D1012;
                break;

            case "1013":
                data=DoctorData.D1013;
                break;

            case "1014":
                data=DoctorData.D1014;
                break;

            case "1015":
                data=DoctorData.D1015;
                break;

            case "1016":
                data=DoctorData.D1016;
                break;

            case "1017":
                data=DoctorData.D1017;
                break;

            case "1018":
                data=DoctorData.D1018;
                break;

            case "1019":
                data=DoctorData.D1019;
                break;

            case "1020":
                data=DoctorData.D1020;
                break;

            case "1021":
                data=DoctorData.D1021;
                break;

            case "1022":
                data=DoctorData.D1022;
                break;

            case "1023":
                data=DoctorData.D1023;
                break;

            case "1024":
                data=DoctorData.D1024;
                break;

            case "1025":
                data=DoctorData.D1025;
                break;

            case "1026":
                data=DoctorData.D1026;
                break;

            case "1027":
                data=DoctorData.D1027;
                break;

            case "1028":
                data=DoctorData.D1028;
                break;

            case "1029":
                data=DoctorData.D1029;
                break;

            case "1030":
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
    }


}
