package app.ijiwon.pokedex.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.ijiwon.pokedex.data.database.model.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon")
    fun pagingSource(): PagingSource<Int, PokemonEntity>

    @Query("DELETE FROM pokemon")
    suspend fun clear()
}