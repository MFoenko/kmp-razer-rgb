package data.lol.model

data class RawChampionRunes(
    val generalRunes: List<Any>,
    val keystone: Keystone,
    val primaryRuneTree: PrimaryRuneTree,
    val secondaryRuneTree: SecondaryRuneTree,
    val statRunes: List<StatRune>
)

data class Keystone(
    val displayName: String,
    val id: Int,
    val rawDescription: String,
    val rawDisplayName: String
)

data class PrimaryRuneTree(
    val displayName: String,
    val id: Int,
    val rawDescription: String,
    val rawDisplayName: String
)

data class SecondaryRuneTree(
    val displayName: String,
    val id: Int,
    val rawDescription: String,
    val rawDisplayName: String
)

data class StatRune(
    val id: Int,
    val rawDescription: String
)