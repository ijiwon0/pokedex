package app.ijiwon.pokedex.data.network.pokeapi.model

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Berries are small fruits that can provide HP and status condition restoration,
 * stat enhancement, and even damage negation when eaten by Pokémon.
 */
@Serializable
data class Berry(
    val id: Int,
    val name: String,
    @SerialName("growth_time")
    val growthTime: Int,
    @SerialName("max_harvest")
    val maxHarvest: Int,
    @SerialName("natural_gift_power")
    val naturalGiftPower: Int,
    val size: Int,
    val smoothness: Int,
    @SerialName("soil_dryness")
    val soilDryness: Int,
    val firmness: NamedApiResource,
    val flavors: List<FlavorBerryMap>,
    val item: NamedApiResource,
    @SerialName("natural_gift_type")
    val naturalGiftType: NamedApiResource,
)

@Serializable
data class FlavorBerryMap(
    val potency: Int,
    val berry: NamedApiResource,
)

/**
 * Berries can be soft or hard.
 */
@Serializable
data class BerryFirmness(
    val id: Int,
    val name: String,
    val berries: List<NamedApiResource>,
    val names: List<Name>,
)

/**
 * Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on their nature.
 */
@Serializable
data class BerryFlavor(
    val id: Int,
    val name: String,
    val berries: List<FlavorBerryMap>,
    val contestType: NamedApiResource,
    val names: List<Name>,
)