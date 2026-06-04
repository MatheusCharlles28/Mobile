package br.com.carmelsystem.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.carmelsystem.data.model.Endereco
import br.com.carmelsystem.ui.components.*
import br.com.carmelsystem.ui.theme.*
import br.com.carmelsystem.viewmodel.AppViewModel
import java.text.NumberFormat
import java.util.Locale

@Composable
fun PedidoScreen(viewModel: AppViewModel, onBack: () -> Unit) {
    val context        = LocalContext.current
    val clientes       by viewModel.clientes.collectAsState()
    val itens          by viewModel.itens.collectAsState()
    val enderecos      by viewModel.enderecos.collectAsState()
    val itensPedido    by viewModel.itensPedido.collectAsState()
    val numeroPedido   by viewModel.numeroPedido.collectAsState()

    var clienteSel     by remember { mutableStateOf<Int?>(null) }
    var itemSel        by remember { mutableStateOf<Int?>(null) }
    var quantidade     by remember { mutableStateOf("") }
    var condicao       by remember { mutableStateOf("A_VISTA") }
    var parcelas       by remember { mutableStateOf("2") }
    var enderecoEntrega by remember { mutableStateOf<Int?>(null) }

    var showClienteDrop by remember { mutableStateOf(false) }
    var showItemDrop    by remember { mutableStateOf(false) }
    var showEndDrop     by remember { mutableStateOf(false) }
    var erroQtd         by remember { mutableStateOf("") }

    val fmt = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    val subtotal = viewModel.calcularSubtotal()
    val endObj: Endereco? = enderecoEntrega?.let { id -> enderecos.find { it.codigo == id } }
    val frete    = viewModel.calcularFrete(endObj)
    val numParc  = parcelas.toIntOrNull()?.takeIf { it > 0 } ?: 1
    val total    = viewModel.calcularTotal(subtotal, frete, condicao, numParc)
    val vlParc   = viewModel.calcularValorParcela(subtotal, frete, numParc)

    Scaffold(topBar = { XpTopAppBar("Novo Pedido de Venda", onBack) }) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(XpGrayLight).padding(padding).padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                XpWindow {
                    Row(verticalAlignment=Alignment.CenterVertically, horizontalArrangement=Arrangement.SpaceBetween, modifier=Modifier.fillMaxWidth()) {
                        Column {
                            Text("Nº do Pedido", fontSize=11.sp, color=XpGrayDark)
                            Text(numeroPedido, fontSize=20.sp, fontWeight=FontWeight.Bold, color=XpBlue)
                        }
                        XpStatusBadge("NOVO", XpGreen)
                    }
                }
            }

            item {
                XpWindow {
                    XpGroupBox("Cliente") {
                        Box {
                            XpTextField(
                                value = clienteSel?.let { id -> clientes.find { it.codigo==id }?.nome } ?: "Selecione o cliente",
                                onValueChange = {}, label="Cliente", readOnly=true,
                                trailingIcon = { IconButton(onClick={ showClienteDrop=true }) { Icon(Icons.Default.Person, null, tint=XpBlue) } }
                            )
                            DropdownMenu(expanded=showClienteDrop, onDismissRequest={ showClienteDrop=false }) {
                                clientes.forEach { cli ->
                                    DropdownMenuItem(text={ Text(cli.nome, fontSize=13.sp) }, onClick={ clienteSel=cli.codigo; showClienteDrop=false })
                                }
                            }
                        }
                    }
                }
            }

            item {
                XpWindow {
                    XpGroupBox("Endereço de Entrega") {
                        Box {
                            XpTextField(
                                value = endObj?.enderecoCompleto() ?: "Selecione o endereço de entrega",
                                onValueChange={}, label="Endereço de Entrega", readOnly=true,
                                trailingIcon = { IconButton(onClick={ showEndDrop=true }) { Icon(Icons.Default.LocationOn, null, tint=XpBlue) } }
                            )
                            DropdownMenu(expanded=showEndDrop, onDismissRequest={ showEndDrop=false }) {
                                DropdownMenuItem(text={ Text("Sem endereço de entrega", fontSize=13.sp) }, onClick={ enderecoEntrega=null; showEndDrop=false })
                                enderecos.forEach { e ->
                                    DropdownMenuItem(text={ Text(e.enderecoCompleto(), fontSize=12.sp) }, onClick={ enderecoEntrega=e.codigo; showEndDrop=false })
                                }
                            }
                        }
                        if (frete > 0) {
                            Spacer(Modifier.height(4.dp))
                            Text("Frete: ${fmt.format(frete)}", fontSize=11.sp, color=XpGrayDark)
                        } else if (endObj!=null) {
                            Spacer(Modifier.height(4.dp))
                            Text("Frete grátis (Toledo/PR)", fontSize=11.sp, color=XpGreen)
                        }
                    }
                }
            }

            item {
                XpWindow {
                    XpGroupBox("Adicionar Item") {
                        Box {
                            XpTextField(
                                value = itemSel?.let { id -> itens.find { it.codigo==id }?.let { "${it.descricao} (${fmt.format(it.valorUnit)}/${it.unidadeMedia})" } } ?: "Selecione o item",
                                onValueChange={}, label="Item", readOnly=true,
                                trailingIcon = { IconButton(onClick={ showItemDrop=true }) { Icon(Icons.Default.Inventory, null, tint=XpBlue) } }
                            )
                            DropdownMenu(expanded=showItemDrop, onDismissRequest={ showItemDrop=false }) {
                                itens.forEach { item ->
                                    DropdownMenuItem(
                                        text={ Text("${item.descricao} — ${fmt.format(item.valorUnit)}/${item.unidadeMedia}", fontSize=12.sp) },
                                        onClick={ itemSel=item.codigo; showItemDrop=false }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(6.dp))
                        Row(verticalAlignment=Alignment.Bottom, horizontalArrangement=Arrangement.spacedBy(8.dp)) {
                            XpTextField(quantidade, { quantidade=it; erroQtd="" }, "Quantidade",
                                modifier=Modifier.weight(1f),
                                isError=erroQtd.isNotEmpty(), supportingText=erroQtd)
                            XpPrimaryButton(
                                text = "Adicionar",
                                onClick = {
                                    val item = itens.find { it.codigo == itemSel }
                                    val qtd = quantidade.replace(",",".").toDoubleOrNull()
                                    when {
                                        item == null -> erroQtd = "Selecione um item"
                                        qtd == null || qtd <= 0 -> erroQtd = "Quantidade inválida"
                                        else -> { viewModel.adicionarItemPedido(item, qtd); quantidade=""; erroQtd="" }
                                    }
                                },
                                modifier = Modifier.height(56.dp).padding(top=4.dp)
                            )
                        }
                    }
                }
            }

            if (itensPedido.isNotEmpty()) {
                item { Text("Itens do Pedido (${itensPedido.size})", fontSize=12.sp, fontWeight=FontWeight.Bold, color=XpText) }
                itemsIndexed(itensPedido) { idx, temp ->
                    XpWindow {
                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween, verticalAlignment=Alignment.CenterVertically) {
                            Column(modifier=Modifier.weight(1f)) {
                                Text(temp.item.descricao, fontWeight=FontWeight.SemiBold, fontSize=13.sp, color=XpText)
                                Text("${temp.quantidade} ${temp.item.unidadeMedia} × ${fmt.format(temp.item.valorUnit)}", fontSize=11.sp, color=XpGrayDark)
                            }
                            Row(verticalAlignment=Alignment.CenterVertically) {
                                Text(fmt.format(temp.valorTotal), fontWeight=FontWeight.Bold, color=XpGreen, fontSize=13.sp)
                                Spacer(Modifier.width(4.dp))
                                IconButton(onClick={ viewModel.removerItemPedido(idx) }) {
                                    Icon(Icons.Default.Delete, null, tint=XpRed, modifier=Modifier.size(18.dp))
                                }
                            }
                        }
                    }
                }
            }

            item {
                XpWindow {
                    XpGroupBox("Condição de Pagamento") {
                        Row(horizontalArrangement=Arrangement.spacedBy(6.dp), modifier=Modifier.fillMaxWidth()) {
                            listOf("A_VISTA" to "À Vista (-5%)", "A_PRAZO" to "À Prazo (+5%)").forEach { (opcao, label) ->
                                val selected = condicao == opcao
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .border(
                                            width = if (selected) 2.dp else 1.dp,
                                            color = if (selected) XpBlue else XpBorder,
                                            shape = RoundedCornerShape(3.dp)
                                        )
                                        .background(if (selected) XpBlue.copy(alpha = 0.08f) else Color.White, RoundedCornerShape(3.dp))
                                ) {
                                    RadioButton(
                                        selected = selected,
                                        onClick = { condicao = opcao },
                                        modifier = Modifier.align(Alignment.CenterStart)
                                    )
                                    Text(label, fontSize=11.sp, fontWeight=if (selected) FontWeight.Bold else FontWeight.Normal,
                                        color=if (selected) XpBlue else XpText,
                                        modifier=Modifier.align(Alignment.Center).padding(vertical=10.dp))
                                }
                            }
                        }
                        if (condicao == "A_PRAZO") {
                            Spacer(Modifier.height(8.dp))
                            XpTextField(parcelas, { if(it.length<=2) parcelas=it }, "Número de Parcelas")
                            if (numParc > 0 && subtotal > 0) {
                                Spacer(Modifier.height(4.dp))
                                Text("${numParc}x de ${fmt.format(vlParc)}", fontSize=12.sp, color=XpBlue, fontWeight=FontWeight.SemiBold)
                            }
                        }
                    }
                }
            }

            item {
                XpWindow {
                    XpGroupBox("Resumo do Pedido") {
                        XpInfoRow("Subtotal:", fmt.format(subtotal))
                        if (frete > 0) XpInfoRow("Frete:", fmt.format(frete))
                        if (condicao == "A_VISTA") XpInfoRow("Desconto (5%):", fmt.format(subtotal * 0.05))
                        if (condicao == "A_PRAZO") XpInfoRow("Acréscimo (5%):", fmt.format(subtotal * 0.05))
                        Divider(modifier=Modifier.padding(vertical=6.dp), color=XpBorder)
                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween) {
                            Text("TOTAL:", fontWeight=FontWeight.Bold, fontSize=14.sp, color=XpText)
                            Text(fmt.format(total), fontWeight=FontWeight.Bold, fontSize=14.sp, color=XpGreen)
                        }
                        Spacer(Modifier.height(12.dp))
                        XpPrimaryButton(
                            text = "Confirmar Pedido",
                            onClick = {
                                if (clienteSel == null) {
                                    Toast.makeText(context, "Selecione um cliente!", Toast.LENGTH_SHORT).show()
                                    return@XpPrimaryButton
                                }
                                if (itensPedido.isEmpty()) {
                                    Toast.makeText(context, "Adicione ao menos um item!", Toast.LENGTH_SHORT).show()
                                    return@XpPrimaryButton
                                }
                                viewModel.salvarPedido(
                                    codigoCliente=clienteSel!!, codigoEndereco=enderecoEntrega,
                                    condicao=condicao, parcelas=numParc, endereco=endObj,
                                    onSuccess = { num ->
                                        Toast.makeText(context, "Pedido $num salvo!", Toast.LENGTH_LONG).show()
                                        onBack()
                                    },
                                    onError = { msg -> Toast.makeText(context, "Erro: $msg", Toast.LENGTH_LONG).show() }
                                )
                            },
                            modifier=Modifier.fillMaxWidth(),
                            enabled=itensPedido.isNotEmpty() && clienteSel!=null
                        )
                    }
                }
            }
        }
    }
}
