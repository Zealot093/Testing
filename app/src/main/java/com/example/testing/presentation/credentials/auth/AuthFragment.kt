package com.example.testing.presentation.credentials.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testing.App
import com.example.testing.R
import com.example.testing.presentation.ABaseFragment
import com.example.testing.presentation.credentials.ICredentialsRouter
import com.example.testing.presentation.main.MainActivity
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

class AuthFragment : ABaseFragment(), IAuthView {

    @Inject
    @InjectPresenter
    lateinit var presenter: AuthPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
        App.appComponent.inject(this)
    }

    override fun getViewId() = R.layout.fragment_auth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAuth.setOnClickListener {
            val login = "${etLogin.text}"
            val password = "${etPassword.text}"

            if (login.isEmpty() && password.isEmpty()) {
                toast("Введите пароль")
                return@setOnClickListener
            }
            presenter.auth(login, password)
        }

        btnRegistration.setOnClickListener {
            activity?.let {
                if (it is ICredentialsRouter)
                    it.showRegistration()
            }
        }
    }

    override fun lock() {
        toast("lock")
    }

    override fun unlock() {
        toast("unlcock")
    }

    override fun onSuccess() {
        toast("SUCCESS")
    }
}