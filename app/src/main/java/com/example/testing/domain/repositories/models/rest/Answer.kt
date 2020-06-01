package com.example.testing.domain.repositories.models.rest

import com.google.gson.annotations.SerializedName

data class Answer(
    val id: Int? = null,
    val is_right: Boolean,
    @SerializedName("order_by")
    val orderBy: Int,
    val right: Boolean,
    val text: String
)