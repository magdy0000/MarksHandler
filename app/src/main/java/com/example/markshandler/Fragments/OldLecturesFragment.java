package com.example.markshandler.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.markshandler.Activitys.StudentAttentList;
import com.example.markshandler.Adapters.Adapteradmin;
import com.example.markshandler.Models.DataId;
import com.example.markshandler.Models.ModelOfAttentListForDoctors;
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
public class OldLecturesFragment extends Fragment {


    ListView listView ;
    ArrayList<DataId> list = new ArrayList<>();
     DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    Adapteradmin adapter ;

    public static String idLectures ;

    public OldLecturesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_old_lectures, container, false);

       listView = view.findViewById(R.id.list_view_admin);





      adapter = new Adapteradmin(getContext() , R.layout.item_of_listview_admin , list);
      listView.setAdapter(adapter);

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              idLectures = list.get(position).getId() ;


              Intent intent = new Intent(getContext() , StudentAttentList.class);
              startActivity(intent);
              getActivity().finish();
          }
      });



        ref.child("OS Control").addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    list.add(dataSnapshot1.getValue(DataId.class));

                }
                adapter.notifyDataSetChanged();

            }









            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });










        return view;
    }

}
