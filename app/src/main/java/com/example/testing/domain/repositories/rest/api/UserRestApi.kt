package com.example.testing.domain.repositories.rest.api

import com.example.testing.domain.di.modules.NetModule
import com.example.testing.domain.repositories.models.rest.User
import com.example.testing.domain.repositories.rest.IRestClient
import com.example.testing.domain.repositories.rest.service.IUserRestApiService
import javax.inject.Inject
import javax.inject.Named

class UserRestApi : ABaseRestApi<IUserRestApiService> {

    @Inject
    constructor(@Named(NetModule.NAME_AUTH_REST_CLIENT) client: IRestClient) : super(client)

    fun registration(login: String, password: String)
            = service.registration(
        User(
            login = login,
            password = password
        )
    )

    fun login(login: String, password: String)
            = service.login(
        User(
            login = login,
            password = password
        )
    )

    fun refreshToken(token: String)
            = service.refreshToken(token)

}