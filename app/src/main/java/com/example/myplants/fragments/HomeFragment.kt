package com.example.myplants.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myplants.MainActivity
import com.example.myplants.PlantModel
import com.example.myplants.R
import com.example.myplants.adapter.PlantAdapter
import com.example.myplants.adapter.PlantItemDecoration

class HomeFragment(
    private val context: MainActivity
): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        // creer une liste qui va stocker ces plantes
        val plantList = arrayListOf<PlantModel>()

        // enregister une 1ere plante
        plantList.add(
            PlantModel(
            name = "Pissenlit",
                description = "jaune soleil",
                imageUrl = "https://cdn.pixabay.com/photo/2016/07/30/13/16/dandelion-1557110_1280.jpg",
                liked = false
        ))
        // enregister une 2eme plante
        plantList.add(
            PlantModel(
                name = "rose",
                description = "ca pique un peu",
                imageUrl = "https://cdn.pixabay.com/photo/2018/02/09/21/46/rose-3142529_1280.jpg",
                liked = false
            ))
        // enregister une 3eme plante
        plantList.add(
            PlantModel(
                name = "cactus",
                description = "ca pique un bcp",
                imageUrl = "https://media.istockphoto.com/photos/big-cactus-in-the-nature-picture-id1315231921?s=612x612",
                liked = false
            ))
        // enregister une 4eme plante
        plantList.add(
            PlantModel(
                name = "tulipe",
                description = "c'est beau",
                imageUrl = "https://cdn.pixabay.com/photo/2018/03/26/16/38/nature-3263198_1280.jpg",
                liked = false
            ))

        // recuperer le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_horizontal_plant)

        // recuperer le 2e recyclerview
        val verticalrecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalrecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        verticalrecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }

}