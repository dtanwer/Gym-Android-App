package com.example.gym_app

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.*

class Progress : AppCompatActivity() {
    var arr=ArrayList<Ex_data>()
    var user_id=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)
        user_id=intent.getStringExtra("user_id").toString()
        var database: FirebaseDatabase = FirebaseDatabase.getInstance()
        var redtodo: DatabaseReference =database.reference.child(user_id)
         var lstview:ListView=findViewById(R.id.LstView)
        redtodo.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                arr.clear()
                for (todoeach in snapshot.children){
                    var t=todoeach.getValue(Ex_data::class.java)
                    if (t!=null){
                        arr.add(t)
                    }
                }
                lstview.adapter=Adpt(this@Progress,R.layout.file,arr)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        lstview.setOnItemLongClickListener { parent, view, position, id ->
            var alert= AlertDialog.Builder(this)
            alert.setTitle("Delete Record")
            alert.setMessage("Do you want to delete record ?")
            alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                redtodo.child(arr[position].id).removeValue()
            })
            alert.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            alert.create().show()

            true
        }
    }
}