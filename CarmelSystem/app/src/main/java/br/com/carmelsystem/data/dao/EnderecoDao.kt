package br.com.carmelsystem.data.dao

import androidx.room.*
import br.com.carmelsystem.data.model.Endereco
import kotlinx.coroutines.flow.Flow

@Dao
interface EnderecoDao {
    @Query("SELECT * FROM endereco ORDER BY cidade ASC")
    fun getAll(): Flow<List<Endereco>>

    @Query("SELECT * FROM endereco WHERE codigo = :codigo")
    suspend fun getById(codigo: Int): Endereco?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(endereco: Endereco): Long

    @Update
    suspend fun update(endereco: Endereco)

    @Delete
    suspend fun delete(endereco: Endereco)
}
