package com.portfolio.sofieandroid.presentation.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.portfolio.sofieandroid.R
import com.portfolio.sofieandroid.data.model.Data
import com.portfolio.sofieandroid.data.model.Tarefas
import kotlinx.android.synthetic.main.list_item_tarefas.view.*

class ListTarefasAdapter(
        val listTarefas: Tarefas
) : RecyclerView.Adapter<ListTarefasAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_tarefas, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int = listTarefas.tarefas?.count()!!

    override fun onBindViewHolder(viewHolder: ListViewHolder, position: Int) {
        viewHolder.bindView(listTarefas.tarefas?.get(position))
    }


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.txt_title_tarefa
        private val email = itemView.txt_email_tarefa

        fun bindView(tarefa: Data?) {
            if (tarefa != null) {
                title.text = tarefa.title
            }
            if (tarefa != null) {
                email.text = tarefa.email
            }
        }
    }
}