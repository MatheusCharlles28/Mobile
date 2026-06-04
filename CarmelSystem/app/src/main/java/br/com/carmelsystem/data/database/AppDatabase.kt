package br.com.carmelsystem.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.carmelsystem.data.dao.*
import br.com.carmelsystem.data.model.*

@Database(
    entities = [Endereco::class, Cliente::class, Item::class, PedidoVenda::class, PedidoItem::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun enderecoDao(): EnderecoDao
    abstract fun clienteDao(): ClienteDao
    abstract fun itemDao(): ItemDao
    abstract fun pedidoVendaDao(): PedidoVendaDao
    abstract fun pedidoItemDao(): PedidoItemDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "carmel_system_db")
                    .build()
                    .also { INSTANCE = it }
            }
    }
}
