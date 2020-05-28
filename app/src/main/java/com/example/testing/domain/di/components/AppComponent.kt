package com.example.testing.domain.di.components

import com.example.testing.domain.di.modules.NetModule
import com.example.testing.domain.repositories.TestRepository
import com.example.testing.domain.repositories.UserRepository
import com.example.testing.presentation.credentials.auth.AuthFragment
import com.example.testing.presentation.credentials.loading.LoadingFragment
import com.example.testing.presentation.credentials.registration.RegistrationFragment
import com.example.testing.presentation.main.testsList.ITestsListView
import com.example.testing.presentation.main.testsList.TestsListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetModule::class
    ]
)
interface AppComponent {
    fun inject(target: AuthFragment)
    fun inject(target: RegistrationFragment)
    fun inject(target: LoadingFragment)
    fun inject(target:TestsListFragment)
    fun inject(target: UserRepository)
}