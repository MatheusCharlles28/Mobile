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
import br.com.carmelsystem.data.model.Item;
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
public final class ItemDao_Impl implements ItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Item> __insertionAdapterOfItem;

  private final EntityDeletionOrUpdateAdapter<Item> __deletionAdapterOfItem;

  private final EntityDeletionOrUpdateAdapter<Item> __updateAdapterOfItem;

  public ItemDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItem = new EntityInsertionAdapter<Item>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `item` (`codigo`,`descricao`,`valorUnit`,`unidadeMedia`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Item entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getDescricao() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDescricao());
        }
        statement.bindDouble(3, entity.getValorUnit());
        if (entity.getUnidadeMedia() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getUnidadeMedia());
        }
      }
    };
    this.__deletionAdapterOfItem = new EntityDeletionOrUpdateAdapter<Item>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `item` WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Item entity) {
        statement.bindLong(1, entity.getCodigo());
      }
    };
    this.__updateAdapterOfItem = new EntityDeletionOrUpdateAdapter<Item>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `item` SET `codigo` = ?,`descricao` = ?,`valorUnit` = ?,`unidadeMedia` = ? WHERE `codigo` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Item entity) {
        statement.bindLong(1, entity.getCodigo());
        if (entity.getDescricao() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDescricao());
        }
        statement.bindDouble(3, entity.getValorUnit());
        if (entity.getUnidadeMedia() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getUnidadeMedia());
        }
        statement.bindLong(5, entity.getCodigo());
      }
    };
  }

  @Override
  public Object insert(final Item item, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfItem.insertAndReturnId(item);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Item item, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfItem.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Item item, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfItem.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Item>> getAll() {
    final String _sql = "SELECT * FROM item ORDER BY descricao ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"item"}, new Callable<List<Item>>() {
      @Override
      @NonNull
      public List<Item> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
          final int _cursorIndexOfValorUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "valorUnit");
          final int _cursorIndexOfUnidadeMedia = CursorUtil.getColumnIndexOrThrow(_cursor, "unidadeMedia");
          final List<Item> _result = new ArrayList<Item>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Item _item;
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpDescricao;
            if (_cursor.isNull(_cursorIndexOfDescricao)) {
              _tmpDescricao = null;
            } else {
              _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
            }
            final double _tmpValorUnit;
            _tmpValorUnit = _cursor.getDouble(_cursorIndexOfValorUnit);
            final String _tmpUnidadeMedia;
            if (_cursor.isNull(_cursorIndexOfUnidadeMedia)) {
              _tmpUnidadeMedia = null;
            } else {
              _tmpUnidadeMedia = _cursor.getString(_cursorIndexOfUnidadeMedia);
            }
            _item = new Item(_tmpCodigo,_tmpDescricao,_tmpValorUnit,_tmpUnidadeMedia);
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
  public Object getById(final int codigo, final Continuation<? super Item> $completion) {
    final String _sql = "SELECT * FROM item WHERE codigo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, codigo);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Item>() {
      @Override
      @Nullable
      public Item call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
          final int _cursorIndexOfValorUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "valorUnit");
          final int _cursorIndexOfUnidadeMedia = CursorUtil.getColumnIndexOrThrow(_cursor, "unidadeMedia");
          final Item _result;
          if (_cursor.moveToFirst()) {
            final int _tmpCodigo;
            _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
            final String _tmpDescricao;
            if (_cursor.isNull(_cursorIndexOfDescricao)) {
              _tmpDescricao = null;
            } else {
              _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
            }
            final double _tmpValorUnit;
            _tmpValorUnit = _cursor.getDouble(_cursorIndexOfValorUnit);
            final String _tmpUnidadeMedia;
            if (_cursor.isNull(_cursorIndexOfUnidadeMedia)) {
              _tmpUnidadeMedia = null;
            } else {
              _tmpUnidadeMedia = _cursor.getString(_cursorIndexOfUnidadeMedia);
            }
            _result = new Item(_tmpCodigo,_tmpDescricao,_tmpValorUnit,_tmpUnidadeMedia);
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
