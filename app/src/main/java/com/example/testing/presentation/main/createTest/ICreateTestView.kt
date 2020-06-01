package com.example.testing.presentation.main.createTest

import com.example.testing.presentation.IBaseView

interface ICreateTestView : IBaseView {
    fun showList()
    fun addQuest()
    fun addAnswer()
    fun insertQuest()
    fun insertAnswer()
}