package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
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

            // FlowRow places items next to each other and wraps them like text in a paragraph
            FlowRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between buttons horizontally
                verticalArrangement = Arrangement.spacedBy(8.dp) // Space between wrapped lines
            ) {
                // IMPORTANT: FlowRow is not a "Lazy" layout, so we use a standard Kotlin 'repeat'
                // block instead of the 'items()' function we used in the previous grids.
                repeat(15) { index ->
                    val buttonNumber = index + 1

                    // We make some buttons intentionally wider to show off the wrapping effect
                    val buttonText = if (index % 3 == 0) {
                        "Super Long Button $buttonNumber"
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