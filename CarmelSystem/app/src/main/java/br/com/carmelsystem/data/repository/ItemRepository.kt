package br.com.carmelsystem.data.repository

import br.com.carmelsystem.data.dao.ItemDao
import br.com.carmelsystem.data.model.Item
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val dao: ItemDao) {
    fun getAll(): Flow<List<Item>> = dao.getAll()
    suspend fun getById(id: Int): Item? = dao.getById(id)
    suspend fun insert(item: Item): Long = dao.insert(item)
    suspend fun update(item: Item) = dao.update(item)
    suspend fun delete(item: Item) = dao.delete(item)
}
