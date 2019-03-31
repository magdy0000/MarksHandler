package com.example.markshandler.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.markshandler.Adapters.Adapteradmin;
import com.example.markshandler.Models.modelAdmin;
import com.example.markshandler.R;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {
    int[] x = {R.drawable.background, R.drawable.background};
    String []y = {"Ebrahem yousef" , "Magdy mahmoud"};
    ListView listView ;
    ArrayList<modelAdmin> list = new ArrayList<>();

    Adapteradmin adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        listView = findViewById(R.id.list_view_admin);

        list.add(new modelAdmin(y[0] , x[0]));
        list.add(new modelAdmin(y[1], x[1]));


        adapter = new Adapteradmin(this , R.layout.item_of_listview_admin , list);

        listView.setAdapter(adapter);
        listViewClic();

    }
    private void listViewClic() {


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //news and events
                if (position == 0) {
                    Intent go = new Intent(Admin.this, DoctorsHome.class);
                    startActivity(go);
                    finish();
                }
                //about us
                else if (position == 1) {
                    startActivity(new Intent(Admin.this, DoctorsHome.class));
                    finish();

                }
            }
        });



    }
}

