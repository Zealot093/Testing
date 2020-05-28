package com.example.testing.domain.repositories

import com.example.testing.domain.repositories.models.rest.User

interface IUserRepository {
    fun getUser() : User
}