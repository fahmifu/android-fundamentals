package com.fundamental.fahmifuady.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class move_for_result : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonPilih: Button
    private lateinit var rgNumber: RadioGroup

    companion object {
        const val SELECTED_VALUE_extra = "extra_selected_value"
        const val RESULT_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        buttonPilih = findViewById(R.id.btnPilih)
        rgNumber = findViewById(R.id.rg_number)

        buttonPilih.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnPilih) {
            if (rgNumber.checkedRadioButtonId != 0) {
                var value = 0
                when (rgNumber.checkedRadioButtonId) {
                    R.id.rb150 -> value = 150
                    R.id.rb200 -> value = 200
                    R.id.rb250 -> value = 250
                }

                val resultIntent = Intent()
                resultIntent.putExtra(SELECTED_VALUE_extra, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}