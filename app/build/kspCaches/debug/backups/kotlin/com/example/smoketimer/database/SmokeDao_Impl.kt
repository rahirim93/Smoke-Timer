package com.example.smoketimer.database

import androidx.lifecycle.LiveData
import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performBlocking
import androidx.sqlite.SQLiteStatement
import java.util.Calendar
import java.util.UUID
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class SmokeDao_Impl(
  __db: RoomDatabase,
) : SmokeDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfSmokeEntity: EntityInsertAdapter<SmokeEntity>

  private val __smokeTypeConverters: SmokeTypeConverters = SmokeTypeConverters()

  private val __deleteAdapterOfSmokeEntity: EntityDeleteOrUpdateAdapter<SmokeEntity>

  private val __updateAdapterOfSmokeEntity: EntityDeleteOrUpdateAdapter<SmokeEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfSmokeEntity = object : EntityInsertAdapter<SmokeEntity>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `SmokeEntity` (`id`,`date`) VALUES (?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: SmokeEntity) {
        val _tmp: String? = __smokeTypeConverters.fromUUID(entity.id)
        if (_tmp == null) {
          statement.bindNull(1)
        } else {
          statement.bindText(1, _tmp)
        }
        val _tmp_1: Long? = __smokeTypeConverters.fromDate(entity.date)
        if (_tmp_1 == null) {
          statement.bindNull(2)
        } else {
          statement.bindLong(2, _tmp_1)
        }
      }
    }
    this.__deleteAdapterOfSmokeEntity = object : EntityDeleteOrUpdateAdapter<SmokeEntity>() {
      protected override fun createQuery(): String = "DELETE FROM `SmokeEntity` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SmokeEntity) {
        val _tmp: String? = __smokeTypeConverters.fromUUID(entity.id)
        if (_tmp == null) {
          statement.bindNull(1)
        } else {
          statement.bindText(1, _tmp)
        }
      }
    }
    this.__updateAdapterOfSmokeEntity = object : EntityDeleteOrUpdateAdapter<SmokeEntity>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `SmokeEntity` SET `id` = ?,`date` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: SmokeEntity) {
        val _tmp: String? = __smokeTypeConverters.fromUUID(entity.id)
        if (_tmp == null) {
          statement.bindNull(1)
        } else {
          statement.bindText(1, _tmp)
        }
        val _tmp_1: Long? = __smokeTypeConverters.fromDate(entity.date)
        if (_tmp_1 == null) {
          statement.bindNull(2)
        } else {
          statement.bindLong(2, _tmp_1)
        }
        val _tmp_2: String? = __smokeTypeConverters.fromUUID(entity.id)
        if (_tmp_2 == null) {
          statement.bindNull(3)
        } else {
          statement.bindText(3, _tmp_2)
        }
      }
    }
  }

  public override fun addItem(item: SmokeEntity): Unit = performBlocking(__db, false, true) { _connection ->
    __insertAdapterOfSmokeEntity.insert(_connection, item)
  }

  public override fun deleteItem(item: SmokeEntity): Unit = performBlocking(__db, false, true) { _connection ->
    __deleteAdapterOfSmokeEntity.handle(_connection, item)
  }

  public override fun updateItem(item: SmokeEntity): Unit = performBlocking(__db, false, true) { _connection ->
    __updateAdapterOfSmokeEntity.handle(_connection, item)
  }

  public override fun getItems(): LiveData<List<SmokeEntity>> {
    val _sql: String = "SELECT * FROM SmokeEntity ORDER BY date DESC"
    return __db.invalidationTracker.createLiveData(arrayOf("SmokeEntity"), false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _result: MutableList<SmokeEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: SmokeEntity
          val _tmpId: UUID
          val _tmp: String?
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmp = null
          } else {
            _tmp = _stmt.getText(_columnIndexOfId)
          }
          val _tmp_1: UUID? = __smokeTypeConverters.toUUID(_tmp)
          if (_tmp_1 == null) {
            error("Expected NON-NULL 'java.util.UUID', but it was NULL.")
          } else {
            _tmpId = _tmp_1
          }
          val _tmpDate: Calendar
          val _tmp_2: Long?
          if (_stmt.isNull(_columnIndexOfDate)) {
            _tmp_2 = null
          } else {
            _tmp_2 = _stmt.getLong(_columnIndexOfDate)
          }
          val _tmp_3: Calendar? = __smokeTypeConverters.toDate(_tmp_2)
          if (_tmp_3 == null) {
            error("Expected NON-NULL 'java.util.Calendar', but it was NULL.")
          } else {
            _tmpDate = _tmp_3
          }
          _item = SmokeEntity(_tmpId,_tmpDate)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getItemById(id: String): LiveData<SmokeEntity?> {
    val _sql: String = "SELECT * FROM SmokeEntity WHERE id = ?"
    return __db.invalidationTracker.createLiveData(arrayOf("SmokeEntity"), false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _result: SmokeEntity?
        if (_stmt.step()) {
          val _tmpId: UUID
          val _tmp: String?
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmp = null
          } else {
            _tmp = _stmt.getText(_columnIndexOfId)
          }
          val _tmp_1: UUID? = __smokeTypeConverters.toUUID(_tmp)
          if (_tmp_1 == null) {
            error("Expected NON-NULL 'java.util.UUID', but it was NULL.")
          } else {
            _tmpId = _tmp_1
          }
          val _tmpDate: Calendar
          val _tmp_2: Long?
          if (_stmt.isNull(_columnIndexOfDate)) {
            _tmp_2 = null
          } else {
            _tmp_2 = _stmt.getLong(_columnIndexOfDate)
          }
          val _tmp_3: Calendar? = __smokeTypeConverters.toDate(_tmp_2)
          if (_tmp_3 == null) {
            error("Expected NON-NULL 'java.util.Calendar', but it was NULL.")
          } else {
            _tmpDate = _tmp_3
          }
          _result = SmokeEntity(_tmpId,_tmpDate)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
