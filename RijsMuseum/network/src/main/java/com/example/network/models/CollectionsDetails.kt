package com.example.network.models

data class CollectionsDetails(
    val elapsedMilliseconds: Int,
    val artObject: ArtObject
) {

    data class ArtObject(
        val links: Links,

        val id: String?,
        val priref: String?,
        val objectNumber: String?,
        val language: String?,
        val title: String?,
        //copyrightHolder = null

        val webImage: WebImage,

        val colors: List<Colors>,
        val colorsWithNormalization: List<ColorsWithNormal>,
        val normalizedColors: List<NormalColors>,
        val normalized32Colors: List<Normal32Colors>,

        val titles: String?,
        val description: String?,
        //labelText = null
        val objectTypes: List<String> = emptyList(),
        val objectCollection: List<String> = emptyList(),
        val makers: List<String> = emptyList(),

        val principalMakers: List<PrincipalMakers>,

        val plaqueDescriptionDutch: String?,
        val plaqueDescriptionEnglish: String?,
        val principalMaker: String?,
        //artistRole = null
        val associations: List<String> = emptyList(),

        val acquisition: Acquisition,

        val exhibitions: List<String> = emptyList(),
        val materials: List<String> = emptyList(),
        val techniques: List<String> = emptyList(),
        val productionPlaces: List<String> = emptyList(),

        val dating: Dating,

        val classification: Classification,

        val hasImage: Boolean,
        val historicalPersons: List<String> = emptyList(),
        val inscriptions: List<String> = emptyList(),
        val documentation: List<String> = emptyList(),
        val catRefRPK: List<String> = emptyList(),
        val principalOrFirstMaker: String?,
        val dimensions: List<Dimensions>,

        val physicalProperties: List<String> = emptyList(),
        val physicalMedium: String?,
        val longTitle: String?,
        val subTitle: String?,
        val scLabelLine: String?,
        val label: List<Label>,

        val showImage: Boolean,
        val location: String?
    ) {
        data class Links(
            val search: String?
        )

        data class WebImage(
            val guid: String?,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String?
        )

        data class Colors(
            val percentage: Int,
            val hex: String?
        )

        data class ColorsWithNormal(
            val originalHex: String?,
            val normalizeHex: String?
        )

        data class NormalColors(
            val percentage: Int,
            val hex: String?
        )

        data class Normal32Colors(
            val percentage: Int,
            val hex: String?
        )

        data class PrincipalMakers(
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

        data class Acquisition(
            val method: String?,
            val date: String?,
            val creditLine: String?
        )

        data class Dating(
            val presentingDate: String?,
            val sortingDate: Int,
            val period: Int,
            val yearEarly: Int,
            val yearLate: Int
        )

        data class Classification(
            val iconClassIdentifier: List<String> = emptyList()
        )

        data class Dimensions(
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