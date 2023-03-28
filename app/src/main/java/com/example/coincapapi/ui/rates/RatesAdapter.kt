package com.example.coincapapi.ui.rates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.model.rates.RatesDataModel
import com.example.coincapapi.data.model.rates.RatesModel
import com.example.coincapapi.databinding.ItemAssetBinding
import com.example.coincapapi.databinding.ItemRatesBinding
import java.text.DecimalFormat

class RatesAdapter(val rates: List<RatesDataModel>?) :
    RecyclerView.Adapter<RatesAdapter.ViewHolder>() {

    var onItemClick: ((RatesDataModel) -> Unit)? = null
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRatesBinding.bind(view)

        fun handleData(item: RatesDataModel?) {
            item?.let {
                with(it) {
                    val df = DecimalFormat("#.####")
                    //df.roundingMode = RoundingMode.DOWN
                    var roundRateUsd = df.format(rateUsd.toString().toDouble())
                    binding.tvId.text = id
                    binding.tvSymbol.text = symbol
                    binding.tvRateUsd.text = "$roundRateUsd$"

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesAdapter.ViewHolder {
        //creates item/row for the UI

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rates, parent, false)
        view.setOnClickListener{
        }

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = rates?.size ?: 0
    //size of the list


    override fun onBindViewHolder(holder: RatesAdapter.ViewHolder, position: Int) {
        //handle the current item u r on
        val rdModel = rates?.get(position)
        holder?.handleData(rdModel)
        holder?.itemView?.setOnClickListener{
            rates?.get(position)?.let{
                onItemClick?.invoke(it)
            }
        }
    }

}
