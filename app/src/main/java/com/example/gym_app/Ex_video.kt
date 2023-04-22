package com.example.gym_app

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class Ex_video : AppCompatActivity() {
    lateinit var videoview:VideoView
    lateinit var ex_name:TextView
    lateinit var ex_img:ImageView
    var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_ex1_video)
        var user_id=intent.getStringExtra("user_id").toString()
        var exercise=intent.getStringExtra("exName").toString()
        var video_path=intent.getIntExtra("path",0)

        //firbase
        var redtodo: DatabaseReference =database.reference.child(user_id)

        videoview=findViewById(R.id.videoView)
        ex_name=findViewById(R.id.txtEx_name)
        ex_img=findViewById(R.id.img_ex)


        ex_name.text=exercise


        videoview.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+video_path))
       videoview.setOnPreparedListener {
           it.isLooping=true
       }
        videoview.requestFocus()
        videoview.start()
        ex_img.setImageResource(intent.getIntExtra("img_path",0))

        // getting current date
        var sdf=SimpleDateFormat("MMMM dd yyyy")
        var date=sdf.format(Date()).toString()
        // edt text
        var edtRep:EditText=findViewById(R.id.edt_reps)
        var edtweight:EditText=findViewById(R.id.edt_weight_)
        var btn_save:Button=findViewById(R.id.btn_save_data)
        btn_save.setOnClickListener {
            var reps=edtRep.text.toString()
            var weight=edtweight.text.toString()
            val pass_token:String=redtodo.push().key.toString()
            var data=Ex_data(pass_token,date,exercise,reps,weight)
            redtodo.child(pass_token).setValue(data).addOnCompleteListener {
                if(it.isSuccessful){
                    if(it.isSuccessful){
                        Toast.makeText(this@Ex_video,"Data Save",Toast.LENGTH_SHORT).show()
                        edtRep.setText("")
                        edtweight.setText("")
                    }
                    else {
                        Toast.makeText(this@Ex_video,"Failed",Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }
    }
    override fun onStart() {
        var user_id=intent.getStringExtra("user_id").toString()
        var redtodo: DatabaseReference =database.reference.child(user_id)
        super.onStart()
    }
}