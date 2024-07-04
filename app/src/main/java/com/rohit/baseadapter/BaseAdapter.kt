package com.rohit.baseadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BaseAdapter(var list :ArrayList<student>) :BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.base_item,parent,false)

        //student name
        var studentname = view.findViewById<TextView>(R.id.studentName)
        studentname.setText(list[position].name)

        //Roll number
        var rollnumber = view.findViewById<TextView>(R.id.studentRollNumber)
        rollnumber.setText(list[position].rollNumber.toString())

        //student subject
        var studentsubject = view.findViewById<TextView>(R.id.studentSubject)
        studentsubject.setText(list[position].subject)
        return view
    }


}