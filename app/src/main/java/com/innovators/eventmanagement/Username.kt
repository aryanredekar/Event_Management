package com.innovators.eventmanagement

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Username : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_username)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username : EditText = findViewById(R.id.usernameEditText)
        val btn : Button = findViewById(R.id.submitUsernameButton)

        btn.setOnClickListener (){
            val et_un = username.text.toString().trim()
            if(et_un.isEmpty()){
                Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, WorkingProffession::class.java)
                startActivity(intent)
            }
        }
    }
}