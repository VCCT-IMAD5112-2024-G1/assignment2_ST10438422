package com.example.assignment2new

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStartedButton = findViewById<Button>(R.id.getStartedButton)
         getStartedButton.setOnClickListener {
             //code must be executed when the button is clicked
             val intent = Intent(this, MainActivity2::class.java)
             startActivity(intent)
         }

        fun onButtonClicked(view: View) {
            // code to be executed when the bottom is clicked
        }
    }
}