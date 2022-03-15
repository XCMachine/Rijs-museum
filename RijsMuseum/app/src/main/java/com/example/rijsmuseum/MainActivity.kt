package com.example.rijsmuseum

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rijsmuseum.adapter.RecyclerAdapter
import com.example.rijsmuseum.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {
    private lateinit var getRequestButton: Button
    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getRequestButton = findViewById(R.id.getRequestButton)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView = findViewById(R.id.listItems)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this)

        //THIS NEEDS TO BE IN THE GETTER CLASS
        adapter = RecyclerAdapter(viewModel.exampleList, this)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(this)
        viewModel.getCollectionsRequest()
    }

    //This is for selected artifact.
    override fun onItemClick(position: Int) {
        viewModel.let {
            //not used yet
            //val clickedItem = it.exampleList!![position]
        }
    }
}