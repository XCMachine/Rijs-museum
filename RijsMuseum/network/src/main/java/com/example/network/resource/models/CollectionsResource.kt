package com.example.network.resource.models

data class CollectionsResource(
    val elapsedMilliseconds: Int,
    val count: Int,
    val artObjects: List<ArtObjectResource>
    ) {
    data class ArtObjectResource(
        /**
         * Attributes as variables
         */
        val links: LinksResource,

        val id: String,
        val objectNumber: String,
        val title: String,
        val hasImage: Boolean,
        val principalOrFirstMaker: String,
        val longTitle: String,
        val showImage: Boolean,
        val permitDownload: Boolean,

        val webImage: WebImageResource,
        val headerImage: HeaderImageResource,

        val productionPlaces: List<String> = emptyList()
    ) {
        data class LinksResource(
            val self: String,
            val web: String
        )

        data class WebImageResource(
            val guid: String,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String
        )

        data class HeaderImageResource(
            val guid: String,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String
        )
    }
}