package ru.netology.notesapp.database.room.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.netology.notesapp.model.Note
import ru.netology.notesapp.utils.Constants.Keys.NOTE_DATABASE

@Database(entities = [Note :: class], version = 1)

abstract class AppRoomDatabase : RoomDatabase(){

    abstract fun getRoomDao() : NoteRoomDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context) : AppRoomDatabase {
            return if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    NOTE_DATABASE
                ).build()
                INSTANCE as AppRoomDatabase
            } else INSTANCE as AppRoomDatabase
            }
        }
    }
