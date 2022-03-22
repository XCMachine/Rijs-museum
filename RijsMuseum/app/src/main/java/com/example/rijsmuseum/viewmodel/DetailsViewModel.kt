package com.example.rijsmuseum.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.network.getters.CollectionsDetailsGetter
import com.example.network.models.Collections
import com.example.rijsmuseum.adapter.RecyclerAdapter
import com.example.rijsmuseum.fragments.DetailsFragment

class DetailsViewModel: ViewModel(), RecyclerAdapter.OnItemClickListener {
    private var bundle = Bundle()
    private var detailsFrag = DetailsFragment()

    fun getCollectionsDetailsRequest(
        data: CollectionsDetailsGetter.DataReadyCallback,
        objectNumber: String
    ) {
        CollectionsDetailsGetter().getCollectionsDetailsRequest(data, objectNumber)
    }

    override fun onItemClick(cList: Collections.ArtObject) {
        setBundleString(bundle, detailsFrag, cList)
    }

    fun setBundleString(
        bundle: Bundle,
        detailsFragment: DetailsFragment,
        cList: Collections.ArtObject
    ) {
        this.bundle = bundle
        bundle.putString(TEXT_KEY_OBJECT_NUMBER, cList.objectNumber)

        setFragmentArgument(detailsFragment, bundle)
    }

    private fun setFragmentArgument(detailsFragment: DetailsFragment, bundle: Bundle) {
        this.detailsFrag = detailsFragment
        detailsFragment.arguments = bundle
    }

    companion object {
        private const val TEXT_KEY_OBJECT_NUMBER = "objectNumber"
    }
}