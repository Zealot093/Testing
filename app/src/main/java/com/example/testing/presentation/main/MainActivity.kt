package com.example.testing.presentation.main

import android.content.Intent
import android.os.Bundle
import com.example.testing.App
import com.example.testing.R
import com.example.testing.presentation.ABaseActivity
import com.example.testing.presentation.main.testsList.TestsListFragment

class MainActivity : ABaseActivity(), IMainRouter {

    companion object {
        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        showList()
    }

    override fun showList() {
        replace(TestsListFragment())
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTestDescription() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}