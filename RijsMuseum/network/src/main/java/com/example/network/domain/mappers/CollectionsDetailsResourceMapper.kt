package com.example.network.domain.mappers

import com.example.network.domain.models.ArtObject
import com.example.network.domain.util.ResourceMapper
import com.example.network.resource.models.CollectionsDetailsResource

class CollectionsDetailsResourceMapper : ResourceMapper<CollectionsDetailsResource, ArtObject> {
    override fun mapFromResource(resource: CollectionsDetailsResource): ArtObject {
        return ArtObject(
            title = resource.artObject.title,
            description = resource.artObject.description,
            url = resource.artObject.webImage.url
        )
    }

    fun getResourceObject(resource: CollectionsDetailsResource): ArtObject {
        return mapFromResource(resource)
    }
}