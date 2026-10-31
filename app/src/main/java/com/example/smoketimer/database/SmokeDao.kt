package com.example.smoketimer.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface SmokeDao {

    @Query("SELECT * FROM SmokeEntity ORDER BY date DESC")
    fun getItems(): LiveData<List<SmokeEntity>>

    @Query("SELECT * FROM SmokeEntity WHERE id = :id")
    fun getItemById(id: String) : LiveData<SmokeEntity?>

    @Insert
    fun addItem(item: SmokeEntity)

    @Update
    fun updateItem(item: SmokeEntity)

    @Delete
    fun deleteItem(item: SmokeEntity)

}