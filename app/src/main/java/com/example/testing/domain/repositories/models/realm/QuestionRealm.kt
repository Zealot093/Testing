package com.example.testing.domain.repositories.models.realm

import com.example.testing.domain.repositories.models.rest.Answer
import io.realm.RealmList
import io.realm.RealmObject

open class QuestionRealm : RealmObject() {
    var id: Int = 0
    var answers: RealmList<AnswerRealm>? = null
    var orderBy: Int? = null
    var text: String? = null
}