package br.com.carmelsystem.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import br.com.carmelsystem.data.dao.ClienteDao;
import br.com.carmelsystem.data.dao.ClienteDao_Impl;
import br.com.carmelsystem.data.dao.EnderecoDao;
import br.com.carmelsystem.data.dao.EnderecoDao_Impl;
import br.com.carmelsystem.data.dao.ItemDao;
import br.com.carmelsystem.data.dao.ItemDao_Impl;
import br.com.carmelsystem.data.dao.PedidoItemDao;
import br.com.carmelsystem.data.dao.PedidoItemDao_Impl;
import br.com.carmelsystem.data.dao.PedidoVendaDao;
import br.com.carmelsystem.data.dao.PedidoVendaDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile EnderecoDao _enderecoDao;

  private volatile ClienteDao _clienteDao;

  private volatile ItemDao _itemDao;

  private volatile PedidoVendaDao _pedidoVendaDao;

  private volatile PedidoItemDao _pedidoItemDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `endereco` (`codigo` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `logradouro` TEXT NOT NULL, `numero` TEXT NOT NULL, `bairro` TEXT NOT NULL, `cidade` TEXT NOT NULL, `uf` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `cliente` (`codigo` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `cpf` TEXT NOT NULL, `dataNasc` TEXT NOT NULL, `codigoEndereco` INTEGER, FOREIGN KEY(`codigoEndereco`) REFERENCES `endereco`(`codigo`) ON UPDATE NO ACTION ON DELETE SET NULL )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_cliente_codigoEndereco` ON `cliente` (`codigoEndereco`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `item` (`codigo` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `descricao` TEXT NOT NULL, `valorUnit` REAL NOT NULL, `unidadeMedia` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `pedido_venda` (`codigo` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `numeroPedido` TEXT NOT NULL, `codigoCliente` INTEGER NOT NULL, `codigoEnderecoEntrega` INTEGER, `condicaoPagamento` TEXT NOT NULL, `numeroParcelas` INTEGER NOT NULL, `valorSubtotal` REAL NOT NULL, `valorFrete` REAL NOT NULL, `valorTotal` REAL NOT NULL, `dataPedido` TEXT NOT NULL, FOREIGN KEY(`codigoCliente`) REFERENCES `cliente`(`codigo`) ON UPDATE NO ACTION ON DELETE RESTRICT , FOREIGN KEY(`codigoEnderecoEntrega`) REFERENCES `endereco`(`codigo`) ON UPDATE NO ACTION ON DELETE SET NULL )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_pedido_venda_codigoCliente` ON `pedido_venda` (`codigoCliente`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_pedido_venda_codigoEnderecoEntrega` ON `pedido_venda` (`codigoEnderecoEntrega`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `pedido_item` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `codigoPedido` INTEGER NOT NULL, `codigoItem` INTEGER NOT NULL, `descricaoItem` TEXT NOT NULL, `quantidade` REAL NOT NULL, `valorUnitario` REAL NOT NULL, `unidadeMedida` TEXT NOT NULL, `valorTotal` REAL NOT NULL, FOREIGN KEY(`codigoPedido`) REFERENCES `pedido_venda`(`codigo`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`codigoItem`) REFERENCES `item`(`codigo`) ON UPDATE NO ACTION ON DELETE RESTRICT )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_pedido_item_codigoPedido` ON `pedido_item` (`codigoPedido`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_pedido_item_codigoItem` ON `pedido_item` (`codigoItem`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'da25aa6c81a5ae3b4272b7c453b19ae1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `endereco`");
        db.execSQL("DROP TABLE IF EXISTS `cliente`");
        db.execSQL("DROP TABLE IF EXISTS `item`");
        db.execSQL("DROP TABLE IF EXISTS `pedido_venda`");
        db.execSQL("DROP TABLE IF EXISTS `pedido_item`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsEndereco = new HashMap<String, TableInfo.Column>(6);
        _columnsEndereco.put("codigo", new TableInfo.Column("codigo", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("logradouro", new TableInfo.Column("logradouro", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("numero", new TableInfo.Column("numero", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("bairro", new TableInfo.Column("bairro", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("cidade", new TableInfo.Column("cidade", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("uf", new TableInfo.Column("uf", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEndereco = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEndereco = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEndereco = new TableInfo("endereco", _columnsEndereco, _foreignKeysEndereco, _indicesEndereco);
        final TableInfo _existingEndereco = TableInfo.read(db, "endereco");
        if (!_infoEndereco.equals(_existingEndereco)) {
          return new RoomOpenHelper.ValidationResult(false, "endereco(br.com.carmelsystem.data.model.Endereco).\n"
                  + " Expected:\n" + _infoEndereco + "\n"
                  + " Found:\n" + _existingEndereco);
        }
        final HashMap<String, TableInfo.Column> _columnsCliente = new HashMap<String, TableInfo.Column>(5);
        _columnsCliente.put("codigo", new TableInfo.Column("codigo", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCliente.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCliente.put("cpf", new TableInfo.Column("cpf", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCliente.put("dataNasc", new TableInfo.Column("dataNasc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCliente.put("codigoEndereco", new TableInfo.Column("codigoEndereco", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCliente = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysCliente.add(new TableInfo.ForeignKey("endereco", "SET NULL", "NO ACTION", Arrays.asList("codigoEndereco"), Arrays.asList("codigo")));
        final HashSet<TableInfo.Index> _indicesCliente = new HashSet<TableInfo.Index>(1);
        _indicesCliente.add(new TableInfo.Index("index_cliente_codigoEndereco", false, Arrays.asList("codigoEndereco"), Arrays.asList("ASC")));
        final TableInfo _infoCliente = new TableInfo("cliente", _columnsCliente, _foreignKeysCliente, _indicesCliente);
        final TableInfo _existingCliente = TableInfo.read(db, "cliente");
        if (!_infoCliente.equals(_existingCliente)) {
          return new RoomOpenHelper.ValidationResult(false, "cliente(br.com.carmelsystem.data.model.Cliente).\n"
                  + " Expected:\n" + _infoCliente + "\n"
                  + " Found:\n" + _existingCliente);
        }
        final HashMap<String, TableInfo.Column> _columnsItem = new HashMap<String, TableInfo.Column>(4);
        _columnsItem.put("codigo", new TableInfo.Column("codigo", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("descricao", new TableInfo.Column("descricao", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("valorUnit", new TableInfo.Column("valorUnit", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsItem.put("unidadeMedia", new TableInfo.Column("unidadeMedia", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItem = new TableInfo("item", _columnsItem, _foreignKeysItem, _indicesItem);
        final TableInfo _existingItem = TableInfo.read(db, "item");
        if (!_infoItem.equals(_existingItem)) {
          return new RoomOpenHelper.ValidationResult(false, "item(br.com.carmelsystem.data.model.Item).\n"
                  + " Expected:\n" + _infoItem + "\n"
                  + " Found:\n" + _existingItem);
        }
        final HashMap<String, TableInfo.Column> _columnsPedidoVenda = new HashMap<String, TableInfo.Column>(10);
        _columnsPedidoVenda.put("codigo", new TableInfo.Column("codigo", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("numeroPedido", new TableInfo.Column("numeroPedido", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("codigoCliente", new TableInfo.Column("codigoCliente", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("codigoEnderecoEntrega", new TableInfo.Column("codigoEnderecoEntrega", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("condicaoPagamento", new TableInfo.Column("condicaoPagamento", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("numeroParcelas", new TableInfo.Column("numeroParcelas", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("valorSubtotal", new TableInfo.Column("valorSubtotal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("valorFrete", new TableInfo.Column("valorFrete", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("valorTotal", new TableInfo.Column("valorTotal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoVenda.put("dataPedido", new TableInfo.Column("dataPedido", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPedidoVenda = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysPedidoVenda.add(new TableInfo.ForeignKey("cliente", "RESTRICT", "NO ACTION", Arrays.asList("codigoCliente"), Arrays.asList("codigo")));
        _foreignKeysPedidoVenda.add(new TableInfo.ForeignKey("endereco", "SET NULL", "NO ACTION", Arrays.asList("codigoEnderecoEntrega"), Arrays.asList("codigo")));
        final HashSet<TableInfo.Index> _indicesPedidoVenda = new HashSet<TableInfo.Index>(2);
        _indicesPedidoVenda.add(new TableInfo.Index("index_pedido_venda_codigoCliente", false, Arrays.asList("codigoCliente"), Arrays.asList("ASC")));
        _indicesPedidoVenda.add(new TableInfo.Index("index_pedido_venda_codigoEnderecoEntrega", false, Arrays.asList("codigoEnderecoEntrega"), Arrays.asList("ASC")));
        final TableInfo _infoPedidoVenda = new TableInfo("pedido_venda", _columnsPedidoVenda, _foreignKeysPedidoVenda, _indicesPedidoVenda);
        final TableInfo _existingPedidoVenda = TableInfo.read(db, "pedido_venda");
        if (!_infoPedidoVenda.equals(_existingPedidoVenda)) {
          return new RoomOpenHelper.ValidationResult(false, "pedido_venda(br.com.carmelsystem.data.model.PedidoVenda).\n"
                  + " Expected:\n" + _infoPedidoVenda + "\n"
                  + " Found:\n" + _existingPedidoVenda);
        }
        final HashMap<String, TableInfo.Column> _columnsPedidoItem = new HashMap<String, TableInfo.Column>(8);
        _columnsPedidoItem.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoItem.put("codigoPedido", new TableInfo.Column("codigoPedido", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoItem.put("codigoItem", new TableInfo.Column("codigoItem", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoItem.put("descricaoItem", new TableInfo.Column("descricaoItem", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoItem.put("quantidade", new TableInfo.Column("quantidade", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoItem.put("valorUnitario", new TableInfo.Column("valorUnitario", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoItem.put("unidadeMedida", new TableInfo.Column("unidadeMedida", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPedidoItem.put("valorTotal", new TableInfo.Column("valorTotal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPedidoItem = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysPedidoItem.add(new TableInfo.ForeignKey("pedido_venda", "CASCADE", "NO ACTION", Arrays.asList("codigoPedido"), Arrays.asList("codigo")));
        _foreignKeysPedidoItem.add(new TableInfo.ForeignKey("item", "RESTRICT", "NO ACTION", Arrays.asList("codigoItem"), Arrays.asList("codigo")));
        final HashSet<TableInfo.Index> _indicesPedidoItem = new HashSet<TableInfo.Index>(2);
        _indicesPedidoItem.add(new TableInfo.Index("index_pedido_item_codigoPedido", false, Arrays.asList("codigoPedido"), Arrays.asList("ASC")));
        _indicesPedidoItem.add(new TableInfo.Index("index_pedido_item_codigoItem", false, Arrays.asList("codigoItem"), Arrays.asList("ASC")));
        final TableInfo _infoPedidoItem = new TableInfo("pedido_item", _columnsPedidoItem, _foreignKeysPedidoItem, _indicesPedidoItem);
        final TableInfo _existingPedidoItem = TableInfo.read(db, "pedido_item");
        if (!_infoPedidoItem.equals(_existingPedidoItem)) {
          return new RoomOpenHelper.ValidationResult(false, "pedido_item(br.com.carmelsystem.data.model.PedidoItem).\n"
                  + " Expected:\n" + _infoPedidoItem + "\n"
                  + " Found:\n" + _existingPedidoItem);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "da25aa6c81a5ae3b4272b7c453b19ae1", "7f4f8f8cc3e21f51468119b573684cd9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "endereco","cliente","item","pedido_venda","pedido_item");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `endereco`");
      _db.execSQL("DELETE FROM `cliente`");
      _db.execSQL("DELETE FROM `item`");
      _db.execSQL("DELETE FROM `pedido_venda`");
      _db.execSQL("DELETE FROM `pedido_item`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EnderecoDao.class, EnderecoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ClienteDao.class, ClienteDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ItemDao.class, ItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PedidoVendaDao.class, PedidoVendaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PedidoItemDao.class, PedidoItemDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public EnderecoDao enderecoDao() {
    if (_enderecoDao != null) {
      return _enderecoDao;
    } else {
      synchronized(this) {
        if(_enderecoDao == null) {
          _enderecoDao = new EnderecoDao_Impl(this);
        }
        return _enderecoDao;
      }
    }
  }

  @Override
  public ClienteDao clienteDao() {
    if (_clienteDao != null) {
      return _clienteDao;
    } else {
      synchronized(this) {
        if(_clienteDao == null) {
          _clienteDao = new ClienteDao_Impl(this);
        }
        return _clienteDao;
      }
    }
  }

  @Override
  public ItemDao itemDao() {
    if (_itemDao != null) {
      return _itemDao;
    } else {
      synchronized(this) {
        if(_itemDao == null) {
          _itemDao = new ItemDao_Impl(this);
        }
        return _itemDao;
      }
    }
  }

  @Override
  public PedidoVendaDao pedidoVendaDao() {
    if (_pedidoVendaDao != null) {
      return _pedidoVendaDao;
    } else {
      synchronized(this) {
        if(_pedidoVendaDao == null) {
          _pedidoVendaDao = new PedidoVendaDao_Impl(this);
        }
        return _pedidoVendaDao;
      }
    }
  }

  @Override
  public PedidoItemDao pedidoItemDao() {
    if (_pedidoItemDao != null) {
      return _pedidoItemDao;
    } else {
      synchronized(this) {
        if(_pedidoItemDao == null) {
          _pedidoItemDao = new PedidoItemDao_Impl(this);
        }
        return _pedidoItemDao;
      }
    }
  }
}
