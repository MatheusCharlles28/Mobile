package br.com.carmelsystem.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "endereco")
data class Endereco(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,
    val logradouro: String,
    val numero: String,
    val bairro: String,
    val cidade: String,
    val uf: String
) {
    fun enderecoCompleto(): String = "$logradouro, $numero - $bairro, $cidade - $uf"
}

@Entity(
    tableName = "cliente",
    foreignKeys = [
        ForeignKey(
            entity = Endereco::class,
            parentColumns = ["codigo"],
            childColumns = ["codigoEndereco"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("codigoEndereco")]
)
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,
    val nome: String,
    val cpf: String,
    val dataNasc: String,
    val codigoEndereco: Int?
)

@Entity(tableName = "item")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,
    val descricao: String,
    val valorUnit: Double,
    val unidadeMedia: String
)

@Entity(
    tableName = "pedido_venda",
    foreignKeys = [
        ForeignKey(
            entity = Cliente::class,
            parentColumns = ["codigo"],
            childColumns = ["codigoCliente"],
            onDelete = ForeignKey.RESTRICT
        ),
        ForeignKey(
            entity = Endereco::class,
            parentColumns = ["codigo"],
            childColumns = ["codigoEnderecoEntrega"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index("codigoCliente"), Index("codigoEnderecoEntrega")]
)
data class PedidoVenda(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,
    val numeroPedido: String,
    val codigoCliente: Int,
    val codigoEnderecoEntrega: Int?,
    val condicaoPagamento: String,
    val numeroParcelas: Int = 1,
    val valorSubtotal: Double,
    val valorFrete: Double,
    val valorTotal: Double,
    val dataPedido: String
)

@Entity(
    tableName = "pedido_item",
    foreignKeys = [
        ForeignKey(
            entity = PedidoVenda::class,
            parentColumns = ["codigo"],
            childColumns = ["codigoPedido"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["codigo"],
            childColumns = ["codigoItem"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("codigoPedido"), Index("codigoItem")]
)
data class PedidoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val codigoPedido: Int,
    val codigoItem: Int,
    val descricaoItem: String,
    val quantidade: Double,
    val valorUnitario: Double,
    val unidadeMedida: String,
    val valorTotal: Double
)

data class ItemPedidoTemp(
    val item: Item,
    val quantidade: Double,
    val valorTotal: Double
)
