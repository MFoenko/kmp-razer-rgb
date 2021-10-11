package data.lol.model

import kotlinx.serialization.Serializable

@Serializable
data class RawChampionRunes(
    val generalRunes: List<Rune>,
    val keystone: Rune,
    val primaryRuneTree: Rune,
    val secondaryRuneTree: Rune,
    val statRunes: List<StatRune>
)

@Serializable
data class Rune(
    val displayName: String,
    val id: Int,
    val rawDescription: String,
    val rawDisplayName: String
)

@Serializable
data class StatRune(
    val id: Int,
    val rawDescription: String
)