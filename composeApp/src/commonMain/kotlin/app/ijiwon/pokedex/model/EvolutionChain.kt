package app.ijiwon.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class EvolutionChain(
    val id: Int,
    private val pokemons: List<Node>
) : Iterable<EvolutionChain.Node> {

    @Serializable
    data class Node(
        val id: Int,
        val name: String,
        val artworkUrl: String,
        val types: List<PokemonType>,
        val evolvesFrom: Int?,
        val trigger: EvolutionTrigger?,
    )

    private val byEvolvesFrom = pokemons.associateBy { it.evolvesFrom }

    override fun iterator(): Iterator<Node> = object : Iterator<Node> {
        private var id: Int? = null

        override fun hasNext(): Boolean = (byEvolvesFrom[id] != null)

        override fun next(): Node {
            val next = byEvolvesFrom[id] ?: throw NoSuchElementException()

            id = next.id

            return next
        }
    }
}

@Serializable
data class EvolutionTrigger(
    val minAffection: Int? = null,
    val minBeauty: Int? = null,
    val minHappiness: Int? = null,
    val minLevel: Int? = null,
    val itemName: String? = null,
)