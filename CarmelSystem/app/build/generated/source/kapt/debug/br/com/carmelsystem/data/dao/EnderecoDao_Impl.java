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
import br.com.carmelsystem.data.model.Endereco;
import java.lang.Class;
import java.lang.Exception;
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
public final class EnderecoDao_Impl implements EnderecoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Endereco> __insertionAdapterOfEndereco;

  private final EntityDeletionOrUpdateAdapter<Endereco> __deletionAdapterOfEndereco;

  private final EntityDeletionOrUpdateAdapter<Endereco> __updateAdapterOfEndereco;

  public EnderecoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEndereco = new EntityInsertionAdapter<Endereco>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `endereco` (`codigo`,`logradouro`,`numero`,`bairro`,`cidade`,`uf`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Endereco entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getLogradouro() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLogradouro());
        }
        if (entity.getNumero() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNumero());
        }
        if (entity.getBairro() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBairro());
        }
        if (entity.getCidade() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCidade());
        }
        if (entity.getUf() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getUf());
        }
      }
    };
    this.__deletionAdapterOfEndereco = new EntityDeletionOrUpdateAdapter<Endereco>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `endereco` WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Endereco entity) {
        statement.bindLong(1, entity.getCodigo());
      }
    };
    this.__updateAdapterOfEndereco = new EntityDeletionOrUpdateAdapter<Endereco>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `endereco` SET `codigo` = ?,`logradouro` = ?,`numero` = ?,`bairro` = ?,`cidade` = ?,`uf` = ? WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Endereco entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getLogradouro() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getLogradouro());
        }
        if (entity.getNumero() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNumero());
        }
        if (entity.getBairro() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBairro());
        }
        if (entity.getCidade() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCidade());
        }
        if (entity.getUf() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getUf());
        }
        statement.bindLong(7, entity.getCodigo());
      }
    };
  }

  @Override
  public Object insert(final Endereco endereco, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfEndereco.insertAndReturnId(endereco);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Endereco endereco, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEndereco.handle(endereco);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Endereco endereco, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEndereco.handle(endereco);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Endereco>> getAll() {
    final String _sql = "SELECT * FROM endereco ORDER BY cidade ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"endereco"}, new Callable<List<Endereco>>() {
      @Override
      @NonNull
      public List<Endereco> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfLogradouro = CursorUtil.getColumnIndexOrThrow(_cursor, "logradouro");
          final int _cursorIndexOfNumero = CursorUtil.getColumnIndexOrThrow(_cursor, "numero");
          final int _cursorIndexOfBairro = CursorUtil.getColumnIndexOrThrow(_cursor, "bairro");
          final int _cursorIndexOfCidade = CursorUtil.getColumnIndexOrThrow(_cursor, "cidade");
          final int _cursorIndexOfUf = CursorUtil.getColumnIndexOrThrow(_cursor, "uf");
          final List<Endereco> _result = new ArrayList<Endereco>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Endereco _item;
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpLogradouro;
            if (_cursor.isNull(_cursorIndexOfLogradouro)) {
              _tmpLogradouro = null;
            } else {
              _tmpLogradouro = _cursor.getString(_cursorIndexOfLogradouro);
            }
            final String _tmpNumero;
            if (_cursor.isNull(_cursorIndexOfNumero)) {
              _tmpNumero = null;
            } else {
              _tmpNumero = _cursor.getString(_cursorIndexOfNumero);
            }
            final String _tmpBairro;
            if (_cursor.isNull(_cursorIndexOfBairro)) {
              _tmpBairro = null;
            } else {
              _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
            }
            final String _tmpCidade;
            if (_cursor.isNull(_cursorIndexOfCidade)) {
              _tmpCidade = null;
            } else {
              _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
            }
            final String _tmpUf;
            if (_cursor.isNull(_cursorIndexOfUf)) {
              _tmpUf = null;
            } else {
              _tmpUf = _cursor.getString(_cursorIndexOfUf);
            }
            _item = new Endereco(_tmpCodigo,_tmpLogradouro,_tmpNumero,_tmpBairro,_tmpCidade,_tmpUf);
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
  public Object getById(final int codigo, final Continuation<? super Endereco> $completion) {
    final String _sql = "SELECT * FROM endereco WHERE codigo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, codigo);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Endereco>() {
      @Override
      @Nullable
      public Endereco call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfLogradouro = CursorUtil.getColumnIndexOrThrow(_cursor, "logradouro");
          final int _cursorIndexOfNumero = CursorUtil.getColumnIndexOrThrow(_cursor, "numero");
          final int _cursorIndexOfBairro = CursorUtil.getColumnIndexOrThrow(_cursor, "bairro");
          final int _cursorIndexOfCidade = CursorUtil.getColumnIndexOrThrow(_cursor, "cidade");
          final int _cursorIndexOfUf = CursorUtil.getColumnIndexOrThrow(_cursor, "uf");
          final Endereco _result;
          if (_cursor.moveToFirst()) {
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpLogradouro;
            if (_cursor.isNull(_cursorIndexOfLogradouro)) {
              _tmpLogradouro = null;
            } else {
              _tmpLogradouro = _cursor.getString(_cursorIndexOfLogradouro);
            }
            final String _tmpNumero;
            if (_cursor.isNull(_cursorIndexOfNumero)) {
              _tmpNumero = null;
            } else {
              _tmpNumero = _cursor.getString(_cursorIndexOfNumero);
            }
            final String _tmpBairro;
            if (_cursor.isNull(_cursorIndexOfBairro)) {
              _tmpBairro = null;
            } else {
              _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
            }
            final String _tmpCidade;
            if (_cursor.isNull(_cursorIndexOfCidade)) {
              _tmpCidade = null;
            } else {
              _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
            }
            final String _tmpUf;
            if (_cursor.isNull(_cursorIndexOfUf)) {
              _tmpUf = null;
            } else {
              _tmpUf = _cursor.getString(_cursorIndexOfUf);
            }
            _result = new Endereco(_tmpCodigo,_tmpLogradouro,_tmpNumero,_tmpBairro,_tmpCidade,_tmpUf);
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
