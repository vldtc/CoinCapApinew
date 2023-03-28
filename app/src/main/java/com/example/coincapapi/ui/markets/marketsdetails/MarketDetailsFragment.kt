package com.example.coincapapi.ui.markets.marketsdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincapapi.R
import com.example.coincapapi.data.model.markets.MarketsDataModel
import com.example.coincapapi.data.model.rates.RatesDataModel
import com.example.coincapapi.databinding.FragmentMarketDetailsBinding
import com.example.coincapapi.databinding.FragmentRatesDetailsBinding
import com.example.coincapapi.ui.markets.MarketsViewModel
import com.example.coincapapi.ui.rates.ratesdetails.RatesDetailsViewModel
import java.text.DecimalFormat

class MarketDetailsFragment : Fragment() {

    private var _binding: FragmentMarketDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MarketDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[MarketDetailsViewModel::class.java]
        _binding = FragmentMarketDetailsBinding.inflate(inflater, container, false)

        val markets = arguments?.getSerializable("MarketsItem") as MarketsDataModel
        val df = DecimalFormat("#.####")
        var roundPriceQuote = df.format(markets.priceQuote.toString().toDouble())
        var roundPriceUsd = df.format(markets.priceUsd.toString().toDouble())
        var roundVolumeUsed = df.format(markets.volumeUsd24Hr.toString().toDouble())
        var roundPercentVolume = df.format(markets.percentExchangeVolume.toString().toDouble())
        var roundTradesCount = if(markets.tradesCount24Hr.isNullOrEmpty()) "Not Available" else df.format(markets.tradesCount24Hr.toString().toDouble())

        binding.tvMarketsBaseSymbol.text = markets.baseSymbol
        binding.tvMarketsQuoteSymbol.text = markets.quoteSymbol
        binding.tvMarketsBaseId.text = markets.baseId
        binding.tvMarketsQuoteId.text = markets.quoteId
        binding.tvMarketsPriceQuote.text = "Price Quote\n$roundPriceQuote$"
        binding.tvMarketsPriceUsd.text = "Price USD\n$roundPriceUsd$"
        binding.tvMarketsVolumeUsed.text = "Volume/24h\n$roundVolumeUsed"
        binding.tvMarketsPercentExchange.text = "Percent Exchange\n$roundPercentVolume%"
        binding.tvMarketsTradesCount.text = "Trades Count\n$roundTradesCount"



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MarketDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}