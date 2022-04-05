package com.example.rijsmuseum.domain.mappers

import com.example.network.resource.models.CollectionsDetailsResource
import com.example.network.resource.models.CollectionsResource
import com.example.rijsmuseum.domain.models.ArtObject
import com.example.rijsmuseum.domain.models.ListArtObject

fun CollectionsDetailsResource.mapFromResourceObject() : ArtObject {
    return ArtObject(
        title = this.artObject.title,
        description = this.artObject.description,
        url = this.artObject.webImage.url
    )
}

fun CollectionsResource.mapFromResourceListObject() : List<ListArtObject> {
    return this.artObjects.map { resObject ->
        ListArtObject(
            title = resObject.title,
            objectNumber = resObject.objectNumber,
            url = resObject.webImage.url
        )
    }
}