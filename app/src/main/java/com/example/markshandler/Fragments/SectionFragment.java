package com.example.markshandler.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.markshandler.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SectionFragment extends Fragment {

    LinearLayout assignment;
    LinearLayout attend;

    public SectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_lecture, container, false);

        assignment=view.findViewById(R.id.assi_layout);
        attend=view.findViewById(R.id.atte_layout);
        return view;
    }

}
