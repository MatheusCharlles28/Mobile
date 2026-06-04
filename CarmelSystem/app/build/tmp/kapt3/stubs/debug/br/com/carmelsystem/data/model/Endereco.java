package br.com.carmelsystem.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0006\u0010\u001a\u001a\u00020\u0005J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006 "}, d2 = {"Lbr/com/carmelsystem/data/model/Endereco;", "", "codigo", "", "logradouro", "", "numero", "bairro", "cidade", "uf", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBairro", "()Ljava/lang/String;", "getCidade", "getCodigo", "()I", "getLogradouro", "getNumero", "getUf", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "enderecoCompleto", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "endereco")
public final class Endereco {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int codigo = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String logradouro = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String numero = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String bairro = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String cidade = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String uf = null;
    
    public Endereco(int codigo, @org.jetbrains.annotations.NotNull
    java.lang.String logradouro, @org.jetbrains.annotations.NotNull
    java.lang.String numero, @org.jetbrains.annotations.NotNull
    java.lang.String bairro, @org.jetbrains.annotations.NotNull
    java.lang.String cidade, @org.jetbrains.annotations.NotNull
    java.lang.String uf) {
        super();
    }
    
    public final int getCodigo() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLogradouro() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNumero() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBairro() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCidade() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUf() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String enderecoCompleto() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final br.com.carmelsystem.data.model.Endereco copy(int codigo, @org.jetbrains.annotations.NotNull
    java.lang.String logradouro, @org.jetbrains.annotations.NotNull
    java.lang.String numero, @org.jetbrains.annotations.NotNull
    java.lang.String bairro, @org.jetbrains.annotations.NotNull
    java.lang.String cidade, @org.jetbrains.annotations.NotNull
    java.lang.String uf) {
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