package com.example.clientetacosandroid.ui.alimentos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clientetacosandroid.data.AlimentosRepository

class AlimentosViewModelFactory : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlimentosViewModel::class.java)) {
            return AlimentosViewModel(
                alimentosRepository =  AlimentosRepository()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}