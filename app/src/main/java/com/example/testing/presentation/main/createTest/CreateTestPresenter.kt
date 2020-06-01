package com.example.testing.presentation.main.createTest

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.testing.domain.repositories.TestRepository
import com.example.testing.domain.repositories.models.rest.Test
import javax.inject.Inject

@InjectViewState
class CreateTestPresenter : MvpPresenter<ICreateTestView> {

    @Inject
    lateinit var testRepository: TestRepository
    var currentTest: Test = Test(null, null, "", null, "")

    @Inject
    constructor()

    fun attachView() {

    }
}