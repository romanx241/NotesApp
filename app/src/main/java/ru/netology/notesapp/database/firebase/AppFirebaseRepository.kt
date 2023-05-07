package ru.netology.notesapp.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import ru.netology.notesapp.database.DatabaseRepository
import ru.netology.notesapp.model.Note
import ru.netology.notesapp.utils.LOGIN
import ru.netology.notesapp.utils.PASSWORD

class AppFirebaseRepository : DatabaseRepository {

    private val mAuth = FirebaseAuth.getInstance()

    override val readAll: LiveData<List<Note>>
    get() = TODO()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
    }

    override fun signOut() {
        mAuth.signOut()
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail : (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(LOGIN, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(LOGIN, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
    }
}