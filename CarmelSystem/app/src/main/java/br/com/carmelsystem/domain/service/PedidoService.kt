package br.com.carmelsystem.domain.service

import br.com.carmelsystem.data.model.Endereco
import br.com.carmelsystem.data.model.Item
import br.com.carmelsystem.data.model.ItemPedidoTemp
import br.com.carmelsystem.data.model.PedidoItem
import br.com.carmelsystem.data.model.PedidoVenda
import br.com.carmelsystem.data.repository.PedidoRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PedidoService(private val repository: PedidoRepository) {

    fun calcularSubtotal(itens: List<ItemPedidoTemp>): Double =
        itens.sumOf { it.valorTotal }

    fun calcularFrete(endereco: Endereco?): Double {
        if (endereco == null) return 0.0
        return when {
            endereco.cidade.equals("Toledo", ignoreCase = true) &&
            endereco.uf.equals("PR", ignoreCase = true) -> 0.0
            endereco.uf.equals("PR", ignoreCase = true) -> 20.0
            else -> 50.0
        }
    }

    fun calcularTotal(subtotal: Double, frete: Double, condicao: String): Double {
        val comCondicao = when (condicao) {
            "A_VISTA" -> subtotal * 0.95
            "A_PRAZO" -> subtotal * 1.05
            else -> subtotal
        }
        return comCondicao + frete
    }

    fun calcularValorParcela(subtotal: Double, frete: Double, parcelas: Int): Double {
        if (parcelas <= 0) return 0.0
        return (subtotal * 1.05 + frete) / parcelas
    }

    fun adicionarItem(lista: MutableList<ItemPedidoTemp>, item: Item, quantidade: Double): List<ItemPedidoTemp> {
        val total = item.valorUnit * quantidade
        val existente = lista.indexOfFirst { it.item.codigo == item.codigo }
        return if (existente >= 0) {
            lista[existente] = lista[existente].copy(
                quantidade = lista[existente].quantidade + quantidade,
                valorTotal = lista[existente].valorTotal + total
            )
            lista.toList()
        } else {
            lista + ItemPedidoTemp(item, quantidade, total)
        }
    }

    fun removerItem(lista: List<ItemPedidoTemp>, index: Int): List<ItemPedidoTemp> =
        lista.toMutableList().also { it.removeAt(index) }

    suspend fun gerarNumeroPedido(): String {
        val max = repository.getMaxCodigo() ?: 0
        return "PED${String.format("%05d", max + 1)}"
    }

    suspend fun salvarPedido(
        numeroPedido: String,
        codigoCliente: Int,
        codigoEndereco: Int?,
        condicao: String,
        parcelas: Int,
        itens: List<ItemPedidoTemp>,
        endereco: Endereco?
    ): Result<String> = runCatching {
        val subtotal = calcularSubtotal(itens)
        val frete = calcularFrete(endereco)
        val total = calcularTotal(subtotal, frete, condicao)
        val data = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())

        val pedido = PedidoVenda(
            numeroPedido = numeroPedido,
            codigoCliente = codigoCliente,
            codigoEnderecoEntrega = codigoEndereco,
            condicaoPagamento = condicao,
            numeroParcelas = if (condicao == "A_PRAZO") parcelas else 1,
            valorSubtotal = subtotal,
            valorFrete = frete,
            valorTotal = total,
            dataPedido = data
        )
        val pedidoId = repository.insert(pedido).toInt()
        val pedidoItens = itens.map {
            PedidoItem(
                codigoPedido = pedidoId,
                codigoItem = it.item.codigo,
                descricaoItem = it.item.descricao,
                quantidade = it.quantidade,
                valorUnitario = it.item.valorUnit,
                unidadeMedida = it.item.unidadeMedia,
                valorTotal = it.valorTotal
            )
        }
        repository.insertItens(pedidoItens)
        numeroPedido
    }
}
