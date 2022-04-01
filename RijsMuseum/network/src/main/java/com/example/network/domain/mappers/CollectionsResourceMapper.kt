package com.example.network.domain.mappers

import com.example.network.domain.models.ListArtObject
import com.example.network.domain.util.ResourceMapper
import com.example.network.resource.models.CollectionsResource

class CollectionsResourceMapper : ResourceMapper<CollectionsResource, List<ListArtObject>> {
    override fun mapFromResource(resource: CollectionsResource): List<ListArtObject> {
        return listOf(
            ListArtObject(
                //False because of the index element
                title = resource.artObjects[0].title,
                url = resource.artObjects[0].webImage.url
            )
        )
    }

    fun fromResourceList(initial: List<CollectionsResource>): List<ListArtObject> {
        //Same false from the upper comment
        return mapFromResource(initial[0])
    }
}