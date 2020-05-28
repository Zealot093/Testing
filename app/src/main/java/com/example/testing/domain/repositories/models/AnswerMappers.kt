package com.example.testing.domain.repositories.models

import com.example.testing.domain.repositories.models.realm.AnswerRealm
import com.example.testing.domain.repositories.models.rest.Answer
import io.realm.RealmList


fun Answer?.toRealm(): AnswerRealm? {
    this ?: return null
    return AnswerRealm().let {
        it.id = id
        it.is_right = is_right
        it.orderBy = orderBy
        it.right = right
        it.text = text
        it
    }
}

fun AnswerRealm?.toBase(): Answer? {
    this ?: return null
    return  Answer(
        id,
        is_right,
        orderBy,
        right,
        text
    )
}


fun MutableList<Answer>?.toRealmList(): RealmList<AnswerRealm>? {
    this ?: return null
    val list = RealmList<AnswerRealm>()
    this.forEach { list.add(it.toRealm()) }
    return list
}

fun RealmList<AnswerRealm>?.toBaseList(): MutableList<Answer>? {
    this ?: return null
    val list = ArrayList<Answer>()
    this.forEach { list.add(it.toBase()!!) }
    return list
}