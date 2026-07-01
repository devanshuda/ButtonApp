package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowColumn
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

            // FlowColumn places items top-to-bottom, wrapping to a new column when out of vertical space
            FlowColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between columns
                verticalArrangement = Arrangement.spacedBy(8.dp) // Space between buttons vertically
            ) {

                // Increased to 20 items so it hits the bottom of the screen and wraps
                repeat(20) { index ->
                    val buttonNumber = index + 1

                    // We make some buttons intentionally taller to show off the vertical wrapping
                    val buttonText = if (index % 4 == 0) {
                        "Tall\nBtn\n$buttonNumber"
                    } else {
                        "Btn $buttonNumber"
                    }

                    Button(
                        onClick = {
                            Toast.makeText(context, "I am button $buttonNumber", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(text = buttonText)
                    }
                }
            }
        }
    }
}