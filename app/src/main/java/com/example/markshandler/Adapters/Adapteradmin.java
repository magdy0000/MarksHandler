package com.example.markshandler.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.markshandler.Models.modelAdmin;
import com.example.markshandler.R;

import java.util.ArrayList;

public class Adapteradmin extends ArrayAdapter {



        ArrayList<modelAdmin> mlist;

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
            ImageView imageGrid = convertView.findViewById(R.id.img_admin);


            textGrid.setText(mlist.get(position).textgrid);
            imageGrid.setImageResource(mlist.get(position).imagegrid);


            return convertView;
        }

}
