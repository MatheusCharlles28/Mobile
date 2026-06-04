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
import br.com.carmelsystem.data.model.Cliente
import br.com.carmelsystem.ui.components.*
import br.com.carmelsystem.ui.theme.*
import br.com.carmelsystem.viewmodel.AppViewModel

@Composable
fun ClienteScreen(viewModel: AppViewModel, onBack: () -> Unit) {
    val clientes   by viewModel.clientes.collectAsState()
    val enderecos  by viewModel.enderecos.collectAsState()
    var nome       by remember { mutableStateOf("") }
    var cpf        by remember { mutableStateOf("") }
    var dataNasc   by remember { mutableStateOf("") }
    var endSel     by remember { mutableStateOf<Int?>(null) }
    var editando   by remember { mutableStateOf<Cliente?>(null) }
    var erros      by remember { mutableStateOf(mapOf<String, String>()) }
    var snackMsg   by remember { mutableStateOf("") }
    var showSnack  by remember { mutableStateOf(false) }
    var showEndDrop by remember { mutableStateOf(false) }

    fun limpar() { nome=""; cpf=""; dataNasc=""; endSel=null; editando=null; erros=emptyMap() }
    fun preencher(c: Cliente) { editando=c; nome=c.nome; cpf=c.cpf; dataNasc=c.dataNasc; endSel=c.codigoEndereco }

    Scaffold(
        topBar = { XpTopAppBar("Clientes", onBack) },
        snackbarHost = { if (showSnack) Snackbar(Modifier.padding(8.dp)) { Text(snackMsg) } }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(XpGrayLight).padding(padding).padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                XpWindow {
                    XpGroupBox(if (editando!=null) "Editar Cliente" else "Novo Cliente") {
                        XpTextField(nome, { nome=it }, "Nome Completo",
                            isError=erros.containsKey("nome"), supportingText=erros["nome"]?:"")
                        Spacer(Modifier.height(6.dp))
                        XpTextField(cpf, { if(it.length<=14) cpf=it }, "CPF",
                            isError=erros.containsKey("cpf"), supportingText=erros["cpf"]?:"")
                        Spacer(Modifier.height(6.dp))
                        XpTextField(dataNasc, { dataNasc=it }, "Data Nascimento (DD/MM/AAAA)",
                            isError=erros.containsKey("dataNasc"), supportingText=erros["dataNasc"]?:"")
                        Spacer(Modifier.height(6.dp))
                        Box {
                            XpTextField(
                                value = endSel?.let { id -> enderecos.find { it.codigo == id }?.enderecoCompleto() } ?: "Selecionar endereço",
                                onValueChange = {},
                                label = "Endereço",
                                readOnly = true,
                                trailingIcon = {
                                    IconButton(onClick={ showEndDrop=true }) { Icon(Icons.Default.ArrowDropDown, null, tint=XpBlue) }
                                }
                            )
                            DropdownMenu(expanded=showEndDrop, onDismissRequest={ showEndDrop=false }) {
                                DropdownMenuItem(text={ Text("Nenhum", fontSize=13.sp) }, onClick={ endSel=null; showEndDrop=false })
                                enderecos.forEach { e ->
                                    DropdownMenuItem(
                                        text={ Text(e.enderecoCompleto(), fontSize=12.sp) },
                                        onClick={ endSel=e.codigo; showEndDrop=false }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                        Row(horizontalArrangement=Arrangement.spacedBy(8.dp), modifier=Modifier.fillMaxWidth()) {
                            if (editando!=null) {
                                XpButton("Cancelar", { limpar() }, modifier=Modifier.weight(1f))
                            }
                            XpPrimaryButton(
                                text = if (editando!=null) "Atualizar" else "Salvar",
                                onClick = {
                                    erros = viewModel.clienteService.validar(nome, cpf, dataNasc)
                                    if (erros.isEmpty()) {
                                        val cli = Cliente(editando?.codigo?:0, nome, cpf, dataNasc, endSel)
                                        if (editando!=null)
                                            viewModel.atualizarCliente(cli) { limpar(); snackMsg="Atualizado!"; showSnack=true }
                                        else
                                            viewModel.salvarCliente(cli, { limpar(); snackMsg="Salvo!"; showSnack=true }, { msg -> snackMsg=msg; showSnack=true })
                                    }
                                },
                                modifier=Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            item { Text("Clientes Cadastrados (${clientes.size})", fontSize=12.sp, fontWeight=FontWeight.Bold, color=XpText) }

            items(clientes) { cli ->
                XpWindow {
                    Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween, verticalAlignment=Alignment.Top) {
                        Column(modifier=Modifier.weight(1f)) {
                            Text(cli.nome, fontWeight=FontWeight.SemiBold, fontSize=13.sp, color=XpText)
                            Text("CPF: ${cli.cpf}", fontSize=11.sp, color=XpGrayDark)
                            Text("Nasc: ${cli.dataNasc}", fontSize=11.sp, color=XpGrayDark)
                        }
                        Row {
                            IconButton(onClick={ preencher(cli) }) { Icon(Icons.Default.Edit, null, tint=XpBlue, modifier=Modifier.size(18.dp)) }
                            IconButton(onClick={ viewModel.deletarCliente(cli) { snackMsg="Removido!"; showSnack=true } }) {
                                Icon(Icons.Default.Delete, null, tint=XpRed, modifier=Modifier.size(18.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
