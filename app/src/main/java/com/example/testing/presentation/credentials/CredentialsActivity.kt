package com.example.testing.presentation.credentials

import android.content.Intent
import android.os.Bundle
import com.example.testing.App
import com.example.testing.R
import com.example.testing.domain.repositories.local.UserStorage
import com.example.testing.presentation.ABaseActivity
import com.example.testing.presentation.credentials.auth.AuthFragment
import com.example.testing.presentation.credentials.loading.LoadingFragment
import com.example.testing.presentation.credentials.registration.RegistrationFragment

class CredentialsActivity : ABaseActivity(), ICredentialsRouter {

    companion object {

        private const val ARG_DROP_CREDENTIALS = "ARG_DROP_CREDENTIALS"

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, CredentialsActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra(ARG_DROP_CREDENTIALS, true)
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credentials)

        if (savedInstanceState != null)
            return

//        if (intent.getBooleanExtra(ARG_DROP_CREDENTIALS, false)) {
            UserStorage().dropCredentials()
            showAuth()
//            return
//        }
//
//        showLoading()

    }

    override fun showLoading() {
        replace(LoadingFragment())
    }

    override fun showRegistration() {
        replace(RegistrationFragment(), "Registration")
    }

    override fun showAuth() {
        replace(AuthFragment())
    }


}