package data.lol.model

import kotlinx.serialization.Serializable

@Serializable
data class RawChampionStats(
    val abilityHaste: Float?,
    val abilityPower: Float?,
    val armor: Float?,
    val armorPenetrationFlat: Float?,
    val armorPenetrationPercent: Float?,
    val attackDamage: Float?,
    val attackRange: Float?,
    val attackSpeed: Float?,
    val bonusArmorPenetrationPercent: Float?,
    val bonusMagicPenetrationPercent: Float?,
    val cooldownReduction: Float?,
    val critChance: Float?,
    val critDamage: Float?,
    val currentHealth: Float?,
    val healthRegenRate: Float?,
    val lifeSteal: Float?,
    val magicLethality: Float?,
    val magicPenetrationFlat: Float?,
    val magicPenetrationPercent: Float?,
    val magicResist: Float?,
    val maxHealth: Float?,
    val moveSpeed: Float?,
    val physicalLethality: Float?,
    val resourceMax: Float?,
    val resourceRegenRate: Float?,
    val resourceType: String,
    val resourceValue: Float?,
    val spellVamp: Float?,
    val tenacity: Float?,
)