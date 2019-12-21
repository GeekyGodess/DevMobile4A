package com.example.superapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private NumbersAPI numbersAPI;
    private  TextView affichage_resultat;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_home,null);
        System.out.println("BONJOUUUUR\n");




        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("http://numbersapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        numbersAPI = retrofit.create(NumbersAPI.class);
        getFacts();



        return view;
    }

    private void  getFacts(){
        affichage_resultat= (TextView)view.findViewById(R.id.result_view);
        Call<NumberFact> call = numbersAPI.getFacts();

        call.enqueue(new Callback<NumberFact>(){
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {

                if(!response.isSuccessful()){
                    System.out.println("ICI\n");
                    affichage_resultat.setText("Code: " + response.code() );
                    return;
                }
                System.out.println("LA\n");
                NumberFact numberFacts = response.body();

                //for(NumberFact nbf: numberFacts) {
                    System.out.println("HELLO\n");
                    String content = "";
                    content += "Nombre entré: " + response.body().getNumber() + "\n";
                    content += " Fait amusant: " + response.body().getText() + "\n";
                    System.out.println("BOUH\n");

                    affichage_resultat.setText(content);
                //}

            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                System.out.println("HERE WE GO\n");
                affichage_resultat.setText(t.getMessage());
                //affichage_resultat.setText("Espoir!");

            }


        });


    }
}




