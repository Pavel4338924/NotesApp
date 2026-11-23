package com.example.notesapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesapp.data.Note

@Composable
fun AddNoteScreen(
    viewModel: NotesViewModel = NotesViewModel(),
    onBack: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Новая заметка",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Заголовок") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Текст") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = false
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { onBack() }) {
                Text("Отмена")
            }

            Button(
                onClick = {
                    if (title.isNotBlank()) {
                        viewModel.addNote(title.trim(), text.trim())
                        onBack()
                    }
                },
                enabled = title.isNotBlank()
            ) {
                Text("Сохранить")
            }
        }
    }
}
