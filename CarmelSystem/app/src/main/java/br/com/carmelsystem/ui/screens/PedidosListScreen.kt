package br.com.carmelsystem.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.carmelsystem.data.model.PedidoItem
import br.com.carmelsystem.data.model.PedidoVenda
import br.com.carmelsystem.ui.components.*
import br.com.carmelsystem.ui.theme.*
import br.com.carmelsystem.viewmodel.AppViewModel
import java.text.NumberFormat
import java.util.Locale

@Composable
fun PedidosListScreen(viewModel: AppViewModel, onBack: () -> Unit) {
    val pedidos             by viewModel.pedidos.collectAsState()
    val clientes            by viewModel.clientes.collectAsState()
    val enderecos           by viewModel.enderecos.collectAsState()
    val pedidoCarregado     by viewModel.pedidoCarregado.collectAsState()
    val itensPedidoCarregado by viewModel.itensPedidoCarregado.collectAsState()
    var busca by remember { mutableStateOf("") }
    val fmt = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    Scaffold(topBar = { XpTopAppBar("Consulta de Pedidos", onBack) }) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(XpGrayLight).padding(padding).padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                XpWindow {
                    XpGroupBox("Buscar Pedido") {
                        Row(verticalAlignment=Alignment.Bottom, horizontalArrangement=Arrangement.spacedBy(8.dp)) {
                            XpTextField(busca, { busca=it }, "Número do Pedido (ex: PED00001)", modifier=Modifier.weight(1f))
                            XpPrimaryButton(
                                text = "Buscar",
                                onClick = { if (busca.isNotBlank()) viewModel.buscarPedidoPorNumero(busca) },
                                modifier = Modifier.height(56.dp).padding(top=4.dp)
                            )
                        }
                    }
                }
            }

            pedidoCarregado?.let { pedido ->
                item {
                    XpWindow {
                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween, verticalAlignment=Alignment.CenterVertically) {
                            Text("Pedido Encontrado", fontWeight=FontWeight.Bold, color=XpBlue, fontSize=13.sp)
                            IconButton(onClick={ viewModel.limparPedidoCarregado(); busca="" }) {
                                Icon(Icons.Default.Close, null, tint=XpGrayDark)
                            }
                        }
                        Divider(modifier=Modifier.padding(vertical=4.dp), color=XpBorder)
                        XpPedidoDetalhe(pedido, clientes, enderecos, itensPedidoCarregado, fmt)
                    }
                }
            }

            item { Text("Todos os Pedidos (${pedidos.size})", fontSize=12.sp, fontWeight=FontWeight.Bold, color=XpText) }

            items(pedidos) { pedido ->
                val cliente = clientes.find { it.codigo == pedido.codigoCliente }
                XpWindow {
                    Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween, verticalAlignment=Alignment.CenterVertically) {
                        Column(modifier=Modifier.weight(1f)) {
                            Row(verticalAlignment=Alignment.CenterVertically, horizontalArrangement=Arrangement.spacedBy(6.dp)) {
                                Text(pedido.numeroPedido, fontWeight=FontWeight.Bold, fontSize=13.sp, color=XpBlue)
                                XpStatusBadge(
                                    text = if (pedido.condicaoPagamento=="A_VISTA") "À Vista" else "À Prazo",
                                    color = if (pedido.condicaoPagamento=="A_VISTA") XpGreen else XpBlue
                                )
                            }
                            Text(cliente?.nome ?: "Cliente não encontrado", fontSize=12.sp, color=XpGrayDark)
                            Text(pedido.dataPedido, fontSize=10.sp, color=XpBorder)
                        }
                        Column(horizontalAlignment=Alignment.End) {
                            Text(fmt.format(pedido.valorTotal), fontWeight=FontWeight.Bold, color=XpGreen, fontSize=13.sp)
                            if (pedido.valorFrete > 0) Text("+ frete: ${fmt.format(pedido.valorFrete)}", fontSize=10.sp, color=XpGrayDark)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun XpPedidoDetalhe(
    pedido: PedidoVenda,
    clientes: List<br.com.carmelsystem.data.model.Cliente>,
    enderecos: List<br.com.carmelsystem.data.model.Endereco>,
    itens: List<PedidoItem>,
    fmt: NumberFormat
) {
    val cliente  = clientes.find { it.codigo == pedido.codigoCliente }
    val endereco = enderecos.find { it.codigo == pedido.codigoEnderecoEntrega }

    Column(verticalArrangement=Arrangement.spacedBy(4.dp)) {
        XpInfoRow("Pedido:", pedido.numeroPedido)
        XpInfoRow("Data:", pedido.dataPedido)
        XpInfoRow("Cliente:", cliente?.nome ?: "-")
        XpInfoRow("Pagamento:", if (pedido.condicaoPagamento=="A_VISTA") "À Vista" else "À Prazo - ${pedido.numeroParcelas}x")
        if (endereco!=null) XpInfoRow("Entrega:", endereco.enderecoCompleto())
        Spacer(Modifier.height(6.dp))
        Text("Itens:", fontWeight=FontWeight.SemiBold, color=XpBlue, fontSize=12.sp)
        itens.forEach { item ->
            Row(
                modifier=Modifier.fillMaxWidth()
                    .background(XpGrayLight, RoundedCornerShape(3.dp))
                    .border(1.dp, XpBorder, RoundedCornerShape(3.dp))
                    .padding(8.dp),
                horizontalArrangement=Arrangement.SpaceBetween
            ) {
                Column(modifier=Modifier.weight(1f)) {
                    Text(item.descricaoItem, fontSize=12.sp, fontWeight=FontWeight.Medium, color=XpText)
                    Text("${item.quantidade} ${item.unidadeMedida} × ${fmt.format(item.valorUnitario)}", fontSize=11.sp, color=XpGrayDark)
                }
                Text(fmt.format(item.valorTotal), fontWeight=FontWeight.Bold, color=XpGreen, fontSize=12.sp)
            }
            Spacer(Modifier.height(3.dp))
        }
        Divider(color=XpBorder)
        XpInfoRow("Subtotal:", fmt.format(pedido.valorSubtotal))
        if (pedido.valorFrete > 0) XpInfoRow("Frete:", fmt.format(pedido.valorFrete))
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween) {
            Text("TOTAL:", fontWeight=FontWeight.Bold, fontSize=13.sp, color=XpText)
            Text(fmt.format(pedido.valorTotal), fontWeight=FontWeight.Bold, fontSize=13.sp, color=XpGreen)
        }
    }
}
