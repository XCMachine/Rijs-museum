package com.example.rijsmuseum

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections
import com.example.rijsmuseum.adapter.RecyclerAdapter
import com.example.rijsmuseum.databinding.ActivityMainBinding
import com.example.rijsmuseum.fragments.DetailsFragment
import com.example.rijsmuseum.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        adapterSettings()

        //Button to get the list of artifacts
        binding.getButton.setOnClickListener {
            viewModel.getCollectionsRequest(object : CollectionsGetter.DataReadyCallback {
                override fun onDataReady(data: List<Collections.ArtObject>) {
                    adapter.updateCollectionsData(data)
                }
            })
        }
    }

    private fun adapterSettings() {
        adapter = RecyclerAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        adapter.setOnItemClickListener(this)
    }

    override fun onItemClick(cList: Collections.ArtObject) {
        supportFragmentManager.beginTransaction().apply {

            val detailsFragment = DetailsFragment().also { detailsFragment ->
                val bundle = Bundle()
                bundle.putString(OBJECT_NUMBER, cList.objectNumber)
                detailsFragment.arguments = bundle
            }

            //Opens the fragment FrameLayout window
            binding.flFragmentDetails.visibility = View.VISIBLE
            replace(R.id.flFragmentDetails, detailsFragment)
            commit()
        }
    }

    companion object {
        const val OBJECT_NUMBER = "objectNumber"
    }
}