package com.example.rijsmuseum

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.rijsmuseum.databinding.ActivityMainBinding
import com.example.rijsmuseum.fragments.ArtifactFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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