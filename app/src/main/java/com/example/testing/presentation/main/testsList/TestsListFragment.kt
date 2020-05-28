package com.example.testing.presentation.main.testsList

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testing.App
import com.example.testing.R
import com.example.testing.domain.repositories.models.rest.Test
import com.example.testing.presentation.ABaseFragment
import kotlinx.android.synthetic.main.fragment_tests_list.*
import javax.inject.Inject

class TestsListFragment : ABaseFragment(), ITestsListView {

    @Inject
    @InjectPresenter
    lateinit var presenter: TestsListPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
        App.appComponent.inject(this)
    }

    override fun getViewId() = R.layout.fragment_tests_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTestsList.layoutManager = LinearLayoutManager(activity)
        Log.d("onViewCreated", "ddddd")

        presenter.attachView()
    }

    override fun showList(list: MutableList<Test>) {

        toast("sss")
        rvTestsList.adapter = TestsListAdapter(list, { test: Test -> onTestClick(test) })
    }

    fun onTestClick(test: Test) {
        Toast.makeText(activity, "Clicked ${test.title}", Toast.LENGTH_LONG).show()
    }
}