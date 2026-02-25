package com.example.application
// JokeAPI response structure
data class JokeResponse(
    val type: String,        // "single" বা "twopart"
    val joke: String?,       // যদি single joke হয়
    val setup: String?,      // যদি twopart joke হয়
    val delivery: String?    // twopart এর punchline
)
