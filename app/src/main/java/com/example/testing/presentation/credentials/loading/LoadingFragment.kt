package com.example.testing.presentation.credentials.loading

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testing.App
import com.example.testing.R
import com.example.testing.presentation.ABaseFragment
import com.example.testing.presentation.credentials.ICredentialsRouter
import javax.inject.Inject

class LoadingFragment : ABaseFragment(), ILoadingView {

    @Inject
    @InjectPresenter
    lateinit var presenter: LoadingPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
        App.appComponent.inject(this)
    }

    override fun getViewId() = R.layout.fragment_loading

    override fun showAuth() {
        activity?.let {
            if (it is ICredentialsRouter)
                it.showAuth()
        }
    }
}