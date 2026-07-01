package com.devda.buttonapp // MAKE SURE this matches your actual package name

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
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

            // Now using a Staggered Grid!
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3), // Locks it to 3 columns
                modifier = Modifier.fillMaxSize().padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between columns
                verticalItemSpacing = 8.dp // Space between rows
            ) {
                // Increased to 15 items to show off the staggered effect
                items(15) { index ->
                    val buttonNumber = index + 1

                    // This creates alternating heights for the buttons (120dp and 70dp)
                    val buttonHeight = if (index % 2 == 0) 120.dp else 70.dp

                    Button(
                        onClick = {
                            Toast.makeText(context, "I am button $buttonNumber", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .height(buttonHeight) // We apply the alternating height here
                            .fillMaxSize()
                    ) {
                        Text(text = "Btn $buttonNumber")
                    }
                }
            }
        }
    }
}