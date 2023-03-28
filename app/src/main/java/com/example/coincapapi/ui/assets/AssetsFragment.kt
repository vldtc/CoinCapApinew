package com.example.coincapapi.ui.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.databinding.FragmentAssetsBinding

class AssetsFragment : Fragment() {

    private var _binding: FragmentAssetsBinding? = null
    private val binding get() = _binding!!
    private lateinit var assetsViewModel: AssetsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        assetsViewModel =
            ViewModelProvider(this).get(AssetsViewModel::class.java)
        _binding = FragmentAssetsBinding.inflate(inflater, container, false)

        assetsViewModel.assets.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        assetsViewModel.getAssets()

        return binding.root
    }

    private fun setupUI(assets: AssetsModel) {
        val assetsAdapter = AssetsAdapter(assets.data as List<AssetsDataModel>?)
        binding.rvAssets.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = assetsAdapter
        }
        assetsAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("AssetsItem",it)
            }
            findNavController().navigate(
                R.id.action_assetsDetails,bundle
            )
        }
    }


}