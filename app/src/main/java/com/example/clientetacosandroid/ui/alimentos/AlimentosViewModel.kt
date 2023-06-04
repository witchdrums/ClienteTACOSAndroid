package com.example.clientetacosandroid.ui.alimentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clientetacosandroid.data.AlimentosRepository
import com.example.clientetacosandroid.data.model.Alimento
import com.example.clientetacosandroid.data.Result
import kotlinx.coroutines.launch

class AlimentosViewModel
(private var alimentosRepository : AlimentosRepository) : ViewModel()
{
    private val _alimentos =
        MutableLiveData<List<Alimento>>().apply{
        value = ArrayList<Alimento>();
    }

    val alimentos: LiveData<List<Alimento>> = _alimentos;

    fun cargarAlimentos(){
        viewModelScope.launch{
            val resultado = alimentosRepository.cargarAlimentos();
            if (resultado is Result.Success){
                _alimentos.value = resultado.data;
            }
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "Aquí va el menú de platillos :D"
    }
    val text: LiveData<String> = _text
}