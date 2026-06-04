package br.com.carmelsystem.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.carmelsystem.data.model.Item
import br.com.carmelsystem.ui.components.*
import br.com.carmelsystem.ui.theme.*
import br.com.carmelsystem.viewmodel.AppViewModel
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ItemScreen(viewModel: AppViewModel, onBack: () -> Unit) {
    val itens     by viewModel.itens.collectAsState()
    var descricao by remember { mutableStateOf("") }
    var valorUnit by remember { mutableStateOf("") }
    var unidade   by remember { mutableStateOf("") }
    var editando  by remember { mutableStateOf<Item?>(null) }
    var erros     by remember { mutableStateOf(mapOf<String, String>()) }
    var snackMsg  by remember { mutableStateOf("") }
    var showSnack by remember { mutableStateOf(false) }
    val fmt = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    fun limpar() { descricao=""; valorUnit=""; unidade=""; editando=null; erros=emptyMap() }
    fun preencher(i: Item) { editando=i; descricao=i.descricao; valorUnit=i.valorUnit.toString(); unidade=i.unidadeMedia }

    Scaffold(
        topBar = { XpTopAppBar("Itens / Produtos", onBack) },
        snackbarHost = { if (showSnack) Snackbar(Modifier.padding(8.dp)) { Text(snackMsg) } }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(XpGrayLight).padding(padding).padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                XpWindow {
                    XpGroupBox(if (editando!=null) "Editar Item" else "Novo Item") {
                        XpTextField(descricao, { descricao=it }, "Descrição",
                            isError=erros.containsKey("descricao"), supportingText=erros["descricao"]?:"")
                        Spacer(Modifier.height(6.dp))
                        Row(horizontalArrangement=Arrangement.spacedBy(8.dp)) {
                            XpTextField(valorUnit, { valorUnit=it }, "Valor Unitário (R$)",
                                modifier=Modifier.weight(1.5f),
                                isError=erros.containsKey("valorUnit"), supportingText=erros["valorUnit"]?:"")
                            XpTextField(unidade, { unidade=it.uppercase() }, "Unidade",
                                modifier=Modifier.weight(1f),
                                isError=erros.containsKey("unidade"), supportingText=erros["unidade"]?:"")
                        }
                        Spacer(Modifier.height(10.dp))
                        Row(horizontalArrangement=Arrangement.spacedBy(8.dp), modifier=Modifier.fillMaxWidth()) {
                            if (editando!=null) {
                                XpButton("Cancelar", { limpar() }, modifier=Modifier.weight(1f))
                            }
                            XpPrimaryButton(
                                text = if (editando!=null) "Atualizar" else "Salvar",
                                onClick = {
                                    erros = viewModel.itemService.validar(descricao, valorUnit, unidade)
                                    if (erros.isEmpty()) {
                                        val vl = valorUnit.replace(",", ".").toDouble()
                                        val item = Item(editando?.codigo?:0, descricao, vl, unidade)
                                        if (editando!=null)
                                            viewModel.atualizarItem(item) { limpar(); snackMsg="Atualizado!"; showSnack=true }
                                        else
                                            viewModel.salvarItem(item, { limpar(); snackMsg="Salvo!"; showSnack=true }, { msg -> snackMsg=msg; showSnack=true })
                                    }
                                },
                                modifier=Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            item { Text("Itens Cadastrados (${itens.size})", fontSize=12.sp, fontWeight=FontWeight.Bold, color=XpText) }

            items(itens) { item ->
                XpWindow {
                    Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween, verticalAlignment=Alignment.Top) {
                        Column(modifier=Modifier.weight(1f)) {
                            Text(item.descricao, fontWeight=FontWeight.SemiBold, fontSize=13.sp, color=XpText)
                            Row(horizontalArrangement=Arrangement.spacedBy(6.dp), modifier=Modifier.padding(top=2.dp)) {
                                XpStatusBadge(fmt.format(item.valorUnit), XpGreen)
                                XpStatusBadge(item.unidadeMedia, XpBlue)
                            }
                        }
                        Row {
                            IconButton(onClick={ preencher(item) }) { Icon(Icons.Default.Edit, null, tint=XpBlue, modifier=Modifier.size(18.dp)) }
                            IconButton(onClick={ viewModel.deletarItem(item) { snackMsg="Removido!"; showSnack=true } }) {
                                Icon(Icons.Default.Delete, null, tint=XpRed, modifier=Modifier.size(18.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
