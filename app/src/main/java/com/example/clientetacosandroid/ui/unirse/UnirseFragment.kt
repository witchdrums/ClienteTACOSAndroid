package com.example.clientetacosandroid.ui.unirse

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.clientetacosandroid.R
import com.example.clientetacosandroid.data.model.Miembro
import com.example.clientetacosandroid.data.model.Persona
import com.example.clientetacosandroid.databinding.FragmentUnirseBinding
import com.google.gson.Gson

class UnirseFragment : Fragment() {

    private lateinit var unirseViewModel: UnirseViewModel
    private var _binding: FragmentUnirseBinding? = null;
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUnirseBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        unirseViewModel = ViewModelProvider(this, UnirseViewModelFactory())
            .get(UnirseViewModel::class.java)

        val emailEditText = binding.username;
        val contrasenaEditText = binding.password;
        val nombreEditText = binding.unirseNombre;
        val direccionEditText = binding.unirseDireccion;
        val telefonoEditText = binding.unirseTelefono;
        val loadingProgressBar = binding.loading;
        val unirseButton = binding.unirse;

        unirseViewModel.unirseFormState.observe(viewLifecycleOwner,
            Observer { unirseFormState ->
                if (unirseFormState == null){
                    return@Observer;
                }
                unirseButton.isEnabled = unirseFormState.isDataValid;
                unirseFormState.usernameError?.let{emailEditText.error = getString(it);}
                unirseFormState.passwordError?.let{contrasenaEditText.error = getString(it);}
                unirseFormState.nombreError?.let{nombreEditText.error = getString(it);}
                unirseFormState.direccionError?.let{direccionEditText.error = getString(it);}
                unirseFormState.telefonoError?.let{telefonoEditText.error = getString(it);}

            });
        unirseViewModel.unirseResult.observe(viewLifecycleOwner,
            Observer { unirseResult ->
                unirseResult ?: return@Observer;
                loadingProgressBar.visibility = View.GONE;
                unirseResult.error?.let {
                    //showUnirseFailed(it)
                }
                unirseResult.success?.let{
                    //updateUiWithUser(it)
                }
            });
        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                unirseViewModel.unirseDataChanged(
                    emailEditText.text.toString(),
                    contrasenaEditText.text.toString(),
                    nombreEditText.text.toString(),
                    telefonoEditText.text.toString()
                )
            }
        }

        emailEditText.addTextChangedListener(afterTextChangedListener)
        contrasenaEditText.addTextChangedListener(afterTextChangedListener)
        nombreEditText.addTextChangedListener(afterTextChangedListener)
        direccionEditText.addTextChangedListener(afterTextChangedListener)
        telefonoEditText.addTextChangedListener(afterTextChangedListener)
        contrasenaEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val comodin = Miembro(
                    contrasena = contrasenaEditText.text.toString(),
                    persona = Persona(
                        email = emailEditText.text.toString(),
                        nombre = nombreEditText.text.toString(),
                        direccion = direccionEditText.text.toString(),
                        telefono = telefonoEditText.text.toString()
                    )
                )
                unirseViewModel.unirse(comodin)
            }
            false
        }

        unirseButton.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            val comodin = Miembro(
                contrasena = contrasenaEditText.text.toString(),
                persona = Persona(
                    email = emailEditText.text.toString(),
                    nombre = nombreEditText.text.toString(),
                    direccion = direccionEditText.text.toString(),
                    telefono = telefonoEditText.text.toString()
                )
            )
            unirseViewModel.unirse(comodin)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        unirseViewModel = ViewModelProvider(this).get(UnirseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}