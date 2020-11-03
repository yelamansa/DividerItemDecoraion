package kz.y.drawing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myAdapter = MyAdapter()
        val list = listOf(
                MyDataClass(1, "1", "a"),
                MyDataClass(2, "2", "b"),
                MyDataClass(3, "3", "c"),
                MyDataClass(4, "4", "d"),
                MyDataClass(5, "5", "e")
        )
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
            addItemDecoration(MyItemDecoration(this@MainActivity))
        }
        myAdapter.submitList(list)

        findViewById<Button>(R.id.button).setOnClickListener {
            val lista = listOf(
                    MyDataClass(1, "1", "a"),
                    MyDataClass(2, "2", "bc"),
                    MyDataClass(3, "3", "c"),
                    MyDataClass(4, "4", "d"),
                    MyDataClass(5, "5", "ed")
            )
            myAdapter.submitList(lista)

        }
    }
}