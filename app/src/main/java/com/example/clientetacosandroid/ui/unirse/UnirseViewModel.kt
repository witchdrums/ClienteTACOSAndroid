package com.example.clientetacosandroid.ui.unirse

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clientetacosandroid.R
import com.example.clientetacosandroid.data.UnirseRepository
import com.example.clientetacosandroid.data.model.Miembro
import com.example.clientetacosandroid.data.Result
import kotlinx.coroutines.launch


class UnirseViewModel(private val unirseRepository: UnirseRepository) : ViewModel() {

    private val _unirseForm = MutableLiveData<UnirseFormState>();
    val unirseFormState: LiveData<UnirseFormState> = _unirseForm;

    private val _unirseResult = MutableLiveData<UnirseResult>();
    val unirseResult: LiveData<UnirseResult> = _unirseResult;

    fun unirse(miembro: Miembro){
        viewModelScope.launch {

            val result = unirseRepository.unirse(miembro);

            if (result is Result.Success) {
                _unirseResult.value = UnirseResult(true)
            } else {
                _unirseResult.value = UnirseResult(false)
            }


        }
    }

    /*
    Invocada desde UnirseFragment.onViewCreated,
     */
    fun unirseDataChanged(
        email: String,
        contrasena: String,
        nombre: String,
        telefono: String,
    ){
        if (!emailValido(email)){
            _unirseForm.value = UnirseFormState(usernameError = R.string.invalid_username)
        } else if (!contrasenaValida(contrasena)){
            _unirseForm.value = UnirseFormState(passwordError = R.string.invalid_password)
        } else if (!nombreValido(nombre)){
            _unirseForm.value = UnirseFormState(nombreError = R.string.invalid_nombre)
        }else if (!telefonoValido(telefono)){
            _unirseForm.value = UnirseFormState(telefonoError = R.string.invalid_nombre)
        } else {
            _unirseForm.value = UnirseFormState(isDataValid = true)
        }
    }

    private fun emailValido(email: String): Boolean{
        return ! email.isNullOrBlank()
                && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun contrasenaValida(contrasena: String): Boolean {
        return contrasena.length > 5
    }

    private fun nombreValido(nombre: String): Boolean{
        return ! nombre.isNullOrBlank()
                && nombre.all { it.isLetter() };
    }

    private fun telefonoValido(telefono: String): Boolean{
        return telefono.length == 10
                && telefono.all { it.isDigit() };
    }
}