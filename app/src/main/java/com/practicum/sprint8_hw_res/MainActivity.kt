package com.practicum.sprint8_hw_res

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchButton = findViewById<Button>(R.id.search_button)
        val buttClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Toast.makeText(
                    this@MainActivity,
                    "Работает searchButton",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        searchButton.setOnClickListener(buttClickListener)

        val libraryButton = findViewById<Button>(R.id.library_button)
        libraryButton.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Работает libraryButton",
                Toast.LENGTH_SHORT
            ).show()
        }

        val settingsButton = findViewById<Button>(R.id.settings_button)
        settingsButton.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Работает settingsButton",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}