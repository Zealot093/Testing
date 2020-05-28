package com.example.testing.presentation.main.testsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.R
import com.example.testing.domain.repositories.models.rest.Test
import kotlinx.android.synthetic.main.test_item.view.*
import javax.inject.Inject

class TestsListAdapter(var tests: MutableList<Test>, val clickListener: (Test) -> Unit) : RecyclerView.Adapter<TestsListAdapter.TestsListViewHolder>() {

    @Inject
    lateinit var presenter: TestsListPresenter

    class TestsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        var title: TextView = itemView.findViewById(R.id.tvTitle)
//        var author: TextView = itemView.findViewById(R.id.tvAuthor)
//        var questQuant: TextView = itemView.findViewById(R.id.tvQuestQuant)

        fun bind(test: Test, clickListener: (Test) -> Unit) {
            itemView.tvAuthor.text = test.author!!.login
            itemView.tvTitle.text = test.title
            itemView.tvQuestQuant.text = "10"
            itemView.setOnClickListener { clickListener(test) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestsListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.test_item, parent, false)
        return TestsListViewHolder(view)
    }

    override fun getItemCount(): Int = tests.size

    override fun onBindViewHolder(holder: TestsListViewHolder, position: Int) {
//        holder.author.text = tests[position].author.login
//        holder.title.text = tests[position].title
//        holder.questQuant.text = "10"
        holder.bind(tests[position], clickListener)
    }
}