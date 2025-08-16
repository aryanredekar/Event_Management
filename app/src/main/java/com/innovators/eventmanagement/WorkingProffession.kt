package com.innovators.eventmanagement

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class WorkingProffession : AppCompatActivity() {
    private val professions = arrayOf(
        "Make Artist", "Event Manager", "Photographer", "Decorator",
        "Caterers", "Mehendi Artist", "Fashion Designer",
        "Vintage Car Owner", "Choreographer"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_working_proffession)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val professionEditText = findViewById<TextInputEditText>(R.id.professionEditText)
        val professionInputLayout = findViewById<TextInputLayout>(R.id.professionInputLayout)
        val submitButton = findViewById<MaterialButton>(R.id.submitProfessionButton)

        professionEditText.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Select Profession")
            builder.setItems(professions) { _, which ->
                professionEditText.setText(professions[which])
            }
            builder.show()
        }

        submitButton.setOnClickListener {
            val selectedProfession = professionEditText.text.toString().trim()
            if (selectedProfession in professions) {
                Toast.makeText(this, "Profession: $selectedProfession", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            } else {
                professionInputLayout.error = "Please select a valid profession"
            }
        }
    }
    /*private fun showProfessionDialog(editText: TextInputEditText) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Choose your profession")
            .setItems(professions) { _, which ->
                editText.setText(professions[which])
            }
            .show()
    }*/
}