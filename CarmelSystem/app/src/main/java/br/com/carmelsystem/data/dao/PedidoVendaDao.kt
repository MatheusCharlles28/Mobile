package br.com.carmelsystem.data.dao

import androidx.room.*
import br.com.carmelsystem.data.model.PedidoItem
import br.com.carmelsystem.data.model.PedidoVenda
import kotlinx.coroutines.flow.Flow

@Dao
interface PedidoVendaDao {
    @Query("SELECT * FROM pedido_venda ORDER BY codigo DESC")
    fun getAll(): Flow<List<PedidoVenda>>

    @Query("SELECT COALESCE(MAX(codigo), 0) FROM pedido_venda")
    suspend fun getMaxCodigo(): Int?

    @Query("SELECT * FROM pedido_venda WHERE numeroPedido = :numero")
    suspend fun getByNumeroPedido(numero: String): PedidoVenda?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pedido: PedidoVenda): Long

    @Update
    suspend fun update(pedido: PedidoVenda)

    @Delete
    suspend fun delete(pedido: PedidoVenda)
}

@Dao
interface PedidoItemDao {
    @Query("SELECT * FROM pedido_item WHERE codigoPedido = :codigoPedido")
    suspend fun getItensByPedidoSync(codigoPedido: Int): List<PedidoItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(itens: List<PedidoItem>)
}
