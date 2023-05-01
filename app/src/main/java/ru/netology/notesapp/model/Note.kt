package ru.netology.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.notesapp.utils.Constants.Keys.NOTES_TABLE

@Entity(tableName = NOTES_TABLE)
data class Note(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val subTitle: String
)
