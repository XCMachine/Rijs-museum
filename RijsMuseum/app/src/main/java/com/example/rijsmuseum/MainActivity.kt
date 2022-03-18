package com.example.rijsmuseum

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.network.getters.CollectionsGetter
import com.example.network.models.Collections
import com.example.network.models.CollectionsDetails
import com.example.rijsmuseum.adapter.RecyclerAdapter
import com.example.rijsmuseum.fragments.CollectionsDetailsFragment
import com.example.rijsmuseum.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {
    private lateinit var getRequestButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var flFragment: FrameLayout

    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        flFragment = findViewById(R.id.flFragmentDetails)

        adapterSettings()

        //Button to get the list of artifacts
        getRequestButton = findViewById(R.id.getButton)
        getRequestButton.setOnClickListener {
            viewModel.getCollectionsRequest(object : CollectionsGetter.DataReadyCallback {
                override fun onDataReady(data: List<Collections.ArtObject>) {
                    adapter.updateCollectionsData(data)
                }
            })
        }
    }

    private fun adapterSettings() {
        adapter = RecyclerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(this)
    }

    override fun onItemClick(cDetailsArtObject: CollectionsDetails.ArtObject, position: Int) {
        supportFragmentManager.beginTransaction().apply {
            //Opens the fragment FrameLayout window
            flFragment.visibility = View.VISIBLE
            replace(R.id.flFragmentDetails, CollectionsDetailsFragment())
            commit()
        }
    }
}