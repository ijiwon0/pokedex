package app.ijiwon.pokedex.model

import kotlin.uuid.Uuid

data class NewsCategory(
    val id: String = Uuid.random().toString(),
    val name: String,
)