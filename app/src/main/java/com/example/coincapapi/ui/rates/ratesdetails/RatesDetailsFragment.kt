package com.example.coincapapi.ui.rates.ratesdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincapapi.R
import com.example.coincapapi.data.model.rates.RatesDataModel
import com.example.coincapapi.databinding.FragmentRatesDetailsBinding
import java.text.DecimalFormat

class RatesDetailsFragment : Fragment() {

    private var _binding: FragmentRatesDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RatesDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[RatesDetailsViewModel::class.java]
        _binding = FragmentRatesDetailsBinding.inflate(inflater, container, false)

        val rates = arguments?.getSerializable("RatesItem") as RatesDataModel
        val df = DecimalFormat("#.####")
        var roundRateUsd = df.format(rates.rateUsd.toString().toDouble())


        binding.tvRatesId.text = rates.id
        binding.tvRatesSymbol.text = rates.symbol
        binding.tvRatesCurrencySymbol.text = "SYMBOL: ${rates.currencySymbol}"
        binding.tvRatesType.text = "TYPE: ${rates.type}"
        binding.tvRatesRateUsd.text = "Price($)\n${roundRateUsd}$"

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RatesDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}