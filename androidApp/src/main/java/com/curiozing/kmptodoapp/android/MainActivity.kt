package com.curiozing.kmptodoapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.curiozing.kmptodoapp.articles.ToDoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ToDoViewModel by viewModels()

        setContent {

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val toDoList = viewModel.getToDo.collectAsState().value

                    LazyColumn(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                        content = {
                        toDoList.forEach {
                            item {
                                Column(
                                    modifier = Modifier.padding(vertical = 12.dp)
                                ) {
                                    Text(text = it.title, fontWeight = FontWeight.Bold)
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Text(text = it.task)
                                }
                            }
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
