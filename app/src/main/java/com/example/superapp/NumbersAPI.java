package com.example.superapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NumbersAPI {

    //@GET("/{numb}?json")
    //Call<List<NumberFact>> getFacts(@Path("numb") int number);
    @GET("/23?json")
    Call<NumberFact> getFacts();
}
