package app.ijiwon.pokedex.data.network.pokeapi.model.pokemon

import app.ijiwon.pokedex.data.network.pokeapi.model.common.Name
import app.ijiwon.pokedex.data.network.pokeapi.model.common.NamedApiResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokeathlonStat(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("affecting_natures") val affectingNatures: NaturePokeathlonStatAffectSets,
)

@Serializable
data class NaturePokeathlonStatAffectSets(
    val increase: List<NaturePokeathlonStatAffect>,
    val decrease: List<NaturePokeathlonStatAffect>,
)

@Serializable
data class NaturePokeathlonStatAffect(
    @SerialName("max_change") val maxChange: Int,
    val nature: NamedApiResource,
)
