package com.rohit.baseadapter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1, exportSchema = true)
abstract class StudentDatabase: RoomDatabase() {
    abstract fun studentInterferce(): StudentInterferce

    companion object{
        private var studentdatabase : StudentDatabase? =null
        fun getInstance(context: Context): StudentDatabase{
            if(studentdatabase == null){
                studentdatabase = Room.databaseBuilder(context,
                    StudentDatabase::class.java,
                    "TodoDatabase")
                    .allowMainThreadQueries()
                    .build()

            }
            return studentdatabase!!
        }
    }
}