package ru.netology.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val subTitle: String
)
