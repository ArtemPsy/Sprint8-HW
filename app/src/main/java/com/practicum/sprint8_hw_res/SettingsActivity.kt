package com.practicum.sprint8_hw_res


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switch = findViewById<Switch>(R.id.switchSettings)

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setOnClickListener {
            onBackPressed()
        }

        val reportSupportImage = findViewById<ImageView>(R.id.supportSettings)
        reportSupportImage.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SENDTO)
            shareIntent.data = Uri.parse("mailto:")
            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.email)))
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.headerMail))
            shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.textMail))
            startActivity(shareIntent)
        }

        val userAgreement = findViewById<ImageView>(R.id.userAgreement)
        userAgreement.setOnClickListener {
            val url = Uri.parse(getString(R.string.userAgreementUrl))
            startActivity(
                Intent(Intent.ACTION_VIEW, url)
            )
        }
    }
}