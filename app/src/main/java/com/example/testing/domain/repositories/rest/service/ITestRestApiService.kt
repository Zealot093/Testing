package com.example.testing.domain.repositories.rest.service

import com.example.testing.domain.repositories.models.rest.Test
import io.reactivex.Observable
import retrofit2.http.*

interface ITestRestApiService {

    @POST("/testing/v1/test")
    fun createTest(@Body test: Test): Observable<Test>

    @GET("/testing/v1/tests")
    fun fetchTests(): Observable<MutableList<Test>>


}