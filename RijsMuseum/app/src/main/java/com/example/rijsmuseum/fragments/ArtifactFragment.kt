package com.example.rijsmuseum.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.network.models.Collections
import com.example.rijsmuseum.R
import com.example.rijsmuseum.adapter.RecyclerAdapter
import com.example.rijsmuseum.databinding.FragmentArtifactBinding
import com.example.rijsmuseum.viewmodel.ArtifactViewModel

class ArtifactFragment : Fragment(), RecyclerAdapter.OnItemClickListener {
    private lateinit var artifactViewModel: ArtifactViewModel
    private lateinit var binding: FragmentArtifactBinding

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artifactViewModel = ViewModelProvider(this).get(ArtifactViewModel::class.java)
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

        artifactViewModel.cList.observe(viewLifecycleOwner) { listArtObjects ->
            adapter.updateCollectionsData(listArtObjects)
        }
        artifactViewModel.getCollectionsRequest()
    }

    private fun getAdapter() {
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
        adapter.setOnItemClickListener(this)
    }

    override fun onItemClick(cList: Collections.ArtObject) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            val detailsFragment = DetailsFragment().also { detailsFragment ->
                val bundle = Bundle()
                bundle.putString(OBJECT_NUMBER, cList.objectNumber)
                detailsFragment.arguments = bundle
            }
            replace(R.id.fragmentContainerView, detailsFragment)
            addToBackStack(ArtifactFragment::class.java.name)
            commit()
        }
    }

    companion object {
        const val OBJECT_NUMBER = "objectNumber"
    }
}