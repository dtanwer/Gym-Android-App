package com.example.gym_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast

class About : AppCompatActivity() {
    lateinit var radio_group:RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        Toast.makeText(this,"on create",Toast.LENGTH_SHORT).show()
    }

}