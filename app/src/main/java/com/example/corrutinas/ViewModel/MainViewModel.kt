package com.example.corrutinas.ViewModel

import com.example.corrutinas.model.ItemsModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel {
    private val _lista: MutableStateFlow<List<ItemsModel>> = MutableStateFlow(emptyList())
    val lista = _lista
}