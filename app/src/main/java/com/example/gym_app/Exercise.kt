package com.example.gym_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class Exercise : AppCompatActivity() {
    lateinit var ex1: ImageView
    lateinit var ex2: ImageView
    lateinit var ex3: ImageView
    lateinit var ex4: ImageView
    lateinit var ex5: ImageView
    lateinit var ex6: ImageView
    lateinit var ex7: ImageView
    lateinit var h_ex1:TextView
    lateinit var h_ex2:TextView
    lateinit var h_ex3:TextView
    lateinit var h_ex4:TextView
    lateinit var h_ex5:TextView
    lateinit var h_ex6:TextView
    lateinit var h_ex7:TextView

    var path_ex1=0
    var path_ex2=0
    var path_ex3=0
    var path_ex4=0
    var path_ex5=0
    var path_ex6=0
    var path_ex7=0
    var ex_icon1=0
    var ex_icon2=0
    var ex_icon3=0
    var ex_icon4=0
    var ex_icon5=0
    var ex_icon6=0
    var ex_icon7=0
    var name_ex1=""
    var name_ex2=""
    var name_ex3=""
    var name_ex4=""
    var name_ex5=""
    var name_ex6=""
    var name_ex7=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // geting user_id
        var user_id=intent.getStringExtra("user_id").toString()
        var day=intent.getIntExtra("day",0)
        title=user_id

        ex1=findViewById(R.id.ex1)
        ex2=findViewById(R.id.ex2)
        ex3=findViewById(R.id.ex3)
        ex4=findViewById(R.id.ex4)
        ex5=findViewById(R.id.ex5)
        ex6=findViewById(R.id.ex6)
        ex7=findViewById(R.id.ex7)
        h_ex1=findViewById(R.id.ex1_hading)
        h_ex2=findViewById(R.id.ex2_hading)
        h_ex3=findViewById(R.id.ex3_hading)
        h_ex4=findViewById(R.id.ex4_hading)
        h_ex5=findViewById(R.id.ex5_hading)
        h_ex6=findViewById(R.id.ex6_hading)
        h_ex7=findViewById(R.id.ex7_hading)
        when(day){
            1->{
                    ex1.setImageResource(R.drawable.push1_imgex1)
                    ex2.setImageResource(R.drawable.push1_imgex2)
                    ex3.setImageResource(R.drawable.push1_imgex3)
                    ex4.setImageResource(R.drawable.push1_imgex4)
                    ex5.setImageResource(R.drawable.push1_imgex5)
                    ex6.setImageResource(R.drawable.push1_imgex6)
                    ex7.setImageResource(R.drawable.push1_imgex7)
                    path_ex1=R.raw.push1_ex1
                    path_ex2=R.raw.push1_ex2
                    path_ex3=R.raw.push1_ex3
                    path_ex4=R.raw.push1_ex4
                    path_ex5=R.raw.push1_ex5
                    path_ex6=R.raw.push1_ex6
                    path_ex7=R.raw.push1_ex7
                ex_icon1=R.drawable.chest
                ex_icon2=R.drawable.fly
                ex_icon3=R.drawable.sholder_press
                ex_icon4=R.drawable.latralrase
                ex_icon5=R.drawable.latralrase
                ex_icon6=R.drawable.tricep
                ex_icon7 = R.drawable.tricep

                name_ex1="Doumble Bench Press"
                    name_ex2="Pack Deck Fly"
                    name_ex3="Doumble Sholder Press"
                    name_ex4="Lateral Raise"
                    name_ex5="One Arm Cable Rear Lateral Rase"
                    name_ex6="Skull Crusher"
                    name_ex7="Tricep Rope PushDown"




            }
            2->{
                ex1.setImageResource(R.drawable.pull1_imgex1)
                ex2.setImageResource(R.drawable.pull1_imgex2)
                ex3.setImageResource(R.drawable.pull1_imgex3)
                ex4.setImageResource(R.drawable.pull1_imgex4)
                ex5.setImageResource(R.drawable.pull1_imgex5)
                ex6.setImageResource(R.drawable.pull1_imgex6)
                ex7.setImageResource(R.drawable.pull1_imgex7)
                path_ex1=R.raw.pull1_ex1
                path_ex2=R.raw.pull1_ex2
                path_ex3=R.raw.pull1_ex3
                path_ex4=R.raw.pull1_ex4
                path_ex5=R.raw.pull1_ex5
                path_ex6=R.raw.pull1_ex6
                path_ex7=R.raw.pull1_ex7

                ex_icon1=R.drawable.lats_pull
                ex_icon2=R.drawable.lats_pull
                ex_icon3=R.drawable.lats
                ex_icon4=R.drawable.lats
                ex_icon5=R.drawable.latralrase
                ex_icon6=R.drawable.biceps
                ex_icon7 = R.drawable.biceps

                name_ex1="Chin Up"
                name_ex2="Lat Pulldown"
                name_ex3="Incline Dumbbell Rows"
                name_ex4="Standing Cable Lat Pushdown"
                name_ex5="Dumbbell Shrug"
                name_ex6="Barbell Curl"
                name_ex7="Hammer Curl"

                h_ex1.text=name_ex1
                h_ex2.text=name_ex2
                h_ex3.text=name_ex3
                h_ex4.text=name_ex4
                h_ex5.text=name_ex5
                h_ex6.text=name_ex6
                h_ex7.text=name_ex7
            }
            3->{
                ex1.setImageResource(R.drawable.leg1_imgex1)
                ex2.setImageResource(R.drawable.leg1_imgex2)
                ex3.setImageResource(R.drawable.leg1_imgex3)
                ex4.setImageResource(R.drawable.leg1_imgex4)
                ex5.setImageResource(R.drawable.leg1_imgex5)
                ex6.setImageResource(R.drawable.leg1_imgex6)
                ex7.setImageResource(R.drawable.leg1_imgex7)
                path_ex1=R.raw.leg1_ex1
                path_ex2=R.raw.leg1_ex2
                path_ex3=R.raw.leg1_ex3
                path_ex4=R.raw.leg1_ex4
                path_ex5=R.raw.leg1_ex5
                path_ex6=R.raw.leg1_ex6
                path_ex7=R.raw.leg1_ex7

                ex_icon1=R.drawable.quard
                ex_icon2=R.drawable.quard
                ex_icon3=R.drawable.quard
                ex_icon4=R.drawable.quard
                ex_icon5=R.drawable.gluts
                ex_icon6=R.drawable.calves
                ex_icon7 = R.drawable.calves

                name_ex1="Squat"
                name_ex2="Leg Press"
                name_ex3="Leg Curl"
                name_ex4="Leg Extension"
                name_ex5="Hip Thrust"
                name_ex6="Calves Raise"
                name_ex7="Calf Press Leg Press"

                h_ex1.text=name_ex1
                h_ex2.text=name_ex2
                h_ex3.text=name_ex3
                h_ex4.text=name_ex4
                h_ex5.text=name_ex5
                h_ex6.text=name_ex6
                h_ex7.text=name_ex7
            }
            4->{
                ex1.setImageResource(R.drawable.push2_imgex1)
                ex2.setImageResource(R.drawable.push2_imgex2)
                ex3.setImageResource(R.drawable.push2_imgex3)
                ex4.setImageResource(R.drawable.push2_imgex4)
                ex5.setImageResource(R.drawable.push2_imgex5)
                ex6.setImageResource(R.drawable.push2_imgex6)
                ex7.setImageResource(R.drawable.push2_imgex7)
                path_ex1=R.raw.push2_ex1
                path_ex2=R.raw.push2_ex2
                path_ex3=R.raw.push2_ex3
                path_ex4=R.raw.push2_ex4
                path_ex5=R.raw.push2_ex5
                path_ex6=R.raw.push2_ex6
                path_ex7=R.raw.push2_ex7

                ex_icon1=R.drawable.chest
                ex_icon2=R.drawable.fly
                ex_icon3=R.drawable.sholder_press
                ex_icon4=R.drawable.latralrase
                ex_icon5=R.drawable.latralrase
                ex_icon6=R.drawable.tricep
                ex_icon7 = R.drawable.tricep

                name_ex1="Incline Dumbbell Press"
                name_ex2="Cable Fly"
                name_ex3="Single Arm Shoulder Press"
                name_ex4=" Cable Lateral Raises"
                name_ex5=" Rear Delt Fly Machine"
                name_ex6="Overhead Cable Tricep Extension"
                name_ex7="Tricep PushDown"

                h_ex1.text=name_ex1
                h_ex2.text=name_ex2
                h_ex3.text=name_ex3
                h_ex4.text=name_ex4
                h_ex5.text=name_ex5
                h_ex6.text=name_ex6
                h_ex7.text=name_ex7
            }
            5->{
                ex1.setImageResource(R.drawable.pull1_imgex1)
                ex2.setImageResource(R.drawable.pull2_imgex2)
                ex3.setImageResource(R.drawable.pull2_imgex3)
                ex4.setImageResource(R.drawable.pull2_imgex4)
                ex5.setImageResource(R.drawable.pull2_imgex5)
                ex6.setImageResource(R.drawable.pull2_imgex6)
                ex7.setImageResource(R.drawable.pull2_imgex7)
                path_ex1=R.raw.pull2_ex1
                path_ex2=R.raw.pull2_ex2
                path_ex3=R.raw.pull2_ex3
                path_ex4=R.raw.pull2_ex4
                path_ex5=R.raw.pull2_ex5
                path_ex6=R.raw.pull2_ex6
                path_ex7=R.raw.pull2_ex7

                ex_icon1=R.drawable.lats_pull
                ex_icon2=R.drawable.lats_pull
                ex_icon3=R.drawable.lats
                ex_icon4=R.drawable.lats
                ex_icon5=R.drawable.latralrase
                ex_icon6=R.drawable.biceps
                ex_icon7 = R.drawable.biceps

                name_ex1="Close Grip Chin Ups"
                name_ex2="V grip lat pulldown"
                name_ex3="Doumble Sholder Press"
                name_ex4="Barbell Row"
                name_ex5="Deadlift"
                name_ex6="Preacher Curl Machine"
                name_ex7="Rope Hammer Curl"

                h_ex1.text=name_ex1
                h_ex2.text=name_ex2
                h_ex3.text=name_ex3
                h_ex4.text=name_ex4
                h_ex5.text=name_ex5
                h_ex6.text=name_ex6
                h_ex7.text=name_ex7
            }
            6->{
                ex1.setImageResource(R.drawable.leg1_imgex1)
                ex2.setImageResource(R.drawable.leg1_imgex2)
                ex3.setImageResource(R.drawable.leg2_imgex3)
                ex4.setImageResource(R.drawable.leg1_imgex4)
                ex5.setImageResource(R.drawable.leg1_imgex5)
                ex6.setImageResource(R.drawable.leg1_imgex6)
                ex7.setImageResource(R.drawable.leg1_imgex7)
                path_ex1=R.raw.leg1_ex1
                path_ex2=R.raw.leg1_ex2
                path_ex3=R.raw.leg2_ex3
                path_ex4=R.raw.leg1_ex4
                path_ex5=R.raw.leg1_ex5
                path_ex6=R.raw.leg1_ex6
                path_ex7=R.raw.leg1_ex7

                ex_icon1=R.drawable.quard
                ex_icon2=R.drawable.quard
                ex_icon3=R.drawable.quard
                ex_icon4=R.drawable.quard
                ex_icon5=R.drawable.gluts
                ex_icon6=R.drawable.calves
                ex_icon7 = R.drawable.calves


                name_ex1="Squat"
                name_ex2="Leg Press"
                name_ex3="Leg Curl"
                name_ex4="Leg Extension"
                name_ex5="Hip Thrust"
                name_ex6="Calves Raise"
                name_ex7="Calf Press Leg Press"

                h_ex1.text=name_ex1
                h_ex2.text=name_ex2
                h_ex3.text=name_ex3
                h_ex4.text=name_ex4
                h_ex5.text=name_ex5
                h_ex6.text=name_ex6
                h_ex7.text=name_ex7
            }
        }


        ex1.setOnClickListener {
            var intent=Intent(this@Exercise,Ex_video::class.java)
            intent.putExtra("exName",name_ex1)
            intent.putExtra("path",path_ex1)
            intent.putExtra("img_path",ex_icon1)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }
        ex2.setOnClickListener {
            var intent=Intent(this@Exercise,Ex_video::class.java)
            intent.putExtra("exName",name_ex2)
            intent.putExtra("path",path_ex2)
            intent.putExtra("img_path",ex_icon2)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }
        ex3.setOnClickListener {
            var intent=Intent(this@Exercise,Ex_video::class.java)
            intent.putExtra("exName",name_ex3)
            intent.putExtra("path",path_ex3)
            intent.putExtra("img_path",ex_icon3)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }
        ex4.setOnClickListener {
            var intent=Intent(this@Exercise,Ex_video::class.java)
            intent.putExtra("exName",name_ex4)
            intent.putExtra("img_path",ex_icon4)
            intent.putExtra("path",path_ex4)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }
        ex5.setOnClickListener {
            var intent=Intent(this@Exercise,Ex_video::class.java)
            intent.putExtra("exName",name_ex5)
            intent.putExtra("img_path",ex_icon5)
            intent.putExtra("path",path_ex5)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }
        ex6.setOnClickListener {
            var intent=Intent(this@Exercise,Ex_video::class.java)
            intent.putExtra("exName",name_ex6)
            intent.putExtra("img_path",ex_icon6)
            intent.putExtra("path",path_ex6)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }
        ex7.setOnClickListener {
            var intent=Intent(this@Exercise,Ex_video::class.java)
            intent.putExtra("exName",name_ex7)
            intent.putExtra("path",path_ex7)
            intent.putExtra("img_path",ex_icon7)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }
    }
}