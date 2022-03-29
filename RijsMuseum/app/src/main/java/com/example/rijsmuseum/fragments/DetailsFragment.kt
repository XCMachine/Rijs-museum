package com.example.rijsmuseum.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.rijsmuseum.R
import com.example.rijsmuseum.databinding.FragmentCollectionDetailsBinding
import com.example.rijsmuseum.fragments.ArtifactsFragment.Companion.OBJECT_NUMBER
import com.example.rijsmuseum.viewmodel.DetailsViewModel

class DetailsFragment : Fragment(R.layout.fragment_collection_details) {
    private lateinit var detailsViewModel: DetailsViewModel

    private lateinit var binding: FragmentCollectionDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCollectionDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getString(OBJECT_NUMBER)?.let { argumentString ->
            Log.d("Bundle", "Object number is: $argumentString")
            detailsViewModel.cDetailsList.observe(viewLifecycleOwner) {
                binding.collapsingToolbarLayout.title = it.title

                Glide.with(requireActivity())
                    .load(it.webImage.url)
                    .into(binding.imageView)

                binding.artDetailsDescription.text = it.description
            }

            detailsViewModel.getCollectionsDetailsRequest(argumentString)
        } ?: Log.e("Error", "Object number is null")
    }
}