package com.example.testing.presentation.main.createTest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testing.App
import com.example.testing.R
import com.example.testing.presentation.ABaseFragment
import kotlinx.android.synthetic.main.fragment_create_test.*
import javax.inject.Inject

class CreateTestFragment : ABaseFragment(), ICreateTestView {

    @Inject
    @InjectPresenter
    lateinit var presenter: CreateTestPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCreateTestList.layoutManager = LinearLayoutManager(activity)

        presenter.attachView()
    }

    override fun inject() {
        App.appComponent.inject(this)
    }

    override fun getViewId() = R.layout.fragment_create_test

    override fun showList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addQuest() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addAnswer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertQuest() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertAnswer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}