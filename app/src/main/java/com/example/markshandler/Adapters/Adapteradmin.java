package com.example.markshandler.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.markshandler.Models.DataId;
import com.example.markshandler.R;

import java.util.ArrayList;

public class Adapteradmin extends ArrayAdapter {



        ArrayList<DataId> mlist;

        public Adapteradmin(@NonNull Context context, int resource, @NonNull ArrayList objects) {
            super(context, resource, objects);

            mlist = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.item_of_listview_admin, parent,false);

            TextView textGrid = convertView.findViewById(R.id.text_admin);

           textGrid.setText(mlist.get(position).getId());





            return convertView;
        }


}
