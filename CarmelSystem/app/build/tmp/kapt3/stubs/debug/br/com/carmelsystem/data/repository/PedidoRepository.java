package br.com.carmelsystem.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lbr/com/carmelsystem/data/repository/PedidoRepository;", "", "pedidoDao", "Lbr/com/carmelsystem/data/dao/PedidoVendaDao;", "pedidoItemDao", "Lbr/com/carmelsystem/data/dao/PedidoItemDao;", "(Lbr/com/carmelsystem/data/dao/PedidoVendaDao;Lbr/com/carmelsystem/data/dao/PedidoItemDao;)V", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lbr/com/carmelsystem/data/model/PedidoVenda;", "getByNumeroPedido", "numero", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItensByPedido", "Lbr/com/carmelsystem/data/model/PedidoItem;", "codigoPedido", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMaxCodigo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "pedido", "(Lbr/com/carmelsystem/data/model/PedidoVenda;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertItens", "", "itens", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PedidoRepository {
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.data.dao.PedidoVendaDao pedidoDao = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.carmelsystem.data.dao.PedidoItemDao pedidoItemDao = null;
    
    public PedidoRepository(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.dao.PedidoVendaDao pedidoDao, @org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.dao.PedidoItemDao pedidoItemDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<br.com.carmelsystem.data.model.PedidoVenda>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMaxCodigo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getByNumeroPedido(@org.jetbrains.annotations.NotNull
    java.lang.String numero, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super br.com.carmelsystem.data.model.PedidoVenda> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull
    br.com.carmelsystem.data.model.PedidoVenda pedido, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertItens(@org.jetbrains.annotations.NotNull
    java.util.List<br.com.carmelsystem.data.model.PedidoItem> itens, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getItensByPedido(int codigoPedido, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<br.com.carmelsystem.data.model.PedidoItem>> $completion) {
        return null;
    }
}