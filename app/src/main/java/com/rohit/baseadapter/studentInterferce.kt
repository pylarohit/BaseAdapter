package com.rohit.baseadapter

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface studentInterferce {
    @Insert
    fun Insertstudent(student: student)
}