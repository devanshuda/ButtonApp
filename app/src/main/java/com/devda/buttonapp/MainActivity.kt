package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            // LazyVerticalGrid automatically arranges items in a grid layout
            LazyVerticalGrid(
                columns = GridCells.Fixed(3), // Forces exactly 3 columns
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, // Centers the grid vertically on screen
                horizontalArrangement = Arrangement.Center // Centers the grid horizontally
            ) {

                // We use 'items(9)' to generate 9 buttons without writing the code 9 times
                items(9) { index ->

                    // The 'index' goes from 0 to 8, so we add 1 to get buttons 1 through 9
                    val buttonNumber = index + 1

                    Button(
                        onClick = {
                            // The Toast dynamically displays the correct button number
                            Toast.makeText(context, "I am button $buttonNumber", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.padding(4.dp) // Adds a tiny gap around each button
                    ) {
                        // The text on the button itself
                        Text(text = "Btn $buttonNumber")
                    }
                }
            }
        }
    }
}