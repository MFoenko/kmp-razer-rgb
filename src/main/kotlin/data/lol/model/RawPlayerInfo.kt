package data.lol.model

import kotlinx.serialization.Serializable

@Serializable
data class RawPlayerInfo (
    val abilities: Map<String?, RawChampionAbility?>,
    val championStats: RawChampionStats,
    val currentGold: Float?,
//val fullRunes: {...},
    val level: Int?,
    val summonerName: String?,
){

}
