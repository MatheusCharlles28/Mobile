package br.com.carmelsystem.data.repository

import br.com.carmelsystem.data.dao.EnderecoDao
import br.com.carmelsystem.data.model.Endereco
import kotlinx.coroutines.flow.Flow

class EnderecoRepository(private val dao: EnderecoDao) {
    fun getAll(): Flow<List<Endereco>> = dao.getAll()
    suspend fun getById(id: Int): Endereco? = dao.getById(id)
    suspend fun insert(endereco: Endereco): Long = dao.insert(endereco)
    suspend fun update(endereco: Endereco) = dao.update(endereco)
    suspend fun delete(endereco: Endereco) = dao.delete(endereco)
}
