package br.com.carmelsystem.data.dao

import androidx.room.*
import br.com.carmelsystem.data.model.Cliente
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Query("SELECT * FROM cliente ORDER BY nome ASC")
    fun getAll(): Flow<List<Cliente>>

    @Query("SELECT * FROM cliente WHERE codigo = :codigo")
    suspend fun getById(codigo: Int): Cliente?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cliente: Cliente): Long

    @Update
    suspend fun update(cliente: Cliente)

    @Delete
    suspend fun delete(cliente: Cliente)
}
