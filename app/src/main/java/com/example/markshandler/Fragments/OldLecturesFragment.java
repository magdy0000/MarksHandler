package com.example.markshandler.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.markshandler.Activitys.Admin;
import com.example.markshandler.Activitys.DoctorsHome;
import com.example.markshandler.Adapters.Adapteradmin;
import com.example.markshandler.Models.modelAdmin;
import com.example.markshandler.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OldLecturesFragment extends Fragment {

    String []y = {"Array lec" , "If statement lec"};
    ListView listView ;
    ArrayList<modelAdmin> list = new ArrayList<>();

    Adapteradmin adapter ;

    public OldLecturesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_old_lectures, container, false);

       listView = view.findViewById(R.id.list_view_admin);

        list.add(new modelAdmin(y[0]));
        list.add(new modelAdmin(y[1]));


        adapter = new Adapteradmin(getActivity() , R.layout.item_of_listview_admin , list);

        listView.setAdapter(adapter);
        listViewClic();

        return view;
    }
    private void listViewClic() {


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent go = new Intent(getActivity(), DoctorsHome.class);
                    startActivity(go);
                }

                else if (position == 1) {
                    startActivity(new Intent(getActivity(), DoctorsHome.class));

                }
            }
        });

    }

}
