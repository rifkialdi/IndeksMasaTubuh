package com.example.indeksmasatubuh

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Memberi nama saat activity oncreate */
        idedt_berat.setHint("Berat (kg)")
        idedt_tinggi.setHint("Tinggi (cm)")
        idtv_result.setText("Isikan berat dan tinggi badan anda")

        idbtn_submit.setOnClickListener {
            /* Menyimpan data ke bundle dan di simpan ke variabel */
            val kumpulData = Bundle()
            kumpulData.putFloat("berat", idedt_berat.text.toString().toFloat())
            kumpulData.putFloat("tinggi", idedt_tinggi.text.toString().toFloat())

            /* menaruh data bundle dengan explisit intent*/
            val intent_mainSecond = Intent(this, MainActivity2::class.java)
            intent_mainSecond.putExtra("data_main_activity", kumpulData)
            /* Memulai activity for result */
            startActivityForResult(intent_mainSecond, SECOND_ACTIVITY)
        }
    }

    /* Function jika activity nya onresume dia akan memanggil fungsi isianBersih() */
    override fun onResume() {
        super.onResume()
        isianBersih()
    }

    /* fungsi untuk mengecek data dari activity2 */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ((requestCode == SECOND_ACTIVITY) and (resultCode == Activity.RESULT_OK)){
            val imt = data!!.getFloatExtra("data_main_activity2", 1.0F)
            val imtString = "%.2f".format(imt)
            idtv_result.setText("IMT : $imtString ${ambilDeskripsiIMT(imt)}")
        }
    }

    /* fungsi untuk mengecek data imt dengan when expresion */
    private fun ambilDeskripsiIMT(imt: Float) : String {
        return when(imt){
            in 1.0..18.5 -> "Ringan"
            in 18.6..24.9 -> "Normal"
            in 25.0..29.9 -> "Lebih"
            in 30.0..34.99 -> "Obesitas Kelas 1"
            in 35.0..39.99 -> "Obesitas Kelas 2"
            else -> "Obesitas Kelas 3"
        }
    }

    /* Function agar edit text nya jadi kosong */
    private fun isianBersih(){
        idedt_berat.setText("")
        idedt_tinggi.setText("")
    }
}