package com.example.testing.domain.repositories.models.realm

import io.realm.RealmObject

open class AnswerRealm : RealmObject() {
    var id: Int = 0
    var is_right: Boolean = false
    var orderBy: Int = 0
    var right: Boolean = false
    var text: String = ""
}