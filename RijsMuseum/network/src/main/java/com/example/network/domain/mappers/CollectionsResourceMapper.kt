package com.example.network.domain.mappers

import com.example.network.domain.models.ListArtObject
import com.example.network.domain.util.ResourceMapper
import com.example.network.resource.models.CollectionsResource

class CollectionsResourceMapper : ResourceMapper<CollectionsResource, List<ListArtObject>> {
    override fun mapFromResource(resource: CollectionsResource): List<ListArtObject> {
        return resource.artObjects.map { resArtObject ->
            ListArtObject(
                title = resArtObject.title,
                url = resArtObject.webImage.url
            )
        }
    }

    fun getResourceList(resource: CollectionsResource): List<ListArtObject> {
        return mapFromResource(resource)
    }
}