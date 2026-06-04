package br.com.carmelsystem.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\'\u001a\u00020\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020\u000bH\u00c6\u0003Jt\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001J\t\u0010/\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c\u00a8\u00060"}, d2 = {"Lbr/com/carmelsystem/data/model/PedidoVenda;", "", "codigo", "", "numeroPedido", "", "codigoCliente", "codigoEnderecoEntrega", "condicaoPagamento", "numeroParcelas", "valorSubtotal", "", "valorFrete", "valorTotal", "dataPedido", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/String;IDDDLjava/lang/String;)V", "getCodigo", "()I", "getCodigoCliente", "getCodigoEnderecoEntrega", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCondicaoPagamento", "()Ljava/lang/String;", "getDataPedido", "getNumeroParcelas", "getNumeroPedido", "getValorFrete", "()D", "getValorSubtotal", "getValorTotal", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/String;IDDDLjava/lang/String;)Lbr/com/carmelsystem/data/model/PedidoVenda;", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "pedido_venda", foreignKeys = {@androidx.room.ForeignKey(entity = br.com.carmelsystem.data.model.Cliente.class, parentColumns = {"codigo"}, childColumns = {"codigoCliente"}, onDelete = 2), @androidx.room.ForeignKey(entity = br.com.carmelsystem.data.model.Endereco.class, parentColumns = {"codigo"}, childColumns = {"codigoEnderecoEntrega"}, onDelete = 3)}, indices = {@androidx.room.Index(value = {"codigoCliente"}), @androidx.room.Index(value = {"codigoEnderecoEntrega"})})
public final class PedidoVenda {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int codigo = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String numeroPedido = null;
    private final int codigoCliente = 0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer codigoEnderecoEntrega = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String condicaoPagamento = null;
    private final int numeroParcelas = 0;
    private final double valorSubtotal = 0.0;
    private final double valorFrete = 0.0;
    private final double valorTotal = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String dataPedido = null;
    
    public PedidoVenda(int codigo, @org.jetbrains.annotations.NotNull
    java.lang.String numeroPedido, int codigoCliente, @org.jetbrains.annotations.Nullable
    java.lang.Integer codigoEnderecoEntrega, @org.jetbrains.annotations.NotNull
    java.lang.String condicaoPagamento, int numeroParcelas, double valorSubtotal, double valorFrete, double valorTotal, @org.jetbrains.annotations.NotNull
    java.lang.String dataPedido) {
        super();
    }
    
    public final int getCodigo() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNumeroPedido() {
        return null;
    }
    
    public final int getCodigoCliente() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getCodigoEnderecoEntrega() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCondicaoPagamento() {
        return null;
    }
    
    public final int getNumeroParcelas() {
        return 0;
    }
    
    public final double getValorSubtotal() {
        return 0.0;
    }
    
    public final double getValorFrete() {
        return 0.0;
    }
    
    public final double getValorTotal() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDataPedido() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final br.com.carmelsystem.data.model.PedidoVenda copy(int codigo, @org.jetbrains.annotations.NotNull
    java.lang.String numeroPedido, int codigoCliente, @org.jetbrains.annotations.Nullable
    java.lang.Integer codigoEnderecoEntrega, @org.jetbrains.annotations.NotNull
    java.lang.String condicaoPagamento, int numeroParcelas, double valorSubtotal, double valorFrete, double valorTotal, @org.jetbrains.annotations.NotNull
    java.lang.String dataPedido) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}