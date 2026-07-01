package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

            // The main container fills the whole screen.
            // We add an 8.dp padding so the buttons don't touch the absolute edge of the phone.
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                // Create 3 rows
                repeat(3) { rowIndex ->

                    Row(
                        // weight(1f) here makes each row take up exactly 1/3 of the vertical height
                        modifier = Modifier.weight(1f)
                    ) {
                        // Create 3 buttons per row
                        repeat(3) { columnIndex ->

                            val buttonNumber = (rowIndex * 3) + columnIndex + 1

                            Button(
                                onClick = {
                                    Toast.makeText(context, "I am button $buttonNumber", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier
                                    .weight(1f) // Makes each button take up exactly 1/3 of the row's width
                                    .fillMaxSize() // Tells the button to stretch to fill its allocated weight block
                                    .padding(4.dp) // Creates a small gap between the buttons
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