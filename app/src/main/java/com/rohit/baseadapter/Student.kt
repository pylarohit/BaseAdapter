package com.rohit.baseadapter

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomSQLiteQuery

@Entity
class Student(
    @PrimaryKey(autoGenerate = true)
    var rollNumber: Int = 0,
    var name: String?="",
    var subject: String?="",
)
