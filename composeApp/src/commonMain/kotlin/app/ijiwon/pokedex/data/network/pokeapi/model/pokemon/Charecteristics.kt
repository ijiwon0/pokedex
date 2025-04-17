package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Description
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Characteristic(
    val id: Int,
    @SerialName("gene_modulo") val geneModulo: Int,
    @SerialName("possible_values") val possibleValues: List<Int>,
    @SerialName("highest_stat") val highestStat: NamedApiResource,
    val descriptions: List<Description>
)