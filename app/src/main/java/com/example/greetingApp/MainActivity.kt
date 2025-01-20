package com.example.greetingApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingApp.ui.theme.GreetingApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingApplicationTheme {
                        GreetingImage(
                            //message = stringResource(R.string.happy_birthday_text),
                            message = "Happy Birthday David",
                            from = stringResource(R.string.signature_text),
                            modifier =Modifier.padding(8.dp)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
    }
    GreetingText(
        message = message,
        from = from,
        modifier =Modifier.padding(8.dp)
    )

}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 40.sp,
            lineHeight = 56.sp,
            textAlign = TextAlign.Center,
            modifier= modifier
                .align(
                    alignment = Alignment.CenterHorizontally
                )
        )
        Text(
            text = from,
            fontSize = 30.sp,
            lineHeight = 46.sp,
            modifier = modifier
                .padding(8.dp)
                .align(alignment = Alignment.End),

        )
    }

}

@Preview(showBackground = true, name = "Test", showSystemUi = true)
@Composable
fun GreetingPreview() {
    GreetingApplicationTheme {
        GreetingImage("Happy Birthday Sam", from = "From Konstas")
    }
}