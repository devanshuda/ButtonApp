package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape // Added import for the shape
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                repeat(3) { rowIndex ->
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        repeat(3) { columnIndex ->
                            val buttonNumber = (rowIndex * 3) + columnIndex + 1

                            Button(
                                onClick = {
                                    Toast.makeText(context, "I am button $buttonNumber", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                                    .padding(4.dp),
                                // This is the new line that changes the shape!
                                shape = RoundedCornerShape(8.dp)
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