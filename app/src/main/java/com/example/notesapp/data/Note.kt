package com.example.notesapp.data

data class Note(
    val id: String = java.util.UUID.randomUUID().toString(),
    var title: String = "",
    var text: String = ""
)
