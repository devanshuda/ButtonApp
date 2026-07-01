package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
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

            // Now using a Horizontal Grid!
            LazyHorizontalGrid(
                rows = GridCells.Fixed(3), // We define rows instead of columns here
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalArrangement = Arrangement.Center
            ) {
                // If you want to see the side-scrolling in action, try changing this 9 to 30!
                items(30) { index ->
                    val buttonNumber = index + 1

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