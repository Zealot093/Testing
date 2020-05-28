package com.example.testing.presentation.credentials.auth

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.testing.base.SubRX
import com.example.testing.domain.repositories.IUserRepository
import com.example.testing.domain.repositories.UserRepository
import com.example.testing.presentation.credentials.auth.IAuthView
import com.example.testing.presentation.main.MainActivity
import javax.inject.Inject

@InjectViewState
class AuthPresenter : MvpPresenter<IAuthView> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor(userRepository: UserRepository) {
        this.userRepository = userRepository
    }

    fun auth(login: String, password: String) {
        //userRepository.getUser()
        userRepository.login(SubRX { _, e ->
            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }
            MainActivity.show()
        }, login, password)
    }
}