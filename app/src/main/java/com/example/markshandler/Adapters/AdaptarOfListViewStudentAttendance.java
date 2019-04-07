package com.example.markshandler.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.markshandler.Activitys.StudentAttentList;
import com.example.markshandler.Fragments.OldLecturesFragment;
import com.example.markshandler.Models.DataId;
import com.example.markshandler.Models.ModelOfAttentListForDoctors;
import com.example.markshandler.Models.ModelOfStudentAttend;
import com.example.markshandler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdaptarOfListViewStudentAttendance  extends ArrayAdapter {



    ArrayList<ModelOfAttentListForDoctors> mlist;

    public AdaptarOfListViewStudentAttendance(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);


        mlist = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(R.layout.item_of_student_attend_list, parent,false);

        TextView username = convertView.findViewById(R.id.text_Student_name);
        TextView userId  = convertView.findViewById(R.id.text_Student_id);
        final Button button = convertView.findViewById(R.id.delete_btn);




        userId.setText(mlist.get(position).getIdStudent());
        username.setText(mlist.get(position).getUserName());



        return convertView;
    }

    private void v(int postion){



    }
}
