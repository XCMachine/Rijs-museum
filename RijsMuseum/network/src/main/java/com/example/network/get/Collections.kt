package com.example.network.get

data class Collections(
    val elapsedMilliseconds: Int,
    val count: Int,
    val artObjects: List<ArtObject>
    ) {
    data class ArtObject(
        /**
         * Attributes as variables
         */
        val id: String?,
        val objectNumber: String?,
        val title: String?,
        val hasImage: Boolean,
        val principalOrFirstMaker: String?,
        val longTitle: String?,
        val showImage: Boolean,
        val permitDownload: Boolean,
        val productionPlaces: List<String> = emptyList()
    ) {
        /**
         * Classes
         */
        data class Links(
            val self: String? = null,
            val web: String? = null
        )

        data class webImage(
            val guid: String,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String
        )

        data class headerImage(
            val guid: String,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String
        )
    }

    /*Example for a List,arrayList or Array of data class
    var principalMakers: List<PrincipalMaker>

    data class PrincipalMaker(

    )
     */
}