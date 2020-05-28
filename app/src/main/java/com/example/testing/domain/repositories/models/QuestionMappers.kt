package com.example.testing.domain.repositories.models

import com.example.testing.domain.repositories.models.realm.QuestionRealm
import com.example.testing.domain.repositories.models.rest.Question
import io.realm.RealmList

fun Question?.toRealm(): QuestionRealm? {
    this ?: return null
    return QuestionRealm().let {
        it.id = id ?: 0
        it.answers = answers.toRealmList()
        it.orderBy = orderBy
        it.text = text
        it
    }
}

fun QuestionRealm?.toBase(): Question? {
    this ?: return null
    return Question(id, answers.toBaseList()!!, orderBy, text ?: "")
}

fun MutableList<Question>?.toRealmList(): RealmList<QuestionRealm>? {
    this ?: return null
    val list = RealmList<QuestionRealm>()
    this.forEach { list.add(it.toRealm()) }
    return list
}

fun RealmList<QuestionRealm>?.toBaseList(): MutableList<Question>? {
    this ?: return null
    val list = ArrayList<Question>()
    this.forEach { list.add(it.toBase()!!) }
    return list
}
