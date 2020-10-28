package com.fundamental.fahmifuady.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvresult: TextView

    companion object {
        private const val REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tombol_pindah_activity: Button = findViewById(R.id.pindah_activity)
        tombol_pindah_activity.setOnClickListener(this)

        val tombol_pindah_activity_dgn_data: Button = findViewById(R.id.pindah_activity_data)
        tombol_pindah_activity_dgn_data.setOnClickListener(this)

        val pindah_activity_dgn_object: Button = findViewById(R.id.pindah_activity_object)
        pindah_activity_dgn_object.setOnClickListener(this)

        val pindah_activity_dial: Button = findViewById(R.id.dial_number_activity)
        pindah_activity_dial.setOnClickListener(this)

        val pindah_activity_untuk_hasil: Button = findViewById(R.id.moveforresult)
        pindah_activity_untuk_hasil.setOnClickListener(this)

        tvresult = findViewById(R.id.tv_moveforresult)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.pindah_activity -> {
                val moveIntent = Intent(this@MainActivity, pindah_activity::class.java)
                startActivity(moveIntent)
            }
            R.id.pindah_activity_data -> {
                val moveIntent = Intent(this@MainActivity, pindah_activity_dengan_data::class.java)
                moveIntent.putExtra(pindah_activity_dengan_data.NAME, "Fahmi Fuady")
                moveIntent.putExtra(pindah_activity_dengan_data.AGE, 17)
                startActivity(moveIntent)
            }
            R.id.pindah_activity_object -> {
                val person = Person("Fahmi Fuady", 17, "fu.fahmi224@gmail.com", "Yogyakarta")
                val moveintent = Intent(this@MainActivity, pindah_activity_object::class.java)
                moveintent.putExtra(pindah_activity_object.PERSON, person)
                startActivity(moveintent)
            }
            R.id.dial_number_activity -> {
                val phoneNumber = "081393504575"
                val moveIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(moveIntent)
            }
            R.id.moveforresult -> {
                val moveForResult = Intent(this@MainActivity, move_for_result::class.java)
                startActivityForResult(moveForResult, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == move_for_result.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(move_for_result.SELECTED_VALUE_extra, 0)
                tvresult.text = "Hasil : $selectedValue"
            }
        }
    }
}