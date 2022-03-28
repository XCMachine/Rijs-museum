package com.example.rijsmuseum.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.network.models.Collections
import com.example.rijsmuseum.adapter.RecyclerAdapter
import com.example.rijsmuseum.databinding.FragmentArtifactBinding
import com.example.rijsmuseum.viewmodel.ArtifactsViewModel

class ArtifactsFragment : Fragment() {
    private lateinit var artifactsViewModel: ArtifactsViewModel
    private lateinit var binding: FragmentArtifactBinding

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artifactsViewModel = ViewModelProvider(this).get(ArtifactsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtifactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAdapter()

        artifactsViewModel.cList.observe(viewLifecycleOwner) { listArtObjects ->
            adapter.updateCollectionsData(listArtObjects)
        }
        artifactsViewModel.getCollectionsRequest()
    }

    private fun getAdapter() {
        adapter = RecyclerAdapter()
        adapter.setOnItemClickListener(object : RecyclerAdapter.OnClickCallback {
            override fun onItemClick(cList: Collections.ArtObject) {
                val bundle = bundleOf(OBJECT_NUMBER to cList.objectNumber)
                val action = ArtifactsFragmentDirections.actionArtifactsFragmentToDetailsFragment()
                findNavController().navigate(action.actionId, bundle)
            }
        })
        binding.recyclerView.adapter = adapter
    }

    companion object {
        const val OBJECT_NUMBER = "objectNumber"
    }
}