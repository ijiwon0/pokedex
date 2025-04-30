package app.ijiwon.pokedex.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.ijiwon.pokedex.data.database.model.EvolutionChainEntity

@Dao
interface EvolutionChainDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(evolutionChain: EvolutionChainEntity)

    @Query("SELECT * FROM evolution_chain WHERE id = :id")
    suspend fun getById(id: Int): EvolutionChainEntity?
}