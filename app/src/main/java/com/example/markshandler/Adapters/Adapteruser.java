package com.example.markshandler.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.markshandler.Models.modeluser;
import com.example.markshandler.R;

import java.util.ArrayList;

public class Adapteruser extends ArrayAdapter {



        ArrayList<modeluser> mlist;

        public Adapteruser(@NonNull Context context, int resource, @NonNull ArrayList objects) {
            super(context, resource, objects);

            mlist = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.item_of_listview, parent,false);

            TextView subject = convertView.findViewById(R.id.name_of_sub);
            TextView doctor = convertView.findViewById(R.id.name_of_doc);


            subject.setText(mlist.get(position).subject_text);
            doctor.setText(mlist.get(position).doctor_text);


            return convertView;
        }

}
