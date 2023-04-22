package com.example.gym_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class calculate : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var nav_view: NavigationView
    lateinit var toggle: ActionBarDrawerToggle//for humburgur icon


    lateinit var edt_weight: EditText
    lateinit var edt_hight_ft: EditText
    lateinit var edt_hight_inch: EditText
    lateinit var edt_age: EditText
    var count=0
    var male = false
    var BMR = 0.0
    var AMR = 0.0
    var level = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        var btn_cal: Button = findViewById(R.id.btn_calculate)
        var btn_clear:Button=findViewById(R.id.btn_clear)
        var radio_gender: RadioGroup = findViewById(R.id.radio_gender)
        var radio_level: RadioGroup = findViewById(R.id.radiolevel)
        edt_weight = findViewById(R.id.edt_weight_input)
        edt_age = findViewById(R.id.edt_age)
        edt_hight_inch = findViewById(R.id.edt_hight_inch)
        edt_hight_ft = findViewById(R.id.edt_hight_ft)
        btn_cal.isEnabled=false
        btn_clear.isEnabled=false

        val sharedPreferences: SharedPreferences =getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val save_id=sharedPreferences.getString("id",null)
        val islogin=sharedPreferences.getBoolean("islogin",false)
        var user_id=save_id.toString()

        drawerLayout=findViewById(R.id.drawer_layout)
        nav_view=findViewById(R.id.nav)
        toggle= ActionBarDrawerToggle(this@calculate,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.work_out->{
                    var intent=Intent(this@calculate,MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.login->{
                    if(islogin==true){
                        Toast.makeText(this@calculate,"Already login",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        var intent=Intent(this@calculate,login::class.java)
                        startActivity(intent)
                    }
                }
                R.id.progress->{
                    var intent=Intent(this@calculate,Progress::class.java)
                    intent.putExtra("user_id",user_id)
                    startActivity(intent)
                }
                R.id.about->{
                    var intent=Intent(this@calculate,About::class.java)
                    startActivity(intent)
                }
            }

            true
        }

        radio_gender.setOnCheckedChangeListener { group, checkedId ->
            var radio: RadioButton = findViewById(checkedId)
            if (radio.text == "Male") {
                male = true
            } else {
                male = false
            }
        }
        radio_level.setOnCheckedChangeListener { group, checkedId ->
            var radio: RadioButton = findViewById(checkedId)
            if (radio.text == "No Exercise") {
                level=1
            } else if (radio.text == "Lightly Active") {
                level=2
            } else if (radio.text == "Moderately Active") {
                level=3
            } else if (radio.text == "Active") {
                level=4
            } else {
               level=5
            }
            btn_cal.isEnabled=true
            btn_clear.isEnabled=true

        }
        btn_cal.setOnClickListener {
            var kg = edt_weight.text.toString().toInt()
            var age_input = edt_age.text.toString().toInt()
            var h_ft = edt_hight_ft.text.toString().toInt()
            var h_inch = edt_hight_inch.text.toString().toInt()
            var hight_cm=h_ft*30.48+h_inch*2.54
            if (male == true) {
                BMR = 66.47 + (13.75 * kg) + (5.003 * hight_cm) - (6.755 * age_input)
            } else {
                BMR = 655.1 + (9.563 * kg) + (1.850 * hight_cm) - (4.676 * age_input)
            }
            when(level){
                1->{
                    AMR = BMR * 1.2
                }
                2->{
                    AMR = BMR * 1.375
                }
                3->{
                    AMR = BMR * 1.55
                }
                4->{
                    AMR = BMR * 1.725
                }
                5->{
                    AMR = BMR * 1.9
                }
            }

            var intent=Intent(this,cal_output::class.java)
            intent.putExtra("amr",AMR)
            edt_weight.setText("")
            edt_age.setText("")
            edt_hight_ft.setText("")
            edt_hight_inch.setText("")
            btn_cal.isEnabled=false
            btn_clear.isEnabled=false
            startActivity(intent)
        }
        btn_clear.setOnClickListener {
            edt_weight.setText("")
            edt_age.setText("")
            edt_hight_ft.setText("")
            edt_hight_inch.setText("")
            btn_cal.isEnabled=false
            btn_clear.isEnabled=false
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_manu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return true
    }
}