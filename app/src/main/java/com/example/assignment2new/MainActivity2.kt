package com.example.assignment2new

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {


    private lateinit var pet: Pet
    private lateinit var playTextView3: TextView
    private lateinit var cleanTextView2: TextView
    private lateinit var hungerTextView: TextView
    private lateinit var coverImage: ImageView
    private lateinit var petManager: PetManager


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        pet = Pet()
        playTextView3 = findViewById(R.id.textView3)
        cleanTextView2 = findViewById(R.id.cleanTextView2)
        hungerTextView = findViewById(R.id.hungerTextView)
        coverImage = findViewById(R.id.coverImage)
        petManager =PetManager(pet, this)
        petManager.startDecrementing()


        val feedButton: Button = findViewById(R.id.feedButton)
        val cleanButton: Button = findViewById(R.id.cleanButton)
        val playButton: Button = findViewById(R.id.playButton)

        // set the onClickListener for feedButton
        feedButton.setOnClickListener {
            pet.feed()
            updatePetStatus()
            // set the image resource for feedButton
            coverImage.setImageResource(R.drawable.imageView4)
        }

        //set the onClickListener for cleanButton
        cleanButton.setOnClickListener {
            pet.clean()
            updatePetStatus()
            //set the image resource for cleanButton
            coverImage.setImageResource(R.drawable.imageView2)
        }

        //set the onClickListener for playButton
        playButton.setOnClickListener {
            pet.play()
            updatePetStatus()
            //set the image resource for playButton
            coverImage.setImageResource(R.drawable.imageView5)
        }

    }

    @SuppressLint("SetTextI18n")
    fun updatePetStatus() {
        hungerTextView.text = " ${pet.feed}"
        cleanTextView2.text = " ${pet.clean}"
        playTextView3.text = " ${pet.play}"
        coverImage.setImageResource(getPetImageResource())
    }

    private fun getPetImageResource(): Int {
        return when {
            pet.isFeed() -> R.drawable.imageView4
            pet.isClean() -> R.drawable.imageView2
            else -> R.drawable.imageView5
        }
    }
}


