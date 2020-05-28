package com.example.testing.domain.repositories.models.realm

import com.example.testing.domain.repositories.models.rest.Question
import com.example.testing.domain.repositories.models.rest.User
import io.realm.RealmList
import io.realm.RealmObject

open class TestRealm : RealmObject() {
    var id: Int = 0
    var author: UserRealm? = null
    var description: String = ""
    var questions: RealmList<QuestionRealm>? = null
    var title: String = ""
}