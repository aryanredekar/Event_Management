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

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val phno : EditText = findViewById(R.id.phoneEditText)
        val btn : Button = findViewById(R.id.loginButton)
        btn.setOnClickListener (){
            val phn = phno.text.toString().trim()
            if(phn.isEmpty()){
                Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show()
            }
            else{
                if(phn.length == 10){
                    val intent = Intent(this, OTP :: class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}