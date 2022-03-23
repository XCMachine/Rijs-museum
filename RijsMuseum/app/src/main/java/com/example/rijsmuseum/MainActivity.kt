package com.example.rijsmuseum

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rijsmuseum.databinding.ActivityMainBinding
import com.example.rijsmuseum.fragments.ArtifactFragment
import com.example.rijsmuseum.viewmodel.ArtifactViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ArtifactViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ArtifactViewModel::class.java)

        //Button to get the list of artifacts
        binding.getButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                binding.fragmentContainerView.visibility = View.VISIBLE
                add(R.id.fragmentContainerView, ArtifactFragment())
                commit()
            }
        }
    }
}