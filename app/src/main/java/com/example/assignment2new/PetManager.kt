package com.example.assignment2new

import android.os.Handler
import android.os.Looper

class PetManager (private val pet: Pet, private val activity: MainActivity2, private val handler: Handler = Handler(
    Looper.getMainLooper())) {
    private val decrementRunnable = object : Runnable {
        override fun run() {
            decrementValues()
            handler.postDelayed(this, 90000)
        }
    }

    private fun decrementValues() {
        pet.clean--
        pet.feed--
        pet.play--

        // Update the UI with the new values

        activity.updatePetStatus()
    }

    fun startDecrementing() {
        handler.postDelayed(decrementRunnable, 60000) //Start decrementing after 1 minute
    }
}
