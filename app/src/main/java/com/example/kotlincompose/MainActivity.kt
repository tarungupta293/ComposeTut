package com.example.kotlincompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    private var fibonacciList = ArrayList<Long>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fibonacciLogic(100)
        setContent {
            createFibonacciList()
        }
    }

    private fun fibonacciLogic(length: Int) {
        var preVal = 0L
        var value = 0L

            for (i in 0..length) {
                fibonacciList.add(value)
                val temp = value
                value = value + preVal
                preVal = temp
                if (i == 0) {
                    value = 1
                    preVal = 0
                }
            }

    }

    @Composable
    fun setLoginPage() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
            Text(text = "Hi, This is Compose Login Page")
            val inputvalueFirstName = remember { mutableStateOf(TextFieldValue()) }
            val inputvalueLastName = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = inputvalueFirstName.value,
                onValueChange = {inputvalueFirstName.value = it},
                placeholder = { Text(text = "Enter First Name") },
                modifier = Modifier.padding(all = 8.dp),
                maxLines = 1
            )

            TextField(
                value = inputvalueLastName.value,
                onValueChange = {inputvalueLastName.value = it},
                placeholder = { Text(text = "Enter Last Name") },
                modifier = Modifier.padding(all = 8.dp),
                maxLines = 1
            )

            Button(
                modifier = Modifier
                    .padding(vertical = 8.dp,
                    horizontal = 24.dp),
                onClick = {}
            ) {
                Text("Continue")
            }

        }
    }

    @Composable
    fun createFibonacciLogic(lenth: Int) {
        Column(modifier = Modifier.fillMaxSize()) {


        }
    }
    @Composable
    fun createFibonacciList() {
        LazyColumn() {
            items(fibonacciList) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "" + it,
                        color = Color.White,
                        modifier = Modifier
                            .padding(all = 16.dp)
                            .align(CenterHorizontally)
                    )

                    Divider()
                }

            }
        }
//            if (value == -1) {
//                item {
//                    Text(
//                        text = "Button that does nothing",
//                        color = Color.Blue,
//                        modifier = Modifier
//                            .padding(all = 16.dp)
////                            .align(CenterHorizontally)
//                    )
//                }
//                item {
//                    Divider()
//                }
//
//            }
//            else {
//                item {
//
//                }
//
//                item {
//
//                }
//
//            }
//        }
    }
}