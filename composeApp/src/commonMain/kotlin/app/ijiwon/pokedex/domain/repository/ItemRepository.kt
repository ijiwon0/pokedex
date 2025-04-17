package app.ijiwon.pokedex.domain.repository

import androidx.paging.PagingData
import app.ijiwon.pokedex.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getAllItems(): Flow<PagingData<Item>>

    suspend fun getItem(identifier: String): Item
}