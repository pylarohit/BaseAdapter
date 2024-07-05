package com.rohit.baseadapter

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rohit.baseadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding : ActivityMainBinding? =null
    var student_list = arrayListOf<student>()
    var baseAdapter = BaseAdapter(student_list)
    lateinit var Studentdatabase: studentDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        Studentdatabase = studentDatabase.getInstance(this)
        student_list.add(student("Rohit","Java", 36.toString()))
        student_list.add(student("Vinay","Sql", 48.toString()))
        student_list.add(student("Pranay","Dsa", 12.toString()))
        student_list.add(student("Venkat","kotlin", 13.toString()))
        binding?.fab?.setOnClickListener {
            Studentdatabase.studentInterferce().Insertstudent(student(name  ="Test",subject ="Testing"))
        }

        binding?.fab?.setOnClickListener{
            Dialog(this).apply {
                setContentView(R.layout.custom_dialog)
                window?.setLayout(900, 700)
                window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT )
                val name = findViewById<EditText>(R.id.student_name)
                val subject = findViewById<EditText>(R.id.student_Subject)
                val rollnumber = findViewById<EditText>(R.id.student_rollNumber)
                val button = findViewById<Button>(R.id.submit_button)

                button?.setOnClickListener {
                    if (name.text.trim().isNullOrEmpty()){
                        name.error = "enter name"
                    }
                    else if (subject.text.trim().isNullOrEmpty()) {
                        subject.error = "enter subject name"
                    }
                    else if (rollnumber.text.trim().isNullOrEmpty()){
                         rollnumber.error = "enter rollNumber"
                    }
                    else
                    {
                        val name_1 = name.text.toString()
                        val subject_1 = subject.text.toString()
                        val rollnumber_1 = rollnumber.text.toString()
                        Toast.makeText(this@MainActivity,"Button Clicked", Toast.LENGTH_SHORT).show()
                        student_list.add(student(name_1, subject_1,rollnumber_1))
                        baseAdapter.notifyDataSetChanged()
                        dismiss()

                    }
                }
            }.show()
        }
        binding?.listView?.adapter = baseAdapter
        // listview update
        binding?.listView?.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Update Clicked", Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(this@MainActivity).apply {
                setTitle("Click To Update Data")
                setPositiveButton("Update"){dialog,which ->
                    addNewData(data = position)
                }
            }.show()

        }
        binding?.listView?.setOnItemLongClickListener { parent, view, position, id ->
            AlertDialog.Builder(this@MainActivity).apply {
                setTitle("Click To Delete Data")
                setNegativeButton("Delete"){dialog,which ->
                    student_list.removeAt(position)
                    baseAdapter.notifyDataSetChanged()
                }
            }.show()
            return@setOnItemLongClickListener true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun addNewData(data : Int) {
        Dialog(this).apply {
            setContentView(R.layout.custom_dialog)
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

            val button = findViewById<Button>(R.id.submit_button)
            val name = findViewById<EditText>(R.id.student_name)
            val rollNumber = findViewById<EditText>(R.id.student_rollNumber)
            val Subject = findViewById<EditText>(R.id.student_Subject)
            name.setText(student_list[data].name)
            Subject.setText(student_list[data].subject)
            rollNumber.setText(student_list[data].rollNumber.toString())

            button?.setOnClickListener {
                if (name.text.trim().isNullOrEmpty()){
                    name.error = "enter name"
                }
                else if (rollNumber.text.trim().isNullOrEmpty()){
                    rollNumber.error = "enter rollNumber"
                }
                else if (Subject.text.trim().isNullOrEmpty()){
                    Subject.error = "enter subject name"
                }else
                {
                    val name_data = name.text.toString()
                    val subject_data = Subject.text.toString()
                    val roll_number = rollNumber.text.toString()

                    Toast.makeText(this@MainActivity,"button is preesed", Toast.LENGTH_SHORT).show()
                    dismiss()
                    student_list.set(data , student(name_data, subject_data, roll_number))
                    baseAdapter.notifyDataSetChanged()
                }
            }
        }.show()
    }

}
