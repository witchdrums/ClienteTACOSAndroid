package com.example.clientetacosandroid.ui.unirse

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clientetacosandroid.R

class UnirseFragment : Fragment() {

    companion object {
        fun newInstance() = UnirseFragment()
    }

    private lateinit var viewModel: UnirseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_unirse, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UnirseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}