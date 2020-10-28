package com.fundamental.fahmifuady.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class pindah_activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_activity)

        val backbutton: Button = findViewById(R.id.back)
        backbutton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back -> {
                val moveIntent = Intent(this@pindah_activity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}