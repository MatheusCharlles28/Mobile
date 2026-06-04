package br.com.carmelsystem.data.repository

import br.com.carmelsystem.data.dao.ClienteDao
import br.com.carmelsystem.data.model.Cliente
import kotlinx.coroutines.flow.Flow

class ClienteRepository(private val dao: ClienteDao) {
    fun getAll(): Flow<List<Cliente>> = dao.getAll()
    suspend fun getById(id: Int): Cliente? = dao.getById(id)
    suspend fun insert(cliente: Cliente): Long = dao.insert(cliente)
    suspend fun update(cliente: Cliente) = dao.update(cliente)
    suspend fun delete(cliente: Cliente) = dao.delete(cliente)
}
