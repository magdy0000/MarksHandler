package com.example.markshandler.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.markshandler.Models.ModelOfAssignmentList;
import com.example.markshandler.Models.modelOldAssi;
import com.example.markshandler.R;

import java.util.ArrayList;

public class OldAssiAdapter extends ArrayAdapter {

        ArrayList<ModelOfAssignmentList> mlist;

        public OldAssiAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
            super(context, resource, objects);

            mlist = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.item_of_listview_oldassi, parent,false);

            TextView textGrid = convertView.findViewById(R.id.old_ass);


            textGrid.setText(mlist.get(position).getTittle());


            return convertView;
        }

}
