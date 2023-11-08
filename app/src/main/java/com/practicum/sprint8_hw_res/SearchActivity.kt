package com.practicum.sprint8_hw_res

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SearchActivity : AppCompatActivity() {
    private var savedEditText = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        savedInstanceState?.let {
            savedEditText = it.getString("text", "")
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val inputEditText = findViewById<EditText>(R.id.search_text_field)
        val searchPressedIcon = findViewById<ImageView>(R.id.search_pressed_icon)
        val cleaningPressedIcon = findViewById<ImageView>(R.id.cleaning_pressed_icon)

        inputEditText.setText(savedEditText)

        toolbar.setOnClickListener {
            onBackPressed()
        }

        cleaningPressedIcon.setOnClickListener {
            inputEditText.setText("")
        }

        val simpleTextWatcher = object : SimpleTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                cleaningPressedIcon.visibility = if (s.isNullOrEmpty()) View.GONE else View.VISIBLE
                savedEditText = s.toString()
            }
        }

        inputEditText.addTextChangedListener(simpleTextWatcher)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", savedEditText)
    }


    abstract class SimpleTextWatcher : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {}
    }
}