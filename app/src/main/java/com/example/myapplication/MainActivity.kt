package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTime = findViewById<EditText>(R.id.edtTime)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnSuggest.setOnClickListener {
            val userInput = edtTime.text.toString().trim().lowercase()
            Log.d("SocialSpark", "Input: $userInput")

            val suggestion = when (userInput) {
                "morning" -> listOf(
                    "Send a good morning text to a family member.",
                    "Check in on a friend before your day gets busy.",
                    "Send a positive message to someone close to you."
                ).random()

                "afternoon" -> listOf(
                    "Share a funny meme or interesting link with a friend.",
                    "Send a quick message to someone you have not spoken to today.",
                    "Call someone for a short catch-up."
                ).random()

                "night" -> listOf(
                    "Leave a thoughtful comment on a friend's post.",
                    "Send a kind goodnight message to someone important to you.",
                    "Invite a friend to chat for a few minutes."
                ).random()

                else -> {
                    Log.d("SocialSpark", "Invalid input")
                    Toast.makeText(
                        this,
                        "Please enter Morning, Afternoon or Night.",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
            }

            Log.d("SocialSpark", "Suggestion: $suggestion")
            txtResult.text = suggestion
        }

        btnReset.setOnClickListener {
            edtTime.text.clear()
            txtResult.text = ""
            Log.d("SocialSpark", "Reset clicked")
        }
    }
}