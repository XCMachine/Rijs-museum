package com.example.network.get

data class CollectionsDetails(
    val elapsedMilliseconds: Int,
) {
    data class artObject(
        val id: String?,
        val priref: String?,
        val objectNumber: String?,
        val language: String?,
        val title: String?,
        //copyrightHolder = null

        val colors: List<color>,
        val colorsWithNormalization: List<colorsWithNormal>,
        val normalizedColors: List<normalColors>,
        val normalized32Colors: List<normal32Colors>,

        val titles: String?,
        val descriptions: String?,
        //labelText = null
        val objectTypes: List<String> = emptyList(),
        val objectCollection: List<String> = emptyList(),
        val makers: List<String> = emptyList(),

        val principalMakers: List<principalMake>,

        val plaqueDescriptionDutch: String?,
        val plaqueDescriptionEnglish: String?,
        val principalMaker: String?,
        //artistRole = null
        val associations: List<String> = emptyList(),

        val exhibitions: List<String> = emptyList(),
        val materials: List<String> = emptyList(),
        val techniques: List<String> = emptyList(),
        val productionPlaces: List<String> = emptyList(),

        val hasImage: Boolean,
        val historicalPersons: List<String> = emptyList(),
        val inscriptions: List<String> = emptyList(),
        val documentation: List<String> = emptyList(),
        val catRefRPK: List<String> = emptyList(),
        val principalOrFirstMaker: String?,
        val dimensions: List<Dimension>,

        val physicalProperties: List<String> = emptyList(),
        val physicalMedium: String?,
        val longTitle: String?,
        val subTitle: String?,
        val scLabelLine: String?,
        val label: List<Label>,

        val showImage: Boolean,
        val location: String?
    ) {
        data class links(
            val search: String?
        )

        data class webImage(
            val guid: String?,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String?
        )

        data class color(
            val percentage: Int,
            val hex: String?
        )

        data class colorsWithNormal(
            val originalHex: String?,
            val normalizeHex: String?
        )

        data class normalColors(
            val percentage: Int,
            val hex: String?
        )

        data class normal32Colors(
            val percentage: Int,
            val hex: String?
        )

        data class principalMake(
            val name: String?,
            val unFixedName: String?,
            val placeOfBirth: String?,
            val dateOfBirth: String?,
            //dateOfBirthPrecision = null
            val dateOfDeath: String?,
            //dateOfDeathPrecision = null
            val placeOfDeath: String?,
            val occupation: List<String> = emptyList(),
            val roles: List<String> = emptyList(),
            val nationality: String?,
            //biography = null
            val productionPlaces: List<String> = emptyList()
            //qualification = null
        )

        data class acquisition(
            val method: String?,
            val date: String?,
            val creditLine: String?
        )

        data class dating(
            val presentingDate: String?,
            val sortingDate: Int,
            val period: Int,
            val yearEarly: Int,
            val yearLate: Int
        )

        data class classification(
            val iconClassIdentifier: List<String> = emptyList()
        )

        data class Dimension(
            val unit: String?,
            val type: String?,
            //part = null,
            val value: String?
        )

        data class Label(
            val title: String?,
            val makerLine: String?,
            val description: String?,
            val notes: String?,
            val date: String?
        )
    }
}