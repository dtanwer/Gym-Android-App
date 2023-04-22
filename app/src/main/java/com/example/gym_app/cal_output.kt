package com.example.gym_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class cal_output : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal_output)
        var m_w:TextView=findViewById(R.id.txt_m)
        var m_w_loss:TextView=findViewById(R.id.txt_w_loss)
        var m_mildw_l:TextView=findViewById(R.id.txt_mild_loss)
        var m_e_w:TextView=findViewById(R.id.txt_extre_m_loss)
        var mantain_cal=intent.getDoubleExtra("amr",0.0).toInt()
        var mild_w_loss=(mantain_cal*0.90).toInt()
        var w_loss=(mantain_cal*0.79).toInt()
        var extreme_w_loss=(mantain_cal*0.60).toInt()
        m_w.text=mantain_cal.toString()
        m_mildw_l.text=mild_w_loss.toString()
        m_w_loss.text=w_loss.toString()
        m_e_w.text=extreme_w_loss.toString()

    }
}