package altongmon.kotlin.todolist

import altongmon.kotlin.todolist.adapter.TodoAdapter
import altongmon.kotlin.todolist.databinding.ActivityMainBinding
import altongmon.kotlin.todolist.dto.Todo
import altongmon.kotlin.todolist.sqlite.TodoOpenHelper
import altongmon.kotlin.todolist.viewmodel.MainModel
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var todies : Vector<Todo>
    private lateinit var adapter : TodoAdapter



    companion object {
        private const val MAIN = R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, MAIN)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        todies = Vector()
        val openHelper = TodoOpenHelper(this)
        val db = openHelper.writableDatabase
        val cursor = db.rawQuery("select * from todolist", null)

        val count = cursor.count
        if (count >= 1) {
            while (cursor.moveToNext()) {
                val title = cursor.getString(0)
                val time = cursor.getString(2)
                todies.add(Todo(title, time))
            }
        } else {
            todies.add(Todo("등록된 메모가 없습니다.", ""))
        }

        cursor.close()
        adapter = TodoAdapter(todies, this)
        binding.recyclerView.adapter = adapter

        binding.mainModel = MainModel(this, this)
        binding.executePendingBindings()
    }
}
