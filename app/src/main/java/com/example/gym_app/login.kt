package com.example.gym_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.database.*

class login : AppCompatActivity() {
    var islogin=false
    var user_id_login=""
  lateinit var edt_id: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        var txt_skip:TextView=findViewById(R.id.txt_skip)
        var btn_login: Button =findViewById(R.id.btn_login)
        var edt_pass: EditText =findViewById(R.id.password)
        var txtRegister:TextView =findViewById(R.id.txt_reg)
        edt_id=findViewById(R.id.edt_id)
        var txtlogin_fail: TextView =findViewById(R.id.txt_login_fail)
        btn_login.isEnabled=false
        loadData()
        //Skip textView
        txt_skip.setOnClickListener {
            var intent= Intent(this@login,MainActivity::class.java)
            startActivity(intent)
        }
        //register textView
        txtRegister.setOnClickListener {
            var intent= Intent(this@login,Register::class.java)
            startActivity(intent)
        }
        //login button enable
        edt_id.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btn_login.isEnabled=true
                edt_pass.hint="Password"
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
// button for login
        btn_login.setOnClickListener {
            user_id_login=edt_id.text.toString()
            var password=edt_pass.text.toString()
            // firbase base
            var database: FirebaseDatabase = FirebaseDatabase.getInstance()
            var redtodo: DatabaseReference =database.reference.child(user_id_login)
            btn_login.isEnabled=false
            // for checking password in firbse
            redtodo.addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (todoeach in snapshot.children) {
                            var t = todoeach.getValue(User_details::class.java)
                            if (t != null && t.user == user_id_login && t.pass == password) {
                                var intent = Intent(this@login, MainActivity::class.java)
                                intent.putExtra("isLogin", true)
                                intent.putExtra("user_id_login", user_id_login)
                                saveData()
                                islogin=true
                                startActivity(intent)
                            }
                            else{
                                edt_pass.setText("")
                                edt_pass.hint = "Wrong Password"
                                btn_login.isEnabled = true
                            }
                            break
                        }
                    }
                    else{
                        edt_pass.setText("")
                        edt_pass.hint = "Wrong Password"
                        btn_login.isEnabled = true
                    }
                }


                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })

        }
    }

    private fun loadData() {
        val sharedPreferences:SharedPreferences=getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val save_id=sharedPreferences.getString("id",null)
        val islogin=sharedPreferences.getBoolean("islogin",false)
        if (islogin){
            var intent = Intent(this@login, MainActivity::class.java)
            intent.putExtra("isLogin", true)
            intent.putExtra("user_id_login",save_id)
            startActivity(intent)
        }
    }

    private fun saveData() {
        val insertText=edt_id.text.toString()
        val sharedPreferences:SharedPreferences=getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        val editer:SharedPreferences.Editor=sharedPreferences.edit()
        editer.apply(){
            putString("id",insertText)
            putBoolean("islogin",true)
        }.apply()
    }
}