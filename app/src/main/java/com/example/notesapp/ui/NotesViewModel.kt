package com.example.notesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.notesapp.data.Note

class NotesViewModel : ViewModel() {

    private val _notes = MutableStateFlow(listOf<Note>())
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    fun addNote(title: String, text: String) {
        val note = Note(title = title, text = text)
        viewModelScope.launch {
            _notes.update { listOf(note) + it }
        }
    }

    fun deleteNote(id: String) {
        viewModelScope.launch {
            _notes.update { it.filter { it.id != id } }
        }
    }
}
