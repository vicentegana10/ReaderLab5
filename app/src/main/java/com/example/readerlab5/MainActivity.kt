package com.example.readerlab5


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {


    val item5List = mutableListOf<Item5>()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val file = applicationContext.assets.open("products.txt")
        val br = file.bufferedReader()
        val text:List<String> = br.readLines()
        for (line in text){
            var lines = line.split(",")

            item5List.add(Item5(lines[0],lines[1],lines[2]))
        }

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerViewAdapter(item5List as ArrayList<Item5>)
        recyclerView.adapter = adapter



    }
}


data class Item5(val nombre: String ,val precio:String,var urlName : String)
