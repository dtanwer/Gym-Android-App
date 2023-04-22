package com.example.gym_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    //menu bar
    lateinit var drawerLayout: DrawerLayout
    lateinit var nav_view: NavigationView
    lateinit var toggle: ActionBarDrawerToggle//for humburgur icon

    lateinit var push:ImageView
    lateinit var pull1:ImageView
    lateinit var leg1:ImageView
    lateinit var pull2:ImageView
    lateinit var push2:ImageView
    lateinit var leg2:ImageView
    var user_id="null"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences: SharedPreferences =getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val save_id=sharedPreferences.getString("id",null)
        var islogin=sharedPreferences.getBoolean("islogin",false)
            if (islogin==true){
            val sharedPreferences: SharedPreferences =getSharedPreferences("login_pref", Context.MODE_PRIVATE)
            val save_id=sharedPreferences.getString("id",null)
            user_id=save_id.toString()
        }
        title=user_id



        drawerLayout=findViewById(R.id.drawer_layout)
        nav_view=findViewById(R.id.nav)
        toggle= ActionBarDrawerToggle(this@MainActivity,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                
                R.id.login->{
                    if(islogin==true){
                        Toast.makeText(this@MainActivity,"Already login",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        var intent=Intent(this@MainActivity,login::class.java)
                        startActivity(intent)
                    }
                }
                R.id.calculater->{
                    var intent=Intent(this@MainActivity,calculate::class.java)
                    startActivity(intent)
                }
                R.id.progress->{
                    var intent=Intent(this@MainActivity,Progress::class.java)
                    intent.putExtra("user_id",user_id)
                    startActivity(intent)
                }
                R.id.about->{
                    var intent=Intent(this@MainActivity,About::class.java)
                    startActivity(intent)
                }
            }

            true
        }


        push=findViewById(R.id.img_push)
        pull1=findViewById(R.id.img_pull1)
        leg1=findViewById(R.id.img_leg1)
        push2=findViewById(R.id.img_push2)
        pull2=findViewById(R.id.img_pull2)
        leg2=findViewById(R.id.img_leg2)

        push.setOnClickListener {
            var intent=Intent(this@MainActivity,Exercise::class.java)
            intent.putExtra("user_id",user_id)
            intent.putExtra("day",1)
            startActivity(intent)
        }
        pull1.setOnClickListener {
            var intent=Intent(this@MainActivity,Exercise::class.java)
            intent.putExtra("user_id",user_id)
            intent.putExtra("day",2)
            startActivity(intent)
        }
        leg1.setOnClickListener {
            var intent=Intent(this@MainActivity,Exercise::class.java)
            intent.putExtra("user_id",user_id)
            intent.putExtra("day",3)
            startActivity(intent)
        }
        push2.setOnClickListener {
            var intent=Intent(this@MainActivity,Exercise::class.java)
            intent.putExtra("user_id",user_id)
            intent.putExtra("day",4)
            startActivity(intent)
        }
        pull2.setOnClickListener {
            var intent=Intent(this@MainActivity,Exercise::class.java)
            intent.putExtra("user_id",user_id)
            intent.putExtra("day",5)
            startActivity(intent)
        }
        leg2.setOnClickListener {
            var intent=Intent(this@MainActivity,Exercise::class.java)
            intent.putExtra("user_id",user_id)
            intent.putExtra("day",6)
            startActivity(intent)
        }
    }
    

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return true
    }
}