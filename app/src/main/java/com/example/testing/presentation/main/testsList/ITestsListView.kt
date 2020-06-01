package com.example.testing.presentation.main.testsList

import com.example.testing.domain.repositories.models.rest.Test
import com.example.testing.presentation.IBaseView

interface ITestsListView : IBaseView {
    fun showList(list: MutableList<Test>)
    fun insertItem()
}