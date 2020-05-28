package com.example.testing.presentation.main.testsList

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testing.base.SubRX
import com.example.testing.domain.repositories.TestRepository
import javax.inject.Inject

@InjectViewState
class TestsListPresenter : MvpPresenter<ITestsListView> {

    @Inject
    lateinit var testRepository: TestRepository

    @Inject
    constructor()


    fun attachView() {
        Log.d("dsdsdsds", "222")
        val tests = testRepository.getTests(SubRX { result, e ->
            if (e != null) e.printStackTrace()
            viewState.showList(result!!)
            return@SubRX
        }, 10, 1)
    }


}