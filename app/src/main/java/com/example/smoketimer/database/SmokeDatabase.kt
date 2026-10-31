package com.example.smoketimer.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [SmokeEntity::class ], version = 1)
@TypeConverters(SmokeTypeConverters::class)
abstract class SmokeDatabase : RoomDatabase() {

    abstract fun smokeDao(): SmokeDao

}