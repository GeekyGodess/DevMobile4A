package com.example.superapp;

import android.graphics.Color;
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

public class SinCosFragment extends Fragment {

    private LineGraphSeries<DataPoint> series4;
    private LineGraphSeries<DataPoint> series5;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sincos, null);

//Fonction sin
        double x, y;
        x = 0;
        GraphView graph = view.findViewById(R.id.graph4);
        series4 = new LineGraphSeries<>();
        series5 = new LineGraphSeries<>();

        int numDataPoints = 500;

        for (int i = 0; i < numDataPoints; i++) {
            x = x + 0.1; // pour avoir une ligne continue
            y = Math.cos(x);
            double y2 = Math.sin(x);
            series4.appendData(new DataPoint(x, y), true, 60);
            series5.appendData(new DataPoint(x, y2), true, 60);
        }
        series4.setColor(Color.RED);
        series5.setColor(Color.BLUE);
        graph.addSeries(series4);
        graph.addSeries(series5);

        return view;
    }

}
