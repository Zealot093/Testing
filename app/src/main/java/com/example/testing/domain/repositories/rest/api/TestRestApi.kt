package com.example.testing.domain.repositories.rest.api

import com.example.testing.domain.di.modules.NetModule
import com.example.testing.domain.repositories.rest.IRestClient
import com.example.testing.domain.repositories.rest.service.ITestRestApiService
import javax.inject.Inject
import javax.inject.Named

class TestRestApi : ABaseRestApi<ITestRestApiService> {

    @Inject
    constructor(client: IRestClient) : super(client)

    fun fetchTests(limit: Int, page: Int)
        = service.fetchTests(limit, page)
}