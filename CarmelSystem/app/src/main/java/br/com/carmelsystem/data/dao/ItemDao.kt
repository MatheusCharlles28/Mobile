package br.com.carmelsystem.data.dao

import androidx.room.*
import br.com.carmelsystem.data.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM item ORDER BY descricao ASC")
    fun getAll(): Flow<List<Item>>

    @Query("SELECT * FROM item WHERE codigo = :codigo")
    suspend fun getById(codigo: Int): Item?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item): Long

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)
}
