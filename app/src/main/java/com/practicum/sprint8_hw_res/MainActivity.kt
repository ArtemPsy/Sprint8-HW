package com.practicum.sprint8_hw_res

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchButton = findViewById<Button>(R.id.buttonSearch)
        val buttClickListener: View.OnClickListener = View.OnClickListener {
            val searchIntent = Intent(this@MainActivity, SearchActivity::class.java)
            startActivity(searchIntent)
        }

        searchButton.setOnClickListener(buttClickListener)

        val libraryButton = findViewById<Button>(R.id.buttonLibrary)
        libraryButton.setOnClickListener {
            val libraryIntent = Intent(this, MediaLibraryActivity::class.java)
            startActivity(libraryIntent)
        }
        val settingsButton = findViewById<Button>(R.id.buttonSettings)
        settingsButton.setOnClickListener {
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }

    }
}