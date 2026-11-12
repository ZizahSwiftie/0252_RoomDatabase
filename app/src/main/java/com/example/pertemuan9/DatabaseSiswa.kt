package com.example.pertemuan9

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDatabase() {
    abstract fun siswaDao(): SiswaDao

    companion object {
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    klass = DatabaseSiswa::class.java,
                    context = context,
                    name = "siswa_database"
                ).build().also { Instance = it }
            })
        }
    }
}
