package com.example.markshandler.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.markshandler.Activitys.DoctorsHome;
import com.example.markshandler.Activitys.StudentFinishAssi;
import com.example.markshandler.Adapters.OldAssiAdapter;
import com.example.markshandler.Adapters.OldAssiAdapter;
import com.example.markshandler.Models.modelAdmin;
import com.example.markshandler.Models.modelOldAssi;
import com.example.markshandler.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentFragment extends Fragment {

    String []y = {"Array assignment" , "If statement assignment"};
    ListView listView ;
    ArrayList<modelOldAssi> list = new ArrayList<>();

    OldAssiAdapter adapter ;

    public AssignmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_assignment, container, false);
        listView = view.findViewById(R.id.old_ass_listview);

        list.add(new modelOldAssi(y[0]));
        list.add(new modelOldAssi(y[1]));


        adapter = new OldAssiAdapter(getContext() , R.layout.item_of_listview_oldassi , list);

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
                    Intent go = new Intent(getActivity(), StudentFinishAssi.class);
                    startActivity(go);
                }

                else if (position == 1) {
                    startActivity(new Intent(getActivity(), StudentFinishAssi.class));

                }
            }
        });

    }

}
