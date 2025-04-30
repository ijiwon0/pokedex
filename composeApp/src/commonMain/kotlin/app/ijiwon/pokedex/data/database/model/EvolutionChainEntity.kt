package app.ijiwon.pokedex.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.ijiwon.pokedex.model.EvolutionChain

@Entity(tableName = "evolution_chain")
data class EvolutionChainEntity(
    @PrimaryKey val id: Int,
    val pokemons: List<EvolutionChain.Node>,
)