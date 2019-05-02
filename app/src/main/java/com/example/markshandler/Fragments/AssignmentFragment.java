package com.example.markshandler.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.markshandler.Activitys.StudentFinishAssi;
import com.example.markshandler.Adapters.OldAssiAdapter;
import com.example.markshandler.Models.DataId;
import com.example.markshandler.Models.ModelOfAssignmentList;
import com.example.markshandler.Models.modelOldAssi;
import com.example.markshandler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentFragment extends Fragment {


    ListView listView ;
    ArrayList<ModelOfAssignmentList> list = new ArrayList<>();
     DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    OldAssiAdapter adapter ;

    public static String assignmentName  ;

    public AssignmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_assignment, container, false);
        listView = view.findViewById(R.id.old_ass_listview);


        dataOfAssignments();
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


                    assignmentName = list.get(position).getTittle();


                    startActivity(new Intent(getActivity(), StudentFinishAssi.class));
                    getActivity().finish();


            }
        });

    }

    private void dataOfAssignments(){


        ref.child("OS Assignment Tittle").addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    list.add(dataSnapshot1.getValue(ModelOfAssignmentList.class));

                }
                adapter.notifyDataSetChanged();

            }









            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

    }

}
