package com.example.corrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.corrutinas.ViewModel.ItemsViewModel
import com.example.corrutinas.model.ItemsModel
import com.example.corrutinas.ui.theme.CorrutinasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CorrutinasTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){

                }
            }
        }
    }
}

@Composable
fun ItemsView(viewModel: ItemsViewModel){
    val itemsList: MutableList <ItemsModel> = viewModel.itemList
    val lista: List<ItemsModel> by viewModel.lista.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }
    Column{
        if(viewModel.isLoading){
            CircularProgressIndicator()
        }else{
            LazyColumn{
                items(lista){
                    item -> Text(text = item.name)
                }
            }
        }
    }
}