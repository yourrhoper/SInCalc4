package com.example.sincalc4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sincalc4.ui.theme.SInCalc4Theme
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CycleApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CycleApp() {
    var n by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Вычисление суммы")

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = n,
            onValueChange = { newValue ->
                n = newValue
            },
            label = { Text("Введите n") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val number = n.toIntOrNull() // текст в число
                if (number != null && number > 0) {
                    var sum = 0.0
                    var resultSum = 0.0
                    for (i in 1..number) {
                        sum += sin(Math.toRadians(i.toDouble())) // сумма в знаменателе
                        resultSum += 1 / sum // вся сумма
                    }
                    result = "Результат = $resultSum"

                } else {
                    result = "Введите натуральное число"
                }
            }
        )
        {
            Text("Вычислить")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(result)
    }
}