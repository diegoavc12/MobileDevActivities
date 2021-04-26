package com.example.actitivity6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(var data:ArrayList<Array<String>>, var listener:View.OnClickListener):RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        var view:View=LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        view.setOnClickListener(listener)
        var fvh:FoodViewHolder= FoodViewHolder(view)
        return fvh
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.TVName).text= data[position][0]
        holder.view.findViewById<TextView>(R.id.TVPrice).text=data[position][1]
    }

    class FoodViewHolder(var view:View): RecyclerView.ViewHolder(view){

    }

}

