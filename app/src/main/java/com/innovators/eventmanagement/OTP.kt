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

class OTP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_otp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val otp : EditText = findViewById(R.id.otpEditText)
        val btn : Button = findViewById(R.id.verifyOtpButton)

        btn.setOnClickListener (){
            val et_otp = otp.text.toString().trim()
            if(et_otp.length == 6){
                val intent = Intent(this, Username::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Enter Valid OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }
}