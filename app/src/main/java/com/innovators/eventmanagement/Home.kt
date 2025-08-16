package com.innovators.eventmanagement

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.innovators.eventmanagement.Fragments.Filter
import com.innovators.eventmanagement.Fragments.Home
import com.innovators.eventmanagement.Fragments.Profile

class Home : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary_color)

        supportFragmentManager.beginTransaction()
            .replace(R.id.homeFragmentContainer, Home())
            .commit()

        val btnHome : Button = findViewById(R.id.btn_home)
        btnHome.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeFragmentContainer, Home())
                .commit()
        }

        val btnFilter : Button = findViewById(R.id.btn_filter)

        btnFilter.setOnClickListener (){
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeFragmentContainer, Filter())
                .commit()
        }

        val btnProfile : Button = findViewById(R.id.btn_profile)

        btnProfile.setOnClickListener (){
            supportFragmentManager.beginTransaction()
                .replace(R.id.homeFragmentContainer, Profile())
                .commit()
        }
    }
}
