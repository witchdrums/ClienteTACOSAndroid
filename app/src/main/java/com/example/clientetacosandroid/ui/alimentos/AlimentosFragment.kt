package com.example.clientetacosandroid.ui.alimentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clientetacosandroid.data.model.Alimento
import com.example.clientetacosandroid.databinding.FragmentAlimentosBinding
import com.google.gson.GsonBuilder

class AlimentosFragment : Fragment() {

    private var _binding: FragmentAlimentosBinding? = null
    private val binding get() = _binding!!
    private lateinit var alimentosViewModel: AlimentosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        alimentosViewModel =
            ViewModelProvider(this, AlimentosViewModelFactory())
                .get(AlimentosViewModel::class.java)

        _binding = FragmentAlimentosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listaAlimentos: RecyclerView = binding.listaAlimentos;
        listaAlimentos.layoutManager = LinearLayoutManager(this.context);


        val adapter : AlimentoAdapter = AlimentoAdapter({curso -> editarCurso(curso)})
        listaAlimentos.adapter = adapter;
        alimentosViewModel.alimentos.observe(viewLifecycleOwner) {
            it?.let {
                adapter.asignarCursos(it)
            }
        }

        return root
    }

    private fun editarCurso(alimento: Alimento) {
        /*
        val params = Bundle()
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
        val json = gson.toJson(curso)
        params.putString("curso", json)
        findNavController()
            .navigate(R.id.action_nav_cursos_to_editarCursoFragment, params)

         */
    }

    override fun onStart() {
        super.onStart()
        alimentosViewModel.cargarAlimentos()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}