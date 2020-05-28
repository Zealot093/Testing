package com.example.testing.domain.repositories.models

import com.example.testing.domain.repositories.models.realm.TestRealm
import com.example.testing.domain.repositories.models.rest.Test
import io.realm.RealmList

fun Test?.toRealm(): TestRealm? {
    this ?: return null
    return TestRealm().let {
        it.id = id
        it.author = author.toRealm()
        it.description = desctiption
        it.questions = questions.toRealmList()
        it.title = title
        it
    }
}

fun TestRealm?.toBase(): Test? {
    this ?: return null
    return  Test(
        id,
        author.toBase(),
        description,
        questions.toBaseList(),
        title
    )
}

fun MutableList<Test>?.toRealmList(): RealmList<TestRealm>? {
    this ?: return null
    val list = RealmList<TestRealm>()
    this.forEach { list.add(it.toRealm()) }
    return list
}

fun RealmList<TestRealm>?.toBaseList(): MutableList<Test>? {
    this ?: return null
    val list = ArrayList<Test>()
    this.forEach { list.add(it.toBase()!!) }
    return list
}