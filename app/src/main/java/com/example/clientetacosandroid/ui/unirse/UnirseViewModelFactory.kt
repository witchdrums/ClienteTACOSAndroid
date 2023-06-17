package com.example.clientetacosandroid.ui.unirse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clientetacosandroid.data.UnirseDataSource
import com.example.clientetacosandroid.data.UnirseRepository

class UnirseViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UnirseViewModel::class.java)) {
            return UnirseViewModel(
                unirseRepository = UnirseRepository(
                    dataSource = UnirseDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}