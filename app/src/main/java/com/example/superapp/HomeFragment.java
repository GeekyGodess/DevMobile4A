package com.example.superapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private NumbersAPI numbersAPI;
    private  TextView affichage_resultat;
    private View view;
    private EditText input;
    private int number;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_home,null);





        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("http://numbersapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        numbersAPI = retrofit.create(NumbersAPI.class);
        button = (Button)view.findViewById(R.id.validation);
        input = (EditText)view.findViewById(R.id.input_number);

        button.setOnClickListener(this);
        getFacts();


        return view;



    }

    private void  getFacts(){
        affichage_resultat= (TextView)view.findViewById(R.id.result_view);

        Call<NumberFact> call = numbersAPI.getFacts(number);

        call.enqueue(new Callback<NumberFact>(){
            @Override
            public void onResponse(Call<NumberFact> call, Response<NumberFact> response) {

                if(!response.isSuccessful()){
                    affichage_resultat.setText("Code: " + response.code() );
                    return;
                }

                NumberFact numberFacts = response.body();

                String content = "";
                content += "Nombre entré: " + response.body().getNumber() + "\n";
                content += " Fait amusant: " + response.body().getText() + "\n";

                affichage_resultat.setText(content);

            }

            @Override
            public void onFailure(Call<NumberFact> call, Throwable t) {
                affichage_resultat.setText(t.getMessage());
            }


        });


    }

    public void onClick(View v){
        String resultat = input.getText().toString();
        number = Integer.parseInt(resultat);
        getFacts();

    }
}