package com.example.smoketimer

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.smoketimer.database.SmokeDatabase
import com.example.smoketimer.database.SmokeEntity
import java.lang.IllegalStateException
import java.util.concurrent.Executors

private const val DATABASE_NAME = "smokeApp_database"

class MyAppRepository private constructor(context: Context){

    private val database : SmokeDatabase = Room.databaseBuilder(
        context.applicationContext,
        SmokeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val smokeDao = database.smokeDao()

    private val executor = Executors.newSingleThreadExecutor()

    fun getItems(): LiveData<List<SmokeEntity>> = smokeDao.getItems()

    fun getItemById(id: String): LiveData<SmokeEntity?> = smokeDao.getItemById(id)

    fun addItem(item: SmokeEntity) {
        executor.execute {
            smokeDao.addItem(item)
        }
    }

    fun updateItem(item: SmokeEntity){
        executor.execute {
            smokeDao.updateItem(item)
        }
    }

    fun deleteItem(item: SmokeEntity){
        executor.execute {
            smokeDao.deleteItem(item)
        }
    }

    companion object {
        private var INSTANCE: MyAppRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = MyAppRepository(context)
            }
        }

        fun get(): MyAppRepository {
            return INSTANCE ?:
            throw IllegalStateException("MyAppRepository must be initialized")
        }
    }

}