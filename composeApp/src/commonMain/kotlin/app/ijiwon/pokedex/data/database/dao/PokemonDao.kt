package app.ijiwon.pokedex.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.ijiwon.pokedex.data.database.model.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon WHERE id = :id")
    suspend fun getById(id: Int): PokemonEntity?

    @Query("DELETE FROM pokemon")
    suspend fun clear()
}