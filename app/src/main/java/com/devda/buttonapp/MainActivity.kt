package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This gets the environment data needed to show a Toast message
            val context = LocalContext.current

            // A Box is a layout that lets us easily center things on the screen
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                // This creates the Button and handles the click
                Button(onClick = {
                    Toast.makeText(context, "I am here", Toast.LENGTH_SHORT).show()
                }) {
                    // The text inside the button
                    Text(text = "Tap Me!")
                }
            }
        }
    }
}