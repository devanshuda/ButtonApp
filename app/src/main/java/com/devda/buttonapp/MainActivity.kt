package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            // The main container that holds the rows
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, // Centers the rows vertically
                horizontalAlignment = Alignment.CenterHorizontally // Centers the rows horizontally
            ) {
                // Outer loop to create 3 Rows
                repeat(3) { rowIndex ->

                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        // Inner loop to create 3 Buttons inside each Row
                        repeat(3) { columnIndex ->

                            // Math to calculate button numbers 1 through 9 based on the current row and column
                            val buttonNumber = (rowIndex * 3) + columnIndex + 1

                            Button(
                                onClick = {
                                    Toast.makeText(context, "I am button $buttonNumber", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier.padding(4.dp)
                            ) {
                                Text(text = "Btn $buttonNumber")
                            }
                        }
                    }

                }
            }
        }
    }
}