package com.fundamental.fahmifuady.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class pindah_activity_dengan_data : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val AGE = "age"
        const val NAME = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_data)

        val textview0: TextView = findViewById(R.id.textview_pindahdata)
        val umur = intent.getIntExtra(AGE, 0)
        val nama = intent.getStringExtra(NAME)
        val text = """
            Name: $nama
            My Age: $umur
        """.trimIndent()

        textview0.text = text

        val backbutton: Button = findViewById(R.id.back)
        backbutton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back -> {
                val moveintent = Intent(this@pindah_activity_dengan_data, MainActivity::class.java)
                startActivity(moveintent)
            }
        }
    }
}