package br.com.carmelsystem.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import br.com.carmelsystem.data.model.PedidoVenda;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PedidoVendaDao_Impl implements PedidoVendaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PedidoVenda> __insertionAdapterOfPedidoVenda;

  private final EntityDeletionOrUpdateAdapter<PedidoVenda> __deletionAdapterOfPedidoVenda;

  private final EntityDeletionOrUpdateAdapter<PedidoVenda> __updateAdapterOfPedidoVenda;

  public PedidoVendaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPedidoVenda = new EntityInsertionAdapter<PedidoVenda>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `pedido_venda` (`codigo`,`numeroPedido`,`codigoCliente`,`codigoEnderecoEntrega`,`condicaoPagamento`,`numeroParcelas`,`valorSubtotal`,`valorFrete`,`valorTotal`,`dataPedido`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PedidoVenda entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getNumeroPedido() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNumeroPedido());
        }
        statement.bindLong(3, entity.getCodigoCliente());
        if (entity.getCodigoEnderecoEntrega() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getCodigoEnderecoEntrega());
        }
        if (entity.getCondicaoPagamento() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCondicaoPagamento());
        }
        statement.bindLong(6, entity.getNumeroParcelas());
        statement.bindDouble(7, entity.getValorSubtotal());
        statement.bindDouble(8, entity.getValorFrete());
        statement.bindDouble(9, entity.getValorTotal());
        if (entity.getDataPedido() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getDataPedido());
        }
      }
    };
    this.__deletionAdapterOfPedidoVenda = new EntityDeletionOrUpdateAdapter<PedidoVenda>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `pedido_venda` WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PedidoVenda entity) {
        statement.bindLong(1, entity.getCodigo());
      }
    };
    this.__updateAdapterOfPedidoVenda = new EntityDeletionOrUpdateAdapter<PedidoVenda>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `pedido_venda` SET `codigo` = ?,`numeroPedido` = ?,`codigoCliente` = ?,`codigoEnderecoEntrega` = ?,`condicaoPagamento` = ?,`numeroParcelas` = ?,`valorSubtotal` = ?,`valorFrete` = ?,`valorTotal` = ?,`dataPedido` = ? WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PedidoVenda entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getNumeroPedido() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNumeroPedido());
        }
        statement.bindLong(3, entity.getCodigoCliente());
        if (entity.getCodigoEnderecoEntrega() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getCodigoEnderecoEntrega());
        }
        if (entity.getCondicaoPagamento() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCondicaoPagamento());
        }
        statement.bindLong(6, entity.getNumeroParcelas());
        statement.bindDouble(7, entity.getValorSubtotal());
        statement.bindDouble(8, entity.getValorFrete());
        statement.bindDouble(9, entity.getValorTotal());
        if (entity.getDataPedido() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getDataPedido());
        }
        statement.bindLong(11, entity.getCodigo());
      }
    };
  }

  @Override
  public Object insert(final PedidoVenda pedido, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPedidoVenda.insertAndReturnId(pedido);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final PedidoVenda pedido, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPedidoVenda.handle(pedido);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final PedidoVenda pedido, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPedidoVenda.handle(pedido);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PedidoVenda>> getAll() {
    final String _sql = "SELECT * FROM pedido_venda ORDER BY codigo DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pedido_venda"}, new Callable<List<PedidoVenda>>() {
      @Override
      @NonNull
      public List<PedidoVenda> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNumeroPedido = CursorUtil.getColumnIndexOrThrow(_cursor, "numeroPedido");
          final int _cursorIndexOfCodigoCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "codigoCliente");
          final int _cursorIndexOfCodigoEnderecoEntrega = CursorUtil.getColumnIndexOrThrow(_cursor, "codigoEnderecoEntrega");
          final int _cursorIndexOfCondicaoPagamento = CursorUtil.getColumnIndexOrThrow(_cursor, "condicaoPagamento");
          final int _cursorIndexOfNumeroParcelas = CursorUtil.getColumnIndexOrThrow(_cursor, "numeroParcelas");
          final int _cursorIndexOfValorSubtotal = CursorUtil.getColumnIndexOrThrow(_cursor, "valorSubtotal");
          final int _cursorIndexOfValorFrete = CursorUtil.getColumnIndexOrThrow(_cursor, "valorFrete");
          final int _cursorIndexOfValorTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "valorTotal");
          final int _cursorIndexOfDataPedido = CursorUtil.getColumnIndexOrThrow(_cursor, "dataPedido");
          final List<PedidoVenda> _result = new ArrayList<PedidoVenda>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PedidoVenda _item;
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpNumeroPedido;
            if (_cursor.isNull(_cursorIndexOfNumeroPedido)) {
              _tmpNumeroPedido = null;
            } else {
              _tmpNumeroPedido = _cursor.getString(_cursorIndexOfNumeroPedido);
            }
            final int _tmpCodigoCliente;
            _tmpCodigoCliente = _cursor.getInt(_cursorIndexOfCodigoCliente);
            final Integer _tmpCodigoEnderecoEntrega;
            if (_cursor.isNull(_cursorIndexOfCodigoEnderecoEntrega)) {
              _tmpCodigoEnderecoEntrega = null;
            } else {
              _tmpCodigoEnderecoEntrega = _cursor.getInt(_cursorIndexOfCodigoEnderecoEntrega);
            }
            final String _tmpCondicaoPagamento;
            if (_cursor.isNull(_cursorIndexOfCondicaoPagamento)) {
              _tmpCondicaoPagamento = null;
            } else {
              _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
            }
            final int _tmpNumeroParcelas;
            _tmpNumeroParcelas = _cursor.getInt(_cursorIndexOfNumeroParcelas);
            final double _tmpValorSubtotal;
            _tmpValorSubtotal = _cursor.getDouble(_cursorIndexOfValorSubtotal);
            final double _tmpValorFrete;
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
            final double _tmpValorTotal;
            _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
            final String _tmpDataPedido;
            if (_cursor.isNull(_cursorIndexOfDataPedido)) {
              _tmpDataPedido = null;
            } else {
              _tmpDataPedido = _cursor.getString(_cursorIndexOfDataPedido);
            }
            _item = new PedidoVenda(_tmpCodigo,_tmpNumeroPedido,_tmpCodigoCliente,_tmpCodigoEnderecoEntrega,_tmpCondicaoPagamento,_tmpNumeroParcelas,_tmpValorSubtotal,_tmpValorFrete,_tmpValorTotal,_tmpDataPedido);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getMaxCodigo(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COALESCE(MAX(codigo), 0) FROM pedido_venda";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getByNumeroPedido(final String numero,
      final Continuation<? super PedidoVenda> $completion) {
    final String _sql = "SELECT * FROM pedido_venda WHERE numeroPedido = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numero == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numero);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PedidoVenda>() {
      @Override
      @Nullable
      public PedidoVenda call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNumeroPedido = CursorUtil.getColumnIndexOrThrow(_cursor, "numeroPedido");
          final int _cursorIndexOfCodigoCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "codigoCliente");
          final int _cursorIndexOfCodigoEnderecoEntrega = CursorUtil.getColumnIndexOrThrow(_cursor, "codigoEnderecoEntrega");
          final int _cursorIndexOfCondicaoPagamento = CursorUtil.getColumnIndexOrThrow(_cursor, "condicaoPagamento");
          final int _cursorIndexOfNumeroParcelas = CursorUtil.getColumnIndexOrThrow(_cursor, "numeroParcelas");
          final int _cursorIndexOfValorSubtotal = CursorUtil.getColumnIndexOrThrow(_cursor, "valorSubtotal");
          final int _cursorIndexOfValorFrete = CursorUtil.getColumnIndexOrThrow(_cursor, "valorFrete");
          final int _cursorIndexOfValorTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "valorTotal");
          final int _cursorIndexOfDataPedido = CursorUtil.getColumnIndexOrThrow(_cursor, "dataPedido");
          final PedidoVenda _result;
          if (_cursor.moveToFirst()) {
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpNumeroPedido;
            if (_cursor.isNull(_cursorIndexOfNumeroPedido)) {
              _tmpNumeroPedido = null;
            } else {
              _tmpNumeroPedido = _cursor.getString(_cursorIndexOfNumeroPedido);
            }
            final int _tmpCodigoCliente;
            _tmpCodigoCliente = _cursor.getInt(_cursorIndexOfCodigoCliente);
            final Integer _tmpCodigoEnderecoEntrega;
            if (_cursor.isNull(_cursorIndexOfCodigoEnderecoEntrega)) {
              _tmpCodigoEnderecoEntrega = null;
            } else {
              _tmpCodigoEnderecoEntrega = _cursor.getInt(_cursorIndexOfCodigoEnderecoEntrega);
            }
            final String _tmpCondicaoPagamento;
            if (_cursor.isNull(_cursorIndexOfCondicaoPagamento)) {
              _tmpCondicaoPagamento = null;
            } else {
              _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
            }
            final int _tmpNumeroParcelas;
            _tmpNumeroParcelas = _cursor.getInt(_cursorIndexOfNumeroParcelas);
            final double _tmpValorSubtotal;
            _tmpValorSubtotal = _cursor.getDouble(_cursorIndexOfValorSubtotal);
            final double _tmpValorFrete;
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
            final double _tmpValorTotal;
            _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
            final String _tmpDataPedido;
            if (_cursor.isNull(_cursorIndexOfDataPedido)) {
              _tmpDataPedido = null;
            } else {
              _tmpDataPedido = _cursor.getString(_cursorIndexOfDataPedido);
            }
            _result = new PedidoVenda(_tmpCodigo,_tmpNumeroPedido,_tmpCodigoCliente,_tmpCodigoEnderecoEntrega,_tmpCondicaoPagamento,_tmpNumeroParcelas,_tmpValorSubtotal,_tmpValorFrete,_tmpValorTotal,_tmpDataPedido);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
