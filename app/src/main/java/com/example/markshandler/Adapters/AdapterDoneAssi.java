package com.example.markshandler.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.markshandler.Models.ModelOfStudendAssignmentAnswer;
import com.example.markshandler.Models.modelDoneAssi;
import com.example.markshandler.R;

import java.util.ArrayList;

public class AdapterDoneAssi extends ArrayAdapter {



        ArrayList<ModelOfStudendAssignmentAnswer> mlist;

        public AdapterDoneAssi(@NonNull Context context, int resource, @NonNull ArrayList objects) {
            super(context, resource, objects);

            mlist = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.item_listview_doneassi, parent,false);

            TextView textName= convertView.findViewById(R.id.studentName);

            TextView textId = convertView.findViewById(R.id.studentId);

            TextView textScore = convertView.findViewById(R.id.studentScore);


           textId.setText(mlist.get(position).getId());
           textName.setText(mlist.get(position).getName());
           textScore.setText(mlist.get(position).getScore()+"");


            return convertView;
        }

}
