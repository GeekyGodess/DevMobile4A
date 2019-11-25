package com.example.superapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ExpFragment extends Fragment {

    private LineGraphSeries<DataPoint> series3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exp, null);

//Fonction sin
        double x, y;
        x = 0;
        GraphView graph = view.findViewById(R.id.graph3);
        series3 = new LineGraphSeries<>();

        int numDataPoints = 60;

        for (int i = 0; i < numDataPoints; i++) {
            x = x + 0.1; // pour avoir une ligne continue
            y = Math.exp(x);
            series3.appendData(new DataPoint(x, y), true, 100);
        }
        graph.addSeries(series3);

        return view;
    }
}
