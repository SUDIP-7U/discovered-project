package com.example.application

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://v2.jokeapi.dev/") // must end with /
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: JokeApi = retrofit.create(JokeApi::class.java)
}
