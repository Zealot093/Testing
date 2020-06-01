package com.example.testing.domain.repositories.local

import com.example.testing.domain.repositories.models.rest.Test
import com.example.testing.domain.repositories.models.toRealm
import com.example.testing.domain.repositories.models.toRealmList
import io.realm.Realm
import javax.inject.Inject

class TestsStorage {

    @Inject
    constructor()

    fun saveTests(tests: MutableList<Test>) {
        Realm.getDefaultInstance().use {
            it.executeTransaction { realm ->
                tests.toRealmList()?.let { realm.copyToRealmOrUpdate(it) }
            }
        }
    }

    fun saveTest(test: Test) {
        Realm.getDefaultInstance().use {
            it.executeTransaction { realm ->
                test.toRealm()?.let { realm.insertOrUpdate(it) }
            }
        }
    }

}