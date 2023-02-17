package com.example.quranicsurahas.models

data class ChapterInfo(
    val chapter_id: Int,
    val id: Int,
    val language_name: String,
    val short_text: String,
    val source: String,
    val text: String
)