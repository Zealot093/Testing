package com.example.testing.domain.repositories.rest

interface IRestClient {

    fun <S> createService(serviceClass: Class<S>) : S
    fun cancelAllRequests()
}