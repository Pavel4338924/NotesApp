package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.notesapp.ui.AddNoteScreen
import com.example.notesapp.ui.NoteListScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var showAdd by remember { mutableStateOf(false) }

                    if (showAdd) {
                        AddNoteScreen(onBack = { showAdd = false })
                    } else {
                        NoteListScreen(onAddNote = { showAdd = true })
                    }
                }
            }
        }
    }
}
