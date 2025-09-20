package com.example.lab_week_01 // <-- change to your actual package name if different

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text?.toString()?.trim().orEmpty()
            val studentInput = findViewById<TextInputEditText>(R.id.student_input)
                ?.text?.toString()?.trim().orEmpty()

            when {
                nameInput.isEmpty() -> {
                    showCenterToast(getString(R.string.name_empty))
                }
                !studentInput.matches(Regex("\\d{11}")) -> {
                    showCenterToast(getString(R.string.student_error))
                }
                else -> {
                    // Both valid → show name + student number
                    val result = getString(R.string.name_greet) +
                            " " + nameInput +
                            "\nNIM: " + studentInput
                    nameDisplay.text = result
                }
            }
        }
    }

    private fun showCenterToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).apply {
            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }
}
