package app.ijiwon.pokedex.model.wip

import kotlinx.datetime.Instant
import kotlin.uuid.Uuid

data class News(
    val id: String = Uuid.random().toString(),
    val category: NewsCategory,
    val title: String,
    val subtitle: String,
    val body: String,
    val publishedAt: Instant,
)