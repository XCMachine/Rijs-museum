package com.example.rijsmuseum

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rijsmuseum.adapter.RecyclerAdapter
import com.example.rijsmuseum.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {
    private lateinit var getRequestButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerAdapter

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getRequestButton = findViewById(R.id.getRequestButton)

        recyclerView = findViewById(R.id.listItems)
        recyclerView.hasFixedSize()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel?.let { mainModel ->
            getRequestButton.setOnClickListener {
                mainModel.getCollectionsRequest()
            }
        }

        adapter = RecyclerAdapter(viewModel!!.exampleList!!, this)
        recyclerView.adapter = adapter
    }

    //This is for selected artifact.
    override fun onItemClick(position: Int) {
        viewModel?.let {
            //not used yet
            val clickedItem = it.exampleList!![position]
        }
    }
}