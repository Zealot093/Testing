package com.example.testing.domain.repositories

import android.util.Log
import com.example.testing.base.SubRX
import com.example.testing.base.standardSubscribeIO
import com.example.testing.domain.repositories.local.TestsStorage
import com.example.testing.domain.repositories.models.rest.Test
import com.example.testing.domain.repositories.models.rest.User
import com.example.testing.domain.repositories.rest.api.TestRestApi
import javax.inject.Inject

class TestRepository {

    var testsMock: MutableList<Test> = mutableListOf<Test>(
        Test(1, User(1,"login", "password"), "description", null, "title"),
        Test(1, User(1,"login", "password"), "description1", null, "title1"),
        Test(1, User(1,"login", "password"), "description2", null, "title2"),
        Test(1, User(1,"login", "password"), "description3", null, "title3")
    )

    private val storage: TestsStorage
    private val rest: TestRestApi

    @Inject
    constructor(storage: TestsStorage, restApi: TestRestApi) {
        this.storage = storage
        this.rest = restApi
    }

//    fun getTests(): MutableList<Test> {
//        return testsMock
//    }

    fun getTests(observer: SubRX<MutableList<Test>>, limit: Int, page: Int) {
        rest.fetchTests(limit, page)
            .doOnNext { storage.saveTests(it) }
            .standardSubscribeIO(observer)
    }

    fun getTestById(id: Number): Test? {
        val test = testsMock.find {
            test -> test.id == id
        }
        return  test
    }

    fun createTest(test: Test) {
        testsMock.add(test)
    }
}