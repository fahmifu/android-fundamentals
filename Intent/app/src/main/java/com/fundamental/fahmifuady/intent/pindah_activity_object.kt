package com.fundamental.fahmifuady.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class pindah_activity_object : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val PERSON = "x_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_object)

        val tampilkanObject: TextView = findViewById(R.id.object_diterima)
        val person = intent.getParcelableExtra<Person>(PERSON) as Person
        val text = """
            Name: ${person.name.toString()}
            Email: ${person.email}
            Age: ${person.age}
            Location: ${person.city}
        """.trimIndent()
        tampilkanObject.text = text

        val backbutton: Button = findViewById(R.id.back)
        backbutton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back -> {
                val moveintent = Intent(this@pindah_activity_object, MainActivity::class.java)
                startActivity(moveintent)
            }
        }
    }
}