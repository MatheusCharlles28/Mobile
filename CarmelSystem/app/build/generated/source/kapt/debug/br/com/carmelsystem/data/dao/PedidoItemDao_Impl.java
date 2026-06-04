package br.com.carmelsystem.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import br.com.carmelsystem.data.model.PedidoItem;
import java.lang.Class;
import java.lang.Exception;
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

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PedidoItemDao_Impl implements PedidoItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PedidoItem> __insertionAdapterOfPedidoItem;

  public PedidoItemDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPedidoItem = new EntityInsertionAdapter<PedidoItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `pedido_item` (`id`,`codigoPedido`,`codigoItem`,`descricaoItem`,`quantidade`,`valorUnitario`,`unidadeMedida`,`valorTotal`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PedidoItem entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCodigoPedido());
        statement.bindLong(3, entity.getCodigoItem());
        if (entity.getDescricaoItem() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescricaoItem());
        }
        statement.bindDouble(5, entity.getQuantidade());
        statement.bindDouble(6, entity.getValorUnitario());
        if (entity.getUnidadeMedida() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getUnidadeMedida());
        }
        statement.bindDouble(8, entity.getValorTotal());
      }
    };
  }

  @Override
  public Object insertAll(final List<PedidoItem> itens,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPedidoItem.insert(itens);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getItensByPedidoSync(final int codigoPedido,
      final Continuation<? super List<PedidoItem>> $completion) {
    final String _sql = "SELECT * FROM pedido_item WHERE codigoPedido = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, codigoPedido);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PedidoItem>>() {
      @Override
      @NonNull
      public List<PedidoItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCodigoPedido = CursorUtil.getColumnIndexOrThrow(_cursor, "codigoPedido");
          final int _cursorIndexOfCodigoItem = CursorUtil.getColumnIndexOrThrow(_cursor, "codigoItem");
          final int _cursorIndexOfDescricaoItem = CursorUtil.getColumnIndexOrThrow(_cursor, "descricaoItem");
          final int _cursorIndexOfQuantidade = CursorUtil.getColumnIndexOrThrow(_cursor, "quantidade");
          final int _cursorIndexOfValorUnitario = CursorUtil.getColumnIndexOrThrow(_cursor, "valorUnitario");
          final int _cursorIndexOfUnidadeMedida = CursorUtil.getColumnIndexOrThrow(_cursor, "unidadeMedida");
          final int _cursorIndexOfValorTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "valorTotal");
          final List<PedidoItem> _result = new ArrayList<PedidoItem>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PedidoItem _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpCodigoPedido;
            _tmpCodigoPedido = _cursor.getInt(_cursorIndexOfCodigoPedido);
            final int _tmpCodigoItem;
            _tmpCodigoItem = _cursor.getInt(_cursorIndexOfCodigoItem);
            final String _tmpDescricaoItem;
            if (_cursor.isNull(_cursorIndexOfDescricaoItem)) {
              _tmpDescricaoItem = null;
            } else {
              _tmpDescricaoItem = _cursor.getString(_cursorIndexOfDescricaoItem);
            }
            final double _tmpQuantidade;
            _tmpQuantidade = _cursor.getDouble(_cursorIndexOfQuantidade);
            final double _tmpValorUnitario;
            _tmpValorUnitario = _cursor.getDouble(_cursorIndexOfValorUnitario);
            final String _tmpUnidadeMedida;
            if (_cursor.isNull(_cursorIndexOfUnidadeMedida)) {
              _tmpUnidadeMedida = null;
            } else {
              _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
            }
            final double _tmpValorTotal;
            _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
            _item = new PedidoItem(_tmpId,_tmpCodigoPedido,_tmpCodigoItem,_tmpDescricaoItem,_tmpQuantidade,_tmpValorUnitario,_tmpUnidadeMedida,_tmpValorTotal);
            _result.add(_item);
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
