package com.example.coincapapi.ui.exchanges

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincapapi.R
import com.example.coincapapi.data.model.exchanges.ExchangesDataModel
import com.example.coincapapi.data.model.exchanges.ExchangesModel
import com.example.coincapapi.databinding.FragmentExchangesBinding

class ExchangesFragment : Fragment() {

    private var _binding: FragmentExchangesBinding? = null
    private val binding get() = _binding!!
    private lateinit var exchangesViewModel: ExchangesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exchangesViewModel =
            ViewModelProvider(this).get(ExchangesViewModel::class.java)

        _binding = FragmentExchangesBinding.inflate(inflater, container, false)

        exchangesViewModel.exchanges.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        exchangesViewModel.getExchanges()

        return binding.root
    }

    private fun setupUI(exchanges: ExchangesModel) {
        val exchangesAdapter = ExchangesAdapter(exchanges.data as List<ExchangesDataModel>?)
        binding.rvExchanges.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = exchangesAdapter
        }
        exchangesAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("ExchangesItem",it)
            }
            findNavController().navigate(
                R.id.action_exchangeDetails,bundle
            )
        }

    }



}