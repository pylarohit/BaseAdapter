package com.rohit.baseadapter

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentInterferce {
    @Insert
    fun Insertstudent(student: Student)
    @Query("SELECT * FROM student")
    fun getList() : List<Student>

    @Update
    fun UpdateStudent(student : Student)

    @Delete
    fun DeleteStudent(student: Student)
}