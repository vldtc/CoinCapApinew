package com.example.coincapapi.ui.assets.assetsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.databinding.FragmentAssetsDetailsBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class AssetsDetailsFragment : Fragment() {

    private var _binding: FragmentAssetsDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AssetsDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[AssetsDetailsViewModel::class.java]
        _binding = FragmentAssetsDetailsBinding.inflate(inflater, container, false)

        val assets = arguments?.getSerializable("AssetsItem") as AssetsDataModel

        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        var roundprice = df.format(assets.priceUsd.toString().toDouble())
        var roundpercentage = df.format(assets.changePercent24Hr.toString().toDouble())
        var roundmarket = df.format(assets.marketCapUsd.toString().toDouble())
        var round24hvolume = df.format(assets.volumeUsd24Hr.toString().toDouble())
        var roundsupply = df.format(assets.supply.toString().toDouble())
        var roundmaxsupply = if(assets.maxSupply.isNullOrEmpty()){
            "Not available"
        }else{
            df.format(assets?.maxSupply.toString().toDouble())
        }



        binding.tvAssetsName.text = assets.name
        binding.tvAssetsSymbol.text = assets.symbol
        binding.tvAssetsPriceUsd.text = "$roundprice$"
        binding.tvAssetsChange24h.text = "$roundpercentage%"
        binding.tvAssetsMarketCap.text = "Market Cap\n$roundmarket"
        binding.tvAssets24hVolume.text = "24h Volume\n$round24hvolume"
        binding.tvAssetsRank.text = "Rank\n${assets.rank}"
        binding.tvAssetsSupply.text = "Supply\n$roundsupply"
        binding.tvAssetsMaxSupply.text = "Max Supply\n$roundmaxsupply"
        binding.tvAssetsID.text = "ID\n${assets.id}"


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AssetsDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}