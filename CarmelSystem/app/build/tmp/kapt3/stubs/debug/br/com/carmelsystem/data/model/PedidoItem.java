package br.com.carmelsystem.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001J\t\u0010&\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\'"}, d2 = {"Lbr/com/carmelsystem/data/model/PedidoItem;", "", "id", "", "codigoPedido", "codigoItem", "descricaoItem", "", "quantidade", "", "valorUnitario", "unidadeMedida", "valorTotal", "(IIILjava/lang/String;DDLjava/lang/String;D)V", "getCodigoItem", "()I", "getCodigoPedido", "getDescricaoItem", "()Ljava/lang/String;", "getId", "getQuantidade", "()D", "getUnidadeMedida", "getValorTotal", "getValorUnitario", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "pedido_item", foreignKeys = {@androidx.room.ForeignKey(entity = br.com.carmelsystem.data.model.PedidoVenda.class, parentColumns = {"codigo"}, childColumns = {"codigoPedido"}, onDelete = 5), @androidx.room.ForeignKey(entity = br.com.carmelsystem.data.model.Item.class, parentColumns = {"codigo"}, childColumns = {"codigoItem"}, onDelete = 2)}, indices = {@androidx.room.Index(value = {"codigoPedido"}), @androidx.room.Index(value = {"codigoItem"})})
public final class PedidoItem {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    private final int codigoPedido = 0;
    private final int codigoItem = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String descricaoItem = null;
    private final double quantidade = 0.0;
    private final double valorUnitario = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String unidadeMedida = null;
    private final double valorTotal = 0.0;
    
    public PedidoItem(int id, int codigoPedido, int codigoItem, @org.jetbrains.annotations.NotNull
    java.lang.String descricaoItem, double quantidade, double valorUnitario, @org.jetbrains.annotations.NotNull
    java.lang.String unidadeMedida, double valorTotal) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final int getCodigoPedido() {
        return 0;
    }
    
    public final int getCodigoItem() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescricaoItem() {
        return null;
    }
    
    public final double getQuantidade() {
        return 0.0;
    }
    
    public final double getValorUnitario() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUnidadeMedida() {
        return null;
    }
    
    public final double getValorTotal() {
        return 0.0;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final br.com.carmelsystem.data.model.PedidoItem copy(int id, int codigoPedido, int codigoItem, @org.jetbrains.annotations.NotNull
    java.lang.String descricaoItem, double quantidade, double valorUnitario, @org.jetbrains.annotations.NotNull
    java.lang.String unidadeMedida, double valorTotal) {
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