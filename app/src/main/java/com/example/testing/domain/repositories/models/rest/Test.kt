package com.example.testing.domain.repositories.models.rest

import com.google.gson.annotations.SerializedName

data class Test(
    val id: Int,
    val author: User? = null,
    val desctiption: String,
    val questions: MutableList<Question>? = null,
    val title: String
)