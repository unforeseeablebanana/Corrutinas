package com.example.corrutinas.ViewModel;

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.corrutinas.model.ItemsModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemsViewModel: ViewModel() {
    private val _lista: MutableStateFlow<List<ItemsModel>> = MutableStateFlow(emptyList())
    val lista = _lista
    var itemList = mutableListOf(ItemsModel())
        private set
    var isLoading by mutableStateOf(false)
        private set

    fun fetchData(){
        viewModelScope.launch {
            try {
                isLoading = true
            } catch (e: Exception) {
               print("Error: $e")
            }
            finally {
                isLoading = false
            }
        }
    }

    private suspend fun llamarAPI(){
        val result = withContext(Dispatchers.IO){
            delay(5000)
            listOf( // Usando la clase ItemsModel.
                ItemsModel(1, "Elemento Uno"),
                ItemsModel(2, "Elemento Dos"),
                ItemsModel(3, "Elemento Tres"),
                ItemsModel(4, "Elemento Cuatro"),
                ItemsModel(5, "Elemento Cinco"),
                ItemsModel(6, "Elemento Seis"),
                ItemsModel(7, "Elemento Siete"),
                ItemsModel(8, "Elemento Ocho"),
                ItemsModel(9, "Elemento Nueve"),
                ItemsModel(10, "Elemento Diez"),
                ItemsModel(11, "Elemento Once"),
                ItemsModel(12, "Elemento Doce"),
                ItemsModel(13, "Elemento Trece"),
                ItemsModel(14, "Elemento Catorce"),
                ItemsModel(15, "Elemento Quince"),
                ItemsModel(16, "Elemento Dieciséis"),
                ItemsModel(17, "Elemento Diecisiete"),
                ItemsModel(18, "Elemento Dieciocho"),
                ItemsModel(19, "Elemento Diecinueve"),
                ItemsModel(20, "Elemento Veinte"),
                ItemsModel(21, "Elemento Veintiuno"),
                ItemsModel(22, "Elemento Veintidós"),
                ItemsModel(23, "Elemento Veintitrés"),
                ItemsModel(24, "Elemento Veinticuatro"),
                ItemsModel(25, "Elemento Veinticinco"),
                ItemsModel(26, "Elemento Veintiséis"),
                ItemsModel(27, "Elemento Veintisiete"),
                ItemsModel(28, "Elemento Veintiocho"),
                ItemsModel(29, "Elemento Veintinueve"),
                ItemsModel(30, "Elemento Treinta"),
                ItemsModel(31, "Elemento Treinta y uno"),
                ItemsModel(32, "Elemento Treinta y dos"),
                ItemsModel(33, "Elemento Treinta y tres"),
                ItemsModel(34, "Elemento Treinta y cuatro"),
                ItemsModel(35, "Elemento Treinta y cinco"),
                ItemsModel(36, "Elemento Treinta y seis"),
                ItemsModel(37, "Elemento Treinta y siete"),
                ItemsModel(38, "Elemento Treinta y ocho"),
                ItemsModel(39, "Elemento Treinta y nueve"),
                ItemsModel(40, "Elemento Cuarenta"),
                ItemsModel(41, "Elemento Cuarenta y uno"),
                ItemsModel(42, "Elemento Cuarenta y dos"),
                ItemsModel(43, "Elemento Cuarenta y tres"),
                ItemsModel(44, "Elemento Cuarenta y cuatro"),
                ItemsModel(45, "Elemento Cuarenta y cinco"),
                ItemsModel(46, "Elemento Cuarenta y seis"),
                ItemsModel(47, "Elemento Cuarenta y siete"),
                ItemsModel(48, "Elemento Cuarenta y ocho"),
                ItemsModel(49, "Elemento Cuarenta y nueve"),
                ItemsModel(50, "Elemento Cincuenta")
            )
        }
        itemList.addAll(result)
        lista.value = itemList
    }
}