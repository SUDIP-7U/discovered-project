package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokeScreen()
        }
    }
}


@Composable
fun JokeScreen() {
    var jokeText by remember { mutableStateOf("Loading...") }

    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.api.getJoke()
            jokeText = when (response.type) {
                "single" -> response.joke ?: "No joke found"
                "twopart" -> "${response.setup}\n${response.delivery}"
                else -> "Unexpected response"
            }
        } catch (e: Exception) {
            jokeText = "Error: ${e.localizedMessage}"
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = jokeText, style = MaterialTheme.typography.headlineMedium)
    }
}
