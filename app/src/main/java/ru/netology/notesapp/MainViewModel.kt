package ru.netology.notesapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import ru.netology.notesapp.model.Note
import ru.netology.notesapp.utils.TYPE_FIREBASE
import ru.netology.notesapp.utils.TYPE_ROOM

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    fun initDatabase(type: String) {
        dbType.value = type
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
    }

    init {
        readTest.value = when (dbType.value) {
            TYPE_ROOM -> {
                listOf<Note>(
                    Note(title = "Note 1", subTitle = "SubTitle for note 1"),
                    Note(title = "Note 2", subTitle = "SubTitle for note 2"),
                    Note(title = "Note 3", subTitle = "SubTitle for note 3"),
                    Note(title = "Note 4", subTitle = "SubTitle for note 4"),
                )
            }
            TYPE_FIREBASE -> listOf()
            else -> listOf()
        }
    }
}


class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}