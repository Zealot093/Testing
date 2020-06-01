package com.example.testing.domain.repositories.models.rest

import com.google.gson.annotations.SerializedName

data class Question(
    val id: Int? = null,
    val answers: MutableList<Answer>,
    @SerializedName("order_by")
    val orderBy: Int? = null,
    val text: String
)