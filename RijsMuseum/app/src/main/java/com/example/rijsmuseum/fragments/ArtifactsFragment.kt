package com.example.rijsmuseum.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rijsmuseum.adapter.RecyclerAdapter
import com.example.rijsmuseum.databinding.FragmentArtifactBinding
import com.example.rijsmuseum.domain.models.ListArtObject
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
        observeData()
        getAdapter()

        binding.swipeRefreshLayout.setOnRefreshListener {
            Log.i(LOG_TAG, "onRefreshed called from SwipeRefreshLayout")
            artifactsViewModel.getCollectionsRequest()
        }
    }

    private fun observeData() {
        artifactsViewModel.cList.observe(viewLifecycleOwner) { listArtObjects ->
            Log.i(LOG_TAG, "Refreshing False")
            adapter.updateCollectionsData(listArtObjects)
            binding.swipeRefreshLayout.isRefreshing = false
        }

        artifactsViewModel.getCollectionsRequest()
    }

    private fun getAdapter() {
        adapter = RecyclerAdapter()
        adapter.setOnItemClickListener(object : RecyclerAdapter.OnClickCallback {
            override fun onItemClick(cList: ListArtObject) {
                val bundle = bundleOf(OBJECT_NUMBER to cList.objectNumber)
                val action = ArtifactsFragmentDirections.actionArtifactsFragmentToDetailsFragment()
                findNavController().navigate(action.actionId, bundle)
            }
        })
        binding.recyclerView.adapter = adapter
    }

    companion object {
        const val OBJECT_NUMBER = "objectNumber"
        const val LOG_TAG = "SwipeRefresh"
    }
}