package com.example.weatherium

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.weatherium.data.network.RetrofitInstance
import com.example.weatherium.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {

            try {

                val weather =
                    RetrofitInstance.api.getCurrentWeather(
                        city = "Seoul",
                        apiKey = "8132dc666761a483a022f9e6f4785716"
                    )

                Log.d("WEATHER", weather.toString())

            } catch (e: Exception) {

                Log.e("WEATHER", e.toString())
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}