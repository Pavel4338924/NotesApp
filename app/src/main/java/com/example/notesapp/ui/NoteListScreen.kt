package com.example.notesapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesapp.data.Note

@Composable
fun NoteListScreen(
    viewModel: NotesViewModel = NotesViewModel(),
    onAddNote: () -> Unit = {}
) {
    val notes by viewModel.notes.collectAsState()

    Scaffold(
        floatingActionButton = ExtendedFloatingActionButton(
            icon = { Icon(Icons.Default.Add, contentDescription = null) },
            text = { Text("Новая заметка") },
            onClick = { onAddNote() }
        )
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(notes, key = { it.id }) { note ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { },
                    elevation = 2.dp
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = note.text,
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 3,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
