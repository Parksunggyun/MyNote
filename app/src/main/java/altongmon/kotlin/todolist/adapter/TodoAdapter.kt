package altongmon.kotlin.todolist.adapter

import altongmon.kotlin.todolist.databinding.ItemTodolistBinding
import altongmon.kotlin.todolist.dto.Todo
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*

class TodoAdapter(private var todos: Vector<Todo>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTodolistBinding.inflate(LayoutInflater.from(context),parent, false)
        return ItemHoder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ItemHoder
        val binding = itemHolder.binding
        val pos = (todos.size - 1) - position
        binding.todoTitleTv.text = todos[pos].title
        val time = "작성일 " + todos[pos].writeTime
        binding.noteDateTv.text = time

    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class ItemHoder : RecyclerView.ViewHolder {
        var binding: ItemTodolistBinding

        constructor(binding: ItemTodolistBinding) : super(binding.root) {
            this.binding = binding
        }
    }

}