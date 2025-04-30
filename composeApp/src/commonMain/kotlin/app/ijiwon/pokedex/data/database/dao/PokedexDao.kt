package app.ijiwon.pokedex.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.ijiwon.pokedex.data.database.model.PokedexEntryEntity

@Dao
interface PokedexDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entries: List<PokedexEntryEntity>)

    @Query("SELECT * FROM pokedex_entry")
    fun getPagingSource(): PagingSource<Int, PokedexEntryEntity>

    @Query("DELETE FROM pokedex_entry")
    suspend fun clear()
}