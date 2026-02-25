package com.example.application

import retrofit2.http.GET

interface JokeApi {
    @GET("joke/Any") // endpoint for any category joke
    suspend fun getJoke(): JokeResponse
}

