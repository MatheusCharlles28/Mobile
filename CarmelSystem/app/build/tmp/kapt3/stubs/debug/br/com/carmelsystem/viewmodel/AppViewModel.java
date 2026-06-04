package br.com.carmelsystem.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020@J\u001c\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020\u00172\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0DJ\u001c\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020#2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0DJ\u001c\u0010G\u001a\u00020=2\u0006\u0010>\u001a\u00020,2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0DJ\u000e\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020\fJ\u0010\u0010J\u001a\u00020@2\b\u0010K\u001a\u0004\u0018\u00010#J\u0006\u0010L\u001a\u00020@J&\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020@2\u0006\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020RJ\u001e\u0010S\u001a\u00020@2\u0006\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020@2\u0006\u0010Q\u001a\u00020RJ\u001c\u0010T\u001a\u00020=2\u0006\u0010B\u001a\u00020\u00172\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0DJ\u001c\u0010U\u001a\u00020=2\u0006\u0010F\u001a\u00020#2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0DJ\u001c\u0010V\u001a\u00020=2\u0006\u0010>\u001a\u00020,2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0DJ\u0006\u0010W\u001a\u00020=J\b\u0010X\u001a\u00020=H\u0002J\u0006\u0010Y\u001a\u00020=J\u000e\u0010Z\u001a\u00020=2\u0006\u0010[\u001a\u00020RJ0\u0010\\\u001a\u00020=2\u0006\u0010B\u001a\u00020\u00172\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0D2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020=0^J0\u0010_\u001a\u00020=2\u0006\u0010F\u001a\u00020#2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0D2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020=0^J0\u0010`\u001a\u00020=2\u0006\u0010>\u001a\u00020,2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020=0D2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020=0^J_\u0010a\u001a\u00020=2\u0006\u0010b\u001a\u00020R2\b\u0010c\u001a\u0004\u0018\u00010R2\u0006\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020R2\b\u0010K\u001a\u0004\u0018\u00010#2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020=0^2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020=0^\u00a2\u0006\u0002\u0010dR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\'\u001a\u00020(\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019R\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0019R\u0019\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0019R\u000e\u00106\u001a\u000207X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0019\u00a8\u0006e"}, d2 = {"Lbr/com/carmelsystem/viewmodel/AppViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_itensPedido", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lbr/com/carmelsystem/data/model/ItemPedidoTemp;", "_itensPedidoCarregado", "Lbr/com/carmelsystem/data/model/PedidoItem;", "_numeroPedido", "", "_pedidoCarregado", "Lbr/com/carmelsystem/data/model/PedidoVenda;", "clienteRepo", "Lbr/com/carmelsystem/data/repository/ClienteRepository;", "clienteService", "Lbr/com/carmelsystem/domain/service/ClienteService;", "getClienteService", "()Lbr/com/carmelsystem/domain/service/ClienteService;", "clientes", "Lkotlinx/coroutines/flow/StateFlow;", "Lbr/com/carmelsystem/data/model/Cliente;", "getClientes", "()Lkotlinx/coroutines/flow/StateFlow;", "db", "Lbr/com/carmelsystem/data/database/AppDatabase;", "enderecoRepo", "Lbr/com/carmelsystem/data/repository/EnderecoRepository;", "enderecoService", "Lbr/com/carmelsystem/domain/service/EnderecoService;", "getEnderecoService", "()Lbr/com/carmelsystem/domain/service/EnderecoService;", "enderecos", "Lbr/com/carmelsystem/data/model/Endereco;", "getEnderecos", "itemRepo", "Lbr/com/carmelsystem/data/repository/ItemRepository;", "itemService", "Lbr/com/carmelsystem/domain/service/ItemService;", "getItemService", "()Lbr/com/carmelsystem/domain/service/ItemService;", "itens", "Lbr/com/carmelsystem/data/model/Item;", "getItens", "itensPedido", "getItensPedido", "itensPedidoCarregado", "getItensPedidoCarregado", "numeroPedido", "getNumeroPedido", "pedidoCarregado", "getPedidoCarregado", "pedidoRepo", "Lbr/com/carmelsystem/data/repository/PedidoRepository;", "pedidoService", "Lbr/com/carmelsystem/domain/service/PedidoService;", "pedidos", "getPedidos", "adicionarItemPedido", "", "item", "quantidade", "", "atualizarCliente", "cli", "onSuccess", "Lkotlin/Function0;", "atualizarEndereco", "end", "atualizarItem", "buscarPedidoPorNumero", "numero", "calcularFrete", "endereco", "calcularSubtotal", "calcularTotal", "subtotal", "frete", "condicao", "parcelas", "", "calcularValorParcela", "deletarCliente", "deletarEndereco", "deletarItem", "gerarNovoCodigo", "limparPedido", "limparPedidoCarregado", "removerItemPedido", "index", "salvarCliente", "onError", "Lkotlin/Function1;", "salvarEndereco", "salvarItem", "salvarPedido", "codigoCliente", "codigoEndereco", "(ILjava/lang/Integer;Ljava/lang/String;ILbr/com/carmelsystem/data/model/Endereco;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_debug"})
public final class AppViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.data.database.AppDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.data.repository.EnderecoRepository enderecoRepo = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.data.repository.ClienteRepository clienteRepo = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.data.repository.ItemRepository itemRepo = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.data.repository.PedidoRepository pedidoRepo = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.domain.service.EnderecoService enderecoService = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.domain.service.ClienteService clienteService = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.domain.service.ItemService itemService = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.domain.service.PedidoService pedidoService = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.Endereco>> enderecos = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.Cliente>> clientes = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.Item>> itens = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.PedidoVenda>> pedidos = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<br.com.carmelsystem.data.model.ItemPedidoTemp>> _itensPedido = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.ItemPedidoTemp>> itensPedido = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _numeroPedido = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> numeroPedido = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<br.com.carmelsystem.data.model.PedidoVenda> _pedidoCarregado = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<br.com.carmelsystem.data.model.PedidoVenda> pedidoCarregado = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<br.com.carmelsystem.data.model.PedidoItem>> _itensPedidoCarregado = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.PedidoItem>> itensPedidoCarregado = null;
    
    public AppViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final br.com.carmelsystem.domain.service.EnderecoService getEnderecoService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final br.com.carmelsystem.domain.service.ClienteService getClienteService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final br.com.carmelsystem.domain.service.ItemService getItemService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.Endereco>> getEnderecos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.Cliente>> getClientes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.Item>> getItens() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.PedidoVenda>> getPedidos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.ItemPedidoTemp>> getItensPedido() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getNumeroPedido() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<br.com.carmelsystem.data.model.PedidoVenda> getPedidoCarregado() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<br.com.carmelsystem.data.model.PedidoItem>> getItensPedidoCarregado() {
        return null;
    }
    
    public final void gerarNovoCodigo() {
    }
    
    public final void salvarEndereco(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Endereco end, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    public final void atualizarEndereco(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Endereco end, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void deletarEndereco(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Endereco end, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void salvarCliente(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Cliente cli, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    public final void atualizarCliente(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Cliente cli, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void deletarCliente(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Cliente cli, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void salvarItem(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Item item, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    public final void atualizarItem(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Item item, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void deletarItem(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Item item, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void adicionarItemPedido(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Item item, double quantidade) {
    }
    
    public final void removerItemPedido(int index) {
    }
    
    public final double calcularSubtotal() {
        return 0.0;
    }
    
    public final double calcularFrete(@org.jetbrains.annotations.Nullable
    br.com.carmelsystem.data.model.Endereco endereco) {
        return 0.0;
    }
    
    public final double calcularTotal(double subtotal, double frete, @org.jetbrains.annotations.NotNull
    java.lang.String condicao, int parcelas) {
        return 0.0;
    }
    
    public final double calcularValorParcela(double subtotal, double frete, int parcelas) {
        return 0.0;
    }
    
    public final void salvarPedido(int codigoCliente, @org.jetbrains.annotations.Nullable
    java.lang.Integer codigoEndereco, @org.jetbrains.annotations.NotNull
    java.lang.String condicao, int parcelas, @org.jetbrains.annotations.Nullable
    br.com.carmelsystem.data.model.Endereco endereco, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    public final void buscarPedidoPorNumero(@org.jetbrains.annotations.NotNull
    java.lang.String numero) {
    }
    
    public final void limparPedidoCarregado() {
    }
    
    private final void limparPedido() {
    }
}