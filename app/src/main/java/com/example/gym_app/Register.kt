package com.example.gym_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var edt_fname: EditText =findViewById(R.id.edt_firstname_r)
        var edt_lname: EditText =findViewById(R.id.edt_last_name_r)
        var edt_email: EditText =findViewById(R.id.edt_email_r)
        var edt_userid: EditText =findViewById(R.id.edt_user_id_r)
        var edt_password: EditText =findViewById(R.id.edt_password_r)
        var edt_confPassword: EditText =findViewById(R.id.edt_confpassword_r)
        var txtpass_match: TextView =findViewById(R.id.txt_passward_match_r)
        var btn_r: Button =findViewById(R.id.btn_signin_r)
        btn_r.isEnabled=false

        //confir password checking
        edt_confPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(edt_confPassword.text.toString()==edt_password.text.toString()){
                    if (edt_confPassword.text.toString().length<8){
                        txtpass_match.text="*Password length Should grater then Eight!"
                    }else{
                        txtpass_match.text=""
                        btn_r.isEnabled=true
                    }

                }
                else{
                    txtpass_match.text="Your Password don't match!"
                    btn_r.isEnabled=false
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        //register button
        btn_r.setOnClickListener {
            var user_id=edt_userid.text.toString()
            var password=edt_password.text.toString()
            var fname=edt_fname.text.toString()
            var lname=edt_lname.text.toString()
            var email=edt_email.text.toString()
            var database: FirebaseDatabase = FirebaseDatabase.getInstance()
            var redtodo: DatabaseReference =database.reference.child(user_id)
            val pass_token:String=redtodo.push().key.toString()
            redtodo.child(pass_token).setValue(User_details(pass_token,user_id,password,fname,lname,email))
            var data= Intent(this@Register,login::class.java)
            Toast.makeText(this,"Registation Successful",Toast.LENGTH_SHORT).show()
            startActivity(data)
        }

    }
}