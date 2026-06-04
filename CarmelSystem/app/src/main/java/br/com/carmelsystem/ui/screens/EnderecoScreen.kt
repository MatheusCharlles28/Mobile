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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.carmelsystem.data.model.Endereco
import br.com.carmelsystem.ui.components.*
import br.com.carmelsystem.ui.theme.*
import br.com.carmelsystem.viewmodel.AppViewModel

@Composable
fun EnderecoScreen(viewModel: AppViewModel, onBack: () -> Unit) {
    val enderecos by viewModel.enderecos.collectAsState()
    var logradouro by remember { mutableStateOf("") }
    var numero     by remember { mutableStateOf("") }
    var bairro     by remember { mutableStateOf("") }
    var cidade     by remember { mutableStateOf("") }
    var uf         by remember { mutableStateOf("") }
    var editando   by remember { mutableStateOf<Endereco?>(null) }
    var erros      by remember { mutableStateOf(mapOf<String, String>()) }
    var snackMsg   by remember { mutableStateOf("") }
    var showSnack  by remember { mutableStateOf(false) }

    fun limpar() { logradouro=""; numero=""; bairro=""; cidade=""; uf=""; editando=null; erros=emptyMap() }
    fun preencher(e: Endereco) { editando=e; logradouro=e.logradouro; numero=e.numero; bairro=e.bairro; cidade=e.cidade; uf=e.uf }

    Scaffold(
        topBar = { XpTopAppBar("Endereços", onBack) },
        snackbarHost = { if (showSnack) Snackbar(modifier=Modifier.padding(8.dp)) { Text(snackMsg) } }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(XpGrayLight).padding(padding).padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                XpWindow {
                    XpGroupBox(if (editando!=null) "Editar Endereço" else "Novo Endereço") {
                        XpTextField(logradouro, { logradouro=it }, "Logradouro",
                            isError=erros.containsKey("logradouro"), supportingText=erros["logradouro"]?:"")
                        Spacer(Modifier.height(6.dp))
                        Row(horizontalArrangement=Arrangement.spacedBy(8.dp)) {
                            XpTextField(numero, { numero=it }, "Número",
                                modifier=Modifier.weight(1f),
                                isError=erros.containsKey("numero"), supportingText=erros["numero"]?:"")
                            XpTextField(uf, { if(it.length<=2) uf=it.uppercase() }, "UF",
                                modifier=Modifier.weight(0.5f),
                                isError=erros.containsKey("uf"), supportingText=erros["uf"]?:"")
                        }
                        Spacer(Modifier.height(6.dp))
                        XpTextField(bairro, { bairro=it }, "Bairro",
                            isError=erros.containsKey("bairro"), supportingText=erros["bairro"]?:"")
                        Spacer(Modifier.height(6.dp))
                        XpTextField(cidade, { cidade=it }, "Cidade",
                            isError=erros.containsKey("cidade"), supportingText=erros["cidade"]?:"")
                        Spacer(Modifier.height(10.dp))
                        Row(
                            horizontalArrangement=Arrangement.spacedBy(8.dp),
                            modifier=Modifier.fillMaxWidth()
                        ) {
                            if (editando!=null) {
                                XpButton("Cancelar", { limpar() }, modifier=Modifier.weight(1f))
                            }
                            XpPrimaryButton(
                                text = if (editando!=null) "Atualizar" else "Salvar",
                                onClick = {
                                    erros = viewModel.enderecoService.validar(logradouro, numero, bairro, cidade, uf)
                                    if (erros.isEmpty()) {
                                        val end = Endereco(editando?.codigo?:0, logradouro, numero, bairro, cidade, uf)
                                        if (editando!=null)
                                            viewModel.atualizarEndereco(end) { limpar(); snackMsg="Atualizado!"; showSnack=true }
                                        else
                                            viewModel.salvarEndereco(end, { limpar(); snackMsg="Salvo!"; showSnack=true }, { msg -> snackMsg=msg; showSnack=true })
                                    }
                                },
                                modifier=Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            item {
                Text("Endereços Cadastrados (${enderecos.size})", fontSize=12.sp, fontWeight=FontWeight.Bold, color=XpText)
            }

            items(enderecos) { end ->
                XpWindow {
                    Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween, verticalAlignment=Alignment.Top) {
                        Column(modifier=Modifier.weight(1f)) {
                            Text("${end.logradouro}, ${end.numero}", fontWeight=FontWeight.SemiBold, fontSize=13.sp, color=XpText)
                            Text("${end.bairro} - ${end.cidade}/${end.uf}", fontSize=11.sp, color=XpGrayDark)
                        }
                        Row {
                            IconButton(onClick={ preencher(end) }) { Icon(Icons.Default.Edit, null, tint=XpBlue, modifier=Modifier.size(18.dp)) }
                            IconButton(onClick={ viewModel.deletarEndereco(end) { snackMsg="Removido!"; showSnack=true } }) {
                                Icon(Icons.Default.Delete, null, tint=XpRed, modifier=Modifier.size(18.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
