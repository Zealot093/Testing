package com.example.testing

import android.app.Application
import android.content.Context
import com.example.testing.domain.di.components.AppComponent
import com.example.testing.domain.di.components.DaggerAppComponent
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {
    companion object {
        lateinit var appContext: Context
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appContext = applicationContext

        initRealm()
    }

    private fun initRealm() {
        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder()
            .build()
        )
    }
}