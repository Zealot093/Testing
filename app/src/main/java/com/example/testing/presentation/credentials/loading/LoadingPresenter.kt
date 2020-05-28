package com.example.testing.presentation.credentials.loading

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.testing.domain.repositories.UserRepository
import com.example.testing.presentation.main.MainActivity
import javax.inject.Inject

@InjectViewState
class LoadingPresenter : MvpPresenter<ILoadingView> {

    private val userRepository: UserRepository

    @Inject
    constructor(userRepository: UserRepository) {
        this.userRepository = userRepository
    }

    fun loadStaticResources() {
        Handler().postDelayed({

            val user = userRepository.getUser()
            if (user != null) {
                MainActivity.show()
                return@postDelayed
            }

            viewState.showAuth()

        }, 500)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadStaticResources()
    }
}
