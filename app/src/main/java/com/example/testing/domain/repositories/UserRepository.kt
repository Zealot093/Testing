package com.example.testing.domain.repositories

import android.os.SystemClock
import com.example.testing.base.SubRX
import com.example.testing.base.standardSubscribeIO
import com.example.testing.domain.repositories.IUserRepository
import com.example.testing.domain.repositories.local.UserStorage
import com.example.testing.domain.repositories.models.rest.Token
import com.example.testing.domain.repositories.models.rest.User
import com.example.testing.domain.repositories.rest.api.UserRestApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.net.HttpURLConnection
import javax.inject.Inject

class UserRepository {


    private val storage: UserStorage
    private val rest: UserRestApi

    @Inject
    constructor(storage: UserStorage, restApi: UserRestApi) {
        this.storage = storage
        this.rest = restApi
    }

    fun registration(observer: SubRX<User>, login: String, password: String) {
        rest.registration(login, password)
            .doOnNext { storage.save(it) }
            .standardSubscribeIO(observer)
    }

    fun login(observer: SubRX<User>, login: String, password: String) {
        rest.login(login, password)
            .doOnNext { storage.save(it) }
            .standardSubscribeIO(observer)
    }

    fun logout() {
        storage.dropCredentials()
    }

    fun getUser() = storage.getUser()


    fun refreshToken(token: Token, onRetry: (Int) -> Boolean = { it == HttpURLConnection.HTTP_UNAUTHORIZED }): Token? {

        val response = rest.refreshToken(token.refresh).execute()
        response.body()?.let {
            storage.save(it)
            return it
        }

        if (onRetry(response.code())) {
            SystemClock.sleep(500)
            return refreshToken(token)
        }

        return null
    }
}