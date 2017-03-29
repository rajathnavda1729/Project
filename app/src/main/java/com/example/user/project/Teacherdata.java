package com.example.user.project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class Teacherdata extends Fragment {


    public Teacherdata() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_teacherdata, container, false);
        Spinner s=(Spinner)v.findViewById(R.id.usns);
        String students[]={"1BM14CS077","1BM14CS078","1BM14CS079","1BM14CS080","1BM14CS081","1BM14CS082"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,students);
        s.setAdapter(arrayAdapter);


        return v;
    }

}
