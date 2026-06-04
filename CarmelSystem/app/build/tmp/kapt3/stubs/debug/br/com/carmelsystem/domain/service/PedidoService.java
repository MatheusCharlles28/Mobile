package br.com.carmelsystem.domain.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0014\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0011\u0010\u001b\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001e\u001a\u00020\u001aJd\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006&"}, d2 = {"Lbr/com/carmelsystem/domain/service/PedidoService;", "", "repository", "Lbr/com/carmelsystem/data/repository/PedidoRepository;", "(Lbr/com/carmelsystem/data/repository/PedidoRepository;)V", "adicionarItem", "", "Lbr/com/carmelsystem/data/model/ItemPedidoTemp;", "lista", "", "item", "Lbr/com/carmelsystem/data/model/Item;", "quantidade", "", "calcularFrete", "endereco", "Lbr/com/carmelsystem/data/model/Endereco;", "calcularSubtotal", "itens", "calcularTotal", "subtotal", "frete", "condicao", "", "calcularValorParcela", "parcelas", "", "gerarNumeroPedido", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removerItem", "index", "salvarPedido", "Lkotlin/Result;", "numeroPedido", "codigoCliente", "codigoEndereco", "salvarPedido-eH_QyT8", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;ILjava/util/List;Lbr/com/carmelsystem/data/model/Endereco;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PedidoService {
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.data.repository.PedidoRepository repository = null;
    
    public PedidoService(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.repository.PedidoRepository repository) {
        super();
    }
    
    public final double calcularSubtotal(@org.jetbrains.annotations.NotNull
    java.util.List<br.com.carmelsystem.data.model.ItemPedidoTemp> itens) {
        return 0.0;
    }
    
    public final double calcularFrete(@org.jetbrains.annotations.Nullable
    br.com.carmelsystem.data.model.Endereco endereco) {
        return 0.0;
    }
    
    public final double calcularTotal(double subtotal, double frete, @org.jetbrains.annotations.NotNull
    java.lang.String condicao) {
        return 0.0;
    }
    
    public final double calcularValorParcela(double subtotal, double frete, int parcelas) {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<br.com.carmelsystem.data.model.ItemPedidoTemp> adicionarItem(@org.jetbrains.annotations.NotNull
    java.util.List<br.com.carmelsystem.data.model.ItemPedidoTemp> lista, @org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.Item item, double quantidade) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<br.com.carmelsystem.data.model.ItemPedidoTemp> removerItem(@org.jetbrains.annotations.NotNull
    java.util.List<br.com.carmelsystem.data.model.ItemPedidoTemp> lista, int index) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object gerarNumeroPedido(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
}