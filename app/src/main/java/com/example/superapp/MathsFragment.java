package com.example.superapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MathsFragment extends Fragment {

    //private LineGraphSeries<DataPoint> series1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_maths,null);

        //Fonction sin

        Button btn_sin = (Button)view.findViewById(R.id.btn_sin);

        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new SinFragment());
                fr.commit();
            }
        });

        //Fonction cos

        Button btn_cos = (Button)view.findViewById(R.id.btn_cos);

        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new CosFragment());
                fr.commit();
            }
        });


        //Fonction exponentielle

        Button btn_exp = (Button)view.findViewById(R.id.btn_exp);

        btn_exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new ExpFragment());
                fr.commit();
            }
        });


        // Superposition de sin et cos

        Button btn_sincos = (Button)view.findViewById(R.id.btn_sin_cos);

        btn_sincos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new SinCosFragment());
                fr.commit();
            }
        });


        return view;
    }
}
