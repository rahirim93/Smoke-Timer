package com.example.smoketimer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class SmokeEntity(@PrimaryKey var id: UUID = UUID.randomUUID(),
                        var date: Calendar = Calendar.getInstance())