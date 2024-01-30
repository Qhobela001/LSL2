package com.example.lsl

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lsl.R.drawable.another_2
import com.example.lsl.ui.theme.LSLTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity() : ComponentActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LSLTheme {
                // A surface container using the 'background_image' as the background
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Image(
                        painter = painterResource(id = another_2),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(18.dp),
                        contentScale = ContentScale.Crop
                    )

                    // Column with content
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top // Align content to the top
                    ) {
                        // Top App Bar
                        TopAppBar(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent),
                            title = {
                                Greeting(
                                    "Lesotho Sign",
                                    fontSize = 50.sp,
                                    textColor = Color.Black,
                                    bgColor = Color(0xFFADD8E6))
                            },
                        )

                        Spacer(modifier = Modifier.height(4.dp))
                        Greeting("Language", fontSize = 50.sp, textColor = Color.Black, bgColor = Color(0xFFADD8E6))
                        // Add the 'Chat Now' button
                        Spacer(modifier = Modifier.height(500.dp))
                        ChatButton("Play Game")
                        // Move the 'Play Game' button almost to the bottom
                        PlayGameButton("Community ChatRoom")
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(text: String, fontSize: TextUnit, textColor: Color, bgColor: Color, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(bgColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = TextStyle(fontSize = fontSize, fontWeight = FontWeight.Bold, color = textColor)
            )
        }
    }

    @Composable
    fun ChatButton(text: String, modifier: Modifier = Modifier) {
        Button(
            onClick = {
                // Add your logic for handling button click here
                // For example, you can open a new activity, show a toast, etc.
            },
            modifier = modifier
        ) {
            Text(text = text)
        }
    }

    @Composable
    fun PlayGameButton(text: String, modifier: Modifier = Modifier) {
        Button(
            onClick = {
                // Add your logic for handling 'Play Game' button click here
                // For example, you can navigate to the game screen
            },
            modifier = modifier
        ) {
            Text(text = text)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        LSLTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting("Lesotho Sign", fontSize = 50.sp, textColor = Color.Black, bgColor = Color(0xFFADD8E6)) // Pale Blue
                Spacer(modifier = Modifier.height(4.dp))
                Greeting("Language", fontSize = 50.sp, textColor = Color.Black, bgColor = Color(0xFFADD8E6))
                Spacer(modifier = Modifier.weight(1f))
                PlayGameButton("Play Game")
                Spacer(modifier = Modifier.height(16.dp))
                ChatButton("Community ChatRoom")
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
