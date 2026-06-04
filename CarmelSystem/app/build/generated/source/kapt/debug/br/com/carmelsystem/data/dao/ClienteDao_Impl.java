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
import br.com.carmelsystem.data.model.Cliente;
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
public final class ClienteDao_Impl implements ClienteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cliente> __insertionAdapterOfCliente;

  private final EntityDeletionOrUpdateAdapter<Cliente> __deletionAdapterOfCliente;

  private final EntityDeletionOrUpdateAdapter<Cliente> __updateAdapterOfCliente;

  public ClienteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCliente = new EntityInsertionAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `cliente` (`codigo`,`nome`,`cpf`,`dataNasc`,`codigoEndereco`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getCpf() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCpf());
        }
        if (entity.getDataNasc() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDataNasc());
        }
        if (entity.getCodigoEndereco() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getCodigoEndereco());
        }
      }
    };
    this.__deletionAdapterOfCliente = new EntityDeletionOrUpdateAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `cliente` WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getCodigo());
      }
    };
    this.__updateAdapterOfCliente = new EntityDeletionOrUpdateAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `cliente` SET `codigo` = ?,`nome` = ?,`cpf` = ?,`dataNasc` = ?,`codigoEndereco` = ? WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getCpf() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCpf());
        }
        if (entity.getDataNasc() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDataNasc());
        }
        if (entity.getCodigoEndereco() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getCodigoEndereco());
        }
        statement.bindLong(6, entity.getCodigo());
      }
    };
  }

  @Override
  public Object insert(final Cliente cliente, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCliente.insertAndReturnId(cliente);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Cliente cliente, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCliente.handle(cliente);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Cliente cliente, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCliente.handle(cliente);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Cliente>> getAll() {
    final String _sql = "SELECT * FROM cliente ORDER BY nome ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"cliente"}, new Callable<List<Cliente>>() {
      @Override
      @NonNull
      public List<Cliente> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfCpf = CursorUtil.getColumnIndexOrThrow(_cursor, "cpf");
          final int _cursorIndexOfDataNasc = CursorUtil.getColumnIndexOrThrow(_cursor, "dataNasc");
          final int _cursorIndexOfCodigoEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "codigoEndereco");
          final List<Cliente> _result = new ArrayList<Cliente>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Cliente _item;
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpCpf;
            if (_cursor.isNull(_cursorIndexOfCpf)) {
              _tmpCpf = null;
            } else {
              _tmpCpf = _cursor.getString(_cursorIndexOfCpf);
            }
            final String _tmpDataNasc;
            if (_cursor.isNull(_cursorIndexOfDataNasc)) {
              _tmpDataNasc = null;
            } else {
              _tmpDataNasc = _cursor.getString(_cursorIndexOfDataNasc);
            }
            final Integer _tmpCodigoEndereco;
            if (_cursor.isNull(_cursorIndexOfCodigoEndereco)) {
              _tmpCodigoEndereco = null;
            } else {
              _tmpCodigoEndereco = _cursor.getInt(_cursorIndexOfCodigoEndereco);
            }
            _item = new Cliente(_tmpCodigo,_tmpNome,_tmpCpf,_tmpDataNasc,_tmpCodigoEndereco);
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
  public Object getById(final int codigo, final Continuation<? super Cliente> $completion) {
    final String _sql = "SELECT * FROM cliente WHERE codigo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, codigo);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Cliente>() {
      @Override
      @Nullable
      public Cliente call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfCpf = CursorUtil.getColumnIndexOrThrow(_cursor, "cpf");
          final int _cursorIndexOfDataNasc = CursorUtil.getColumnIndexOrThrow(_cursor, "dataNasc");
          final int _cursorIndexOfCodigoEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "codigoEndereco");
          final Cliente _result;
          if (_cursor.moveToFirst()) {
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpCpf;
            if (_cursor.isNull(_cursorIndexOfCpf)) {
              _tmpCpf = null;
            } else {
              _tmpCpf = _cursor.getString(_cursorIndexOfCpf);
            }
            final String _tmpDataNasc;
            if (_cursor.isNull(_cursorIndexOfDataNasc)) {
              _tmpDataNasc = null;
            } else {
              _tmpDataNasc = _cursor.getString(_cursorIndexOfDataNasc);
            }
            final Integer _tmpCodigoEndereco;
            if (_cursor.isNull(_cursorIndexOfCodigoEndereco)) {
              _tmpCodigoEndereco = null;
            } else {
              _tmpCodigoEndereco = _cursor.getInt(_cursorIndexOfCodigoEndereco);
            }
            _result = new Cliente(_tmpCodigo,_tmpNome,_tmpCpf,_tmpDataNasc,_tmpCodigoEndereco);
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
