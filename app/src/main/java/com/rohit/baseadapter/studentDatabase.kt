package com.rohit.baseadapter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [studentDatabase::class], version = 1, exportSchema = true)
abstract class studentDatabase: RoomDatabase() {
    abstract fun studentInterferce(): studentInterferce

    companion object{
        private var studentdatabase : studentDatabase? =null
        fun getInstance(context: Context): studentDatabase{
            if(studentdatabase == null){
                studentdatabase = Room.databaseBuilder(context,
                    studentDatabase::class.java,
                    .allowMainThreadQueries()
                    "TodoDatabase")

            }
            return studentdatabase!!
        }
    }
}