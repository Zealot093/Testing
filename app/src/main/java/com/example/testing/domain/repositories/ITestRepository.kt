package com.example.testing.domain.repositories

import com.example.testing.domain.repositories.models.rest.Test

interface ITestRepository {
    fun getTests(): MutableList<Test>
    fun getTestById(id: Number): Test?
    fun createTest(test: Test)
}