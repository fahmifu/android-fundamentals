package com.fundamental.fahmifuady.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var panjang: EditText
    private lateinit var lebar: EditText
    private lateinit var tinggi: EditText
    private lateinit var tombolhitung: Button
    private lateinit var tempathasil: TextView
    private lateinit var tombolclear: Button

    companion object{
        private const val hasil_kondisi = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panjang = findViewById(R.id.vp)
        lebar = findViewById(R.id.vl)
        tinggi = findViewById(R.id.vt)
        tombolhitung = findViewById(R.id.tombol)
        tombolclear = findViewById(R.id.clear)
        tempathasil = findViewById(R.id.hasilnya)

        tombolhitung.setOnClickListener(this)
        tombolclear.setOnClickListener(this)

        if (savedInstanceState != null) {
            val hasil = savedInstanceState.getString(hasil_kondisi)
            tempathasil.text = hasil
        }
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.tombol){
            val masukkanPanjang = panjang.text.toString().trim()
            val masukkanLebar = lebar.text.toString().trim()
            val masukkanTinggi = tinggi.text.toString().trim()
            val pesanerror = "Bagian ini harus diisi"
            var isnull = false

            when {
                masukkanPanjang.isEmpty() -> {
                    isnull = true
                    panjang.error = pesanerror
                }
                masukkanLebar.isEmpty() -> {
                    isnull = true
                    lebar.error = pesanerror
                }
                masukkanTinggi.isEmpty() ->{
                    isnull = true
                    tinggi.error = pesanerror
                }
            }

            if (!isnull){
                val volumenyaAdalah = masukkanPanjang.toDouble() * masukkanLebar.toDouble() * masukkanTinggi.toDouble()
                tempathasil.text = volumenyaAdalah.toString()
            }
        }
        if (v.id == R.id.clear) {
            val hasil = "Hasil"
            tempathasil.text = hasil
            panjang.text = null
            lebar.text = null
            tinggi.text = null
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(hasil_kondisi, tempathasil.text.toString())
    }
}