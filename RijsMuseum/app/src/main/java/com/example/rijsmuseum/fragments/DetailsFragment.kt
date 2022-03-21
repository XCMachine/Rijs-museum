package com.example.rijsmuseum.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.models.CollectionsDetails
import com.example.rijsmuseum.R
import com.example.rijsmuseum.viewmodel.DetailsViewModel


class DetailsFragment : Fragment(R.layout.fragment_collection_details) {
    private lateinit var titleText: TextView
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_collection_details, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleText = view.findViewById(R.id.fragmentTitle)
        val bundle = Bundle()

        detailsViewModel.getCollectionsDetailsRequest(object : CollectionsDetailsGetter.DataReadyCallback {
            override fun onDataReady(data: CollectionsDetails.ArtObject) {
                titleText.text = data.title
                //Getting string value from Bundle
                bundle.getString("objectNumber")
            }

        })
    }
}