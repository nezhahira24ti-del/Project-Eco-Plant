package com.example.nezhahira_3tic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.nezhahira_3tic.R
import com.example.nezhahira_3tic.model.PlantModel

class PlantAdapter(context: Context, private val plants: List<PlantModel>) :
    ArrayAdapter<PlantModel>(context, R.layout.item_plant, plants) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_plant, parent, false)
        
        val plant = getItem(position)
        
        val imgPlant = view.findViewById<ImageView>(R.id.imgPlant)
        val tvPlantName = view.findViewById<TextView>(R.id.tvPlantName)
        val tvPlantDesc = view.findViewById<TextView>(R.id.tvPlantDesc)

        plant?.let {
            tvPlantName.text = it.name
            tvPlantDesc.text = it.description
            imgPlant.setImageResource(it.imageRes)
        }

        return view
    }
}
