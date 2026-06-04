package br.com.carmelsystem.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.carmelsystem.data.database.AppDatabase
import br.com.carmelsystem.data.model.*
import br.com.carmelsystem.data.repository.*
import br.com.carmelsystem.domain.service.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)
    private val enderecoRepo = EnderecoRepository(db.enderecoDao())
    private val clienteRepo  = ClienteRepository(db.clienteDao())
    private val itemRepo     = ItemRepository(db.itemDao())
    private val pedidoRepo   = PedidoRepository(db.pedidoVendaDao(), db.pedidoItemDao())

    val enderecoService = EnderecoService(enderecoRepo)
    val clienteService  = ClienteService(clienteRepo)
    val itemService     = ItemService(itemRepo)
    private val pedidoService = PedidoService(pedidoRepo)

    val enderecos: StateFlow<List<Endereco>> = enderecoRepo.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val clientes: StateFlow<List<Cliente>> = clienteRepo.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val itens: StateFlow<List<Item>> = itemRepo.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val pedidos: StateFlow<List<PedidoVenda>> = pedidoRepo.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _itensPedido = MutableStateFlow<List<ItemPedidoTemp>>(emptyList())
    val itensPedido: StateFlow<List<ItemPedidoTemp>> = _itensPedido.asStateFlow()

    private val _numeroPedido = MutableStateFlow("")
    val numeroPedido: StateFlow<String> = _numeroPedido.asStateFlow()

    private val _pedidoCarregado = MutableStateFlow<PedidoVenda?>(null)
    val pedidoCarregado: StateFlow<PedidoVenda?> = _pedidoCarregado.asStateFlow()

    private val _itensPedidoCarregado = MutableStateFlow<List<PedidoItem>>(emptyList())
    val itensPedidoCarregado: StateFlow<List<PedidoItem>> = _itensPedidoCarregado.asStateFlow()

    init { gerarNovoCodigo() }

    fun gerarNovoCodigo() {
        viewModelScope.launch {
            _numeroPedido.value = pedidoService.gerarNumeroPedido()
        }
    }

    fun salvarEndereco(end: Endereco, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            enderecoService.salvar(end)
                .onSuccess { onSuccess() }
                .onFailure { onError(it.message ?: "Erro ao salvar endereço") }
        }
    }

    fun atualizarEndereco(end: Endereco, onSuccess: () -> Unit) {
        viewModelScope.launch { enderecoService.atualizar(end); onSuccess() }
    }

    fun deletarEndereco(end: Endereco, onSuccess: () -> Unit) {
        viewModelScope.launch { enderecoService.deletar(end); onSuccess() }
    }

    fun salvarCliente(cli: Cliente, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            clienteService.salvar(cli)
                .onSuccess { onSuccess() }
                .onFailure { onError(it.message ?: "Erro ao salvar cliente") }
        }
    }

    fun atualizarCliente(cli: Cliente, onSuccess: () -> Unit) {
        viewModelScope.launch { clienteService.atualizar(cli); onSuccess() }
    }

    fun deletarCliente(cli: Cliente, onSuccess: () -> Unit) {
        viewModelScope.launch { clienteService.deletar(cli); onSuccess() }
    }

    fun salvarItem(item: Item, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            itemService.salvar(item)
                .onSuccess { onSuccess() }
                .onFailure { onError(it.message ?: "Erro ao salvar item") }
        }
    }

    fun atualizarItem(item: Item, onSuccess: () -> Unit) {
        viewModelScope.launch { itemService.atualizar(item); onSuccess() }
    }

    fun deletarItem(item: Item, onSuccess: () -> Unit) {
        viewModelScope.launch { itemService.deletar(item); onSuccess() }
    }

    fun adicionarItemPedido(item: Item, quantidade: Double) {
        _itensPedido.value = pedidoService.adicionarItem(_itensPedido.value.toMutableList(), item, quantidade)
    }

    fun removerItemPedido(index: Int) {
        _itensPedido.value = pedidoService.removerItem(_itensPedido.value, index)
    }

    fun calcularSubtotal(): Double = pedidoService.calcularSubtotal(_itensPedido.value)
    fun calcularFrete(endereco: Endereco?): Double = pedidoService.calcularFrete(endereco)
    fun calcularTotal(subtotal: Double, frete: Double, condicao: String, parcelas: Int): Double =
        pedidoService.calcularTotal(subtotal, frete, condicao)
    fun calcularValorParcela(subtotal: Double, frete: Double, parcelas: Int): Double =
        pedidoService.calcularValorParcela(subtotal, frete, parcelas)

    fun salvarPedido(
        codigoCliente: Int, codigoEndereco: Int?, condicao: String, parcelas: Int,
        endereco: Endereco?, onSuccess: (String) -> Unit, onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            pedidoService.salvarPedido(
                _numeroPedido.value, codigoCliente, codigoEndereco,
                condicao, parcelas, _itensPedido.value, endereco
            ).onSuccess { num ->
                limparPedido()
                onSuccess(num)
            }.onFailure { onError(it.message ?: "Erro ao salvar pedido") }
        }
    }

    fun buscarPedidoPorNumero(numero: String) {
        viewModelScope.launch {
            val pedido = pedidoRepo.getByNumeroPedido(numero)
            _pedidoCarregado.value = pedido
            _itensPedidoCarregado.value = if (pedido != null)
                pedidoRepo.getItensByPedido(pedido.codigo) else emptyList()
        }
    }

    fun limparPedidoCarregado() {
        _pedidoCarregado.value = null
        _itensPedidoCarregado.value = emptyList()
    }

    private fun limparPedido() {
        _itensPedido.value = emptyList()
        gerarNovoCodigo()
    }
}
