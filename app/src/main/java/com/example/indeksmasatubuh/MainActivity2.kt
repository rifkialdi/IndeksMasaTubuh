package com.example.indeksmasatubuh

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val kumpulData = intent.getBundleExtra("data_main_activity")

        val tinggi = kumpulData!!.getFloat("tinggi")
        val tinggiPangkat = (tinggi / 100) * (tinggi / 100)
        val berat = kumpulData!!.getFloat("berat")

        idtv_result2.text = """
            Tinggi: $tinggi cm
            Berat: $berat kg
        """.trimIndent()

        idbtn_submit2.setOnClickListener {
            val intent_secondMain = Intent()
            val imt = berat / tinggiPangkat
            intent_secondMain.putExtra("data_main_activity2", imt)
            setResult(Activity.RESULT_OK, intent_secondMain)
            finish()
        }
    }
}