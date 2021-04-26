package com.example.actitivity6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity(var data:ArrayList<Array<String>>?=ArrayList<Array<String>>()): AppCompatActivity(), View.OnClickListener {
    init{
        data= ArrayList<Array<String>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var jsonFood:String= "[\n" +
                "{'name':'burger', 'price':15, 'description':'a juicy burger!'},\n" +
                "{'name':'hotdog', 'price':20, 'description':'an ok hot dog'},\n" +
                "{'name':'tacos', 'price':12, 'description':'some pretty good tacos'},\n" +
                "{'name':'torta', 'price':22, 'description':'nice torta'},\n" +
                "{'name':'carne asada', 'price':50, 'description':'a great carne asada'}\n" +
                "]"
        var foodItems:JSONArray=JSONArray(jsonFood)
        for(i in 0 until foodItems.length()){
            var item:JSONObject=foodItems.getJSONObject(i)
            var itemArray: Array<String> =arrayOf(item.getString("name"),item.getString("price"),item.getString("description"))
            data!!.add(itemArray)

        }
        var adapter:FoodAdapter= FoodAdapter(data!!,this)
        var llm:LinearLayoutManager= LinearLayoutManager(this)
        llm.orientation=LinearLayoutManager.VERTICAL
        var recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager=llm
        recyclerView!!.adapter=adapter

    }

    override fun onClick(v: View?) {
        var recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        var pos:Int=recyclerView.getChildLayoutPosition(v!!)
        Toast.makeText(this,data!![pos][2], Toast.LENGTH_SHORT).show()


    }
}