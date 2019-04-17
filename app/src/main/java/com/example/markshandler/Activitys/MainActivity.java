package com.example.markshandler.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.markshandler.Adapters.Adapteruser;
import com.example.markshandler.Models.modeluser;
import com.example.markshandler.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String [] y = {"OS" , "Logic Design"};
    String [] x = {"Dr.Mohamed hussen","Dr.Ahmed mohamed"};
    ListView listView ;
    ArrayList<modeluser> list = new ArrayList<>();

    Adapteruser adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view_user);

        list.add(new modeluser(y[0], x[0]));
        list.add(new modeluser(y[1], x[1]));

        adapter = new Adapteruser(this , R.layout.item_of_listview , list);

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
                    Intent go = new Intent(MainActivity.this, SubjectDetilsActivity.class);
                    startActivity(go);
                    finish();
                }
                //about us
                else if (position == 1) {
                    startActivity(new Intent(MainActivity.this, SubjectDetilsActivity.class));
                    finish();

                }
            }
        });



    }
}

