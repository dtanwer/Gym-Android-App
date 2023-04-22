package com.example.gym_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Adpt(var ctx: Context, var file:Int, var details:ArrayList<Ex_data>):
    ArrayAdapter<Ex_data>(ctx,file,details){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        var view: View
        view=layoutInflater.inflate(file,null)
        var date: TextView =view.findViewById(R.id.txt_date)
        var ex: TextView =view.findViewById((R.id.txt_exname))
        var reps: TextView =view.findViewById((R.id.txt_reps))
        var w: TextView =view.findViewById((R.id.txt_w))
        date.text=details[position].Date
        ex.text=details[position].Exercise
        reps.text=details[position].Rep
        w.text=details[position].weight
        return view
    }
}