package altongmon.kotlin.todolist.viewmodel

import altongmon.kotlin.todolist.R
import altongmon.kotlin.todolist.TodoActivity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainModel(private var activity : AppCompatActivity, private var context: Context) : ViewModel {


    override fun onCreate() {

    }

    fun clickEvent(view : View) {

        when(view.id) {

            R.id.addNewTodoFab -> {
                activity.startActivity(Intent(context, TodoActivity::class.java))
                activity.finish()
            }

        }

    }

}