package data.lol.model

import kotlinx.serialization.Serializable

@Serializable
data class RawChampionAbility(
    val abilityLevel: Int?,
    val displayName: String?,
    val id: String?,
    val rawDescription: String?,
    val rawDisplayName: String?
)