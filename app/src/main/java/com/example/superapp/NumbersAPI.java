package com.example.superapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NumbersAPI {


    @GET("/{numb}?json")
    Call<NumberFact> getFacts(@Path("numb") int number);
}
