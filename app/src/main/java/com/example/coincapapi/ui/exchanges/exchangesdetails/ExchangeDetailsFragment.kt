package com.example.coincapapi.ui.exchanges.exchangesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coincapapi.data.model.exchanges.ExchangesDataModel
import com.example.coincapapi.databinding.FragmentExchangeDetailsBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class ExchangeDetailsFragment : Fragment() {

    private var _binding: FragmentExchangeDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ExchangeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[ExchangeDetailsViewModel::class.java]
        _binding = FragmentExchangeDetailsBinding.inflate(inflater, container, false)

        val exchanges = arguments?.getSerializable("ExchangesItem") as ExchangesDataModel
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        var roundvolumeUsd = if(exchanges.volumeUsd.isNullOrEmpty()){
            "Not available"
        }else{
            df.format(exchanges.volumeUsd.toString().toDouble())
        }
        var roundpercentage = if(exchanges.percentTotalVolume.isNullOrEmpty()){
            "Not available"
        }else{
            df.format(exchanges.percentTotalVolume.toString().toDouble())
        }
        binding.tvExchangesName.text = exchanges.name
        binding.tvExchangesWeb.text = exchanges.exchangeUrl
        binding.tvExchangesVolumeUsd.text = "$roundvolumeUsd$"
        binding.tvExchangesPercentage.text = "$roundpercentage%"
        binding.tvExchangesRank.text = "Rank\n${exchanges.rank}"
        binding.tvExchangesTradingPairs.text = "Trading Pairs\n${exchanges.tradingPairs}"
        binding.tvExchangesID.text = "ID\n${exchanges.exchangeId}"



        return binding.root
    }

}