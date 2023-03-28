package com.example.coincapapi.ui.rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.model.rates.RatesDataModel
import com.example.coincapapi.data.model.rates.RatesModel
import com.example.coincapapi.databinding.FragmentRatesBinding
import com.example.coincapapi.ui.assets.AssetsAdapter

class RatesFragment : Fragment() {

    private var _binding: FragmentRatesBinding? = null
    private val binding get() = _binding!!
    private lateinit var ratesViewModel: RatesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ratesViewModel =
            ViewModelProvider(this).get(RatesViewModel::class.java)

        _binding = FragmentRatesBinding.inflate(inflater, container, false)

        ratesViewModel.rates.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        ratesViewModel.getRates()

        return binding.root
    }

    private fun setupUI(rates: RatesModel) {
        val ratesAdapter = RatesAdapter(rates.data?.sortedBy { it?.id } as List<RatesDataModel>?)
        binding.rvRates.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ratesAdapter
        }
        ratesAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("RatesItem",it)
            }
            findNavController().navigate(
                R.id.action_ratesDetails,bundle
            )
        }
    }
}