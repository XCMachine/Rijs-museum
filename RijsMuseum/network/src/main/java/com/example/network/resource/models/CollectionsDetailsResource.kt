package com.example.network.resource.models

data class CollectionsDetailsResource(
    val elapsedMilliseconds: Int,
    val artObject: ArtObjectResource
) {

    data class ArtObjectResource(
        val links: LinksResource,

        val id: String,
        val priref: String,
        val objectNumber: String,
        val language: String,
        val title: String,
        //copyrightHolder = null

        val webImage: WebImageResource,

        val colors: List<ColorsResource>,
        val colorsWithNormalization: List<ColorsWithNormalResource>,
        val normalizedColors: List<NormalColorsResource>,
        val normalized32Color: List<Normal32ColorsResource>,

        val titles: List<String>,
        val description: String,
        //labelText = null
        val objectTypes: List<String> = emptyList(),
        val objectCollection: List<String> = emptyList(),
        val makers: List<MakersResource>,

        val principalMakers: List<PrincipalMakersResource>,

        val plaqueDescriptionDutch: String,
        val plaqueDescriptionEnglish: String,
        val principalMaker: String,
        //artistRole = null
        val associations: List<String> = emptyList(),

        val acquisition: AcquisitionResource,

        val exhibitions: List<String> = emptyList(),
        val materials: List<String> = emptyList(),
        val techniques: List<String> = emptyList(),
        val productionPlaces: List<String> = emptyList(),

        val dating: DatingResource,

        val classification: ClassificationResource,

        val hasImage: Boolean,
        val historicalPersons: List<String> = emptyList(),
        val inscriptions: List<String> = emptyList(),
        val documentation: List<String> = emptyList(),
        val catRefRPK: List<String> = emptyList(),
        val principalOrFirstMaker: String,
        val dimensions: List<DimensionsResource>,

        val physicalProperties: List<String> = emptyList(),
        val physicalMedium: String,
        val longTitle: String,
        val subTitle: String,
        val scLabelLine: String,
        val label: LabelResource,

        val showImage: Boolean,
        val location: String
    ) {
        data class LinksResource(
            val search: String
        )

        data class WebImageResource(
            val guid: String,
            val offsetPercentageX: Int,
            val offsetPercentageY: Int,
            val width: Int,
            val height: Int,
            val url: String
        )

        data class ColorsResource(
            val percentage: Int,
            val hex: String
        )

        data class ColorsWithNormalResource(
            val originalHex: String,
            val normalizeHex: String
        )

        data class NormalColorsResource(
            val percentage: Int,
            val hex: String
        )

        data class Normal32ColorsResource(
            val percentage: Int,
            val hex: String
        )

        data class MakersResource(
            val name:String,
            val unFixedName: String,
            val occupation: List<String> = emptyList(),
            val roles: List<String>,
            val productionPlaces: List<String>,
            val labelDesc: String
        )

        data class PrincipalMakersResource(
            val name: String,
            val unFixedName: String,
            val placeOfBirth: String,
            val dateOfBirth: String,
            //dateOfBirthPrecision = null
            val dateOfDeath: String,
            //dateOfDeathPrecision = null
            val placeOfDeath: String,
            val occupation: List<String> = emptyList(),
            val roles: List<String> = emptyList(),
            val nationality: String,
            //biography = null
            val productionPlaces: List<String> = emptyList()
            //qualification = null
        )

        data class AcquisitionResource(
            val method: String,
            val date: String,
            val creditLine: String
        )

        data class DatingResource(
            val presentingDate: String,
            val sortingDate: Int,
            val period: Int,
            val yearEarly: Int,
            val yearLate: Int
        )

        data class ClassificationResource(
            val iconClassIdentifier: List<String> = emptyList()
        )

        data class DimensionsResource(
            val unit: String,
            val type: String,
            //part = null,
            val value: String
        )

        data class LabelResource(
            val title: String,
            val makerLine: String,
            val description: String,
            val notes: String,
            val date: String
        )
    }
}