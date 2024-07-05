package com.rohit.baseadapter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class student(
    @PrimaryKey(autoGenerate = true)
    var name: String?="",
    var subject: String?="",
    var rollNumber: String = 0.toString()
)
