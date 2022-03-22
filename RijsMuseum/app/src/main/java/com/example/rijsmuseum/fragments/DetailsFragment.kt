package com.example.rijsmuseum.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.network.models.CollectionsDetails
import com.example.rijsmuseum.MainActivity.Companion.OBJECT_NUMBER
import com.example.rijsmuseum.R
import com.example.rijsmuseum.databinding.FragmentCollectionDetailsBinding
import com.example.rijsmuseum.viewmodel.DetailsViewModel


class DetailsFragment : Fragment(R.layout.fragment_collection_details) {
    private lateinit var detailsViewModel: DetailsViewModel

    private var _binding: FragmentCollectionDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCollectionDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getString(OBJECT_NUMBER)?.let { argumentString ->
            Log.d("Bundle", "Object number is: $argumentString")

            val stringObserver = Observer<CollectionsDetails.ArtObject> { newString ->
                binding.fragmentTitle.text = newString.title
            }
            detailsViewModel.cList.observe(viewLifecycleOwner, stringObserver)

            detailsViewModel.getCollectionsDetailsRequest(argumentString)
        } ?: Log.e("Error", "Object number is null")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}