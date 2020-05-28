package com.example.testing.domain.repositories.models

import com.example.testing.domain.repositories.models.realm.*
import com.example.testing.domain.repositories.models.rest.*
import io.realm.RealmList

fun Token?.toRealm() : TokenRealm? {
    this ?: return null

    return  TokenRealm().let {
        it.access = access
        it.refresh = refresh
        it
    }
}

fun TokenRealm?.toBase(): Token? {
    this ?: return null
    return Token(access ?: "", refresh ?: "")
}

fun User?.toRealm(): UserRealm? {
    this ?: return null
    return UserRealm().let {
        it.id = id ?: 0
        it.login = login
        it.password = password
        it.avatarUrl = avatarUrl
        it.token = token.toRealm()
        it
    }
}

fun UserRealm?.toBase(): User? {
    this ?: return null
    return User(id, login ?: "", password ?: "", avatarUrl, token.toBase())
}

