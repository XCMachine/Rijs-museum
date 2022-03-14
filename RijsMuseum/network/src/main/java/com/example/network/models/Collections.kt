package com.example.network.models

data class Collections(
    val elapsedMilliseconds: Int,
    val count: Int,
    val artObjects: List<ArtObject>
    ) {
    data class ArtObject(
        /**
         * Attributes as variables
         */
        val links: Links,

        val id: String?,
        val objectNumber: String?,
        val title: String?,
        val hasImage: Boolean,
        val principalOrFirstMaker: String?,
        val longTitle: String?,
        val showImage: Boolean,
        val permitDownload: Boolean,

        val webImage: WebImage,
        val headerImage: HeaderImage,

        val productionPlaces: List<String> = emptyList()
    ) {
        /**
         * Classes
         */
        data class Links(
            val self: String? = null,
            val web: String? = null
        )

        data class WebImage(
            val guid: String,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String
        )

        data class HeaderImage(
            val guid: String,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String
        )
    }
}