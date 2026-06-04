package br.com.carmelsystem.data.repository

import br.com.carmelsystem.data.dao.PedidoItemDao
import br.com.carmelsystem.data.dao.PedidoVendaDao
import br.com.carmelsystem.data.model.PedidoItem
import br.com.carmelsystem.data.model.PedidoVenda
import kotlinx.coroutines.flow.Flow

class PedidoRepository(
    private val pedidoDao: PedidoVendaDao,
    private val pedidoItemDao: PedidoItemDao
) {
    fun getAll(): Flow<List<PedidoVenda>> = pedidoDao.getAll()
    suspend fun getMaxCodigo(): Int? = pedidoDao.getMaxCodigo()
    suspend fun getByNumeroPedido(numero: String): PedidoVenda? = pedidoDao.getByNumeroPedido(numero)
    suspend fun insert(pedido: PedidoVenda): Long = pedidoDao.insert(pedido)
    suspend fun insertItens(itens: List<PedidoItem>) = pedidoItemDao.insertAll(itens)
    suspend fun getItensByPedido(codigoPedido: Int): List<PedidoItem> = pedidoItemDao.getItensByPedidoSync(codigoPedido)
}
