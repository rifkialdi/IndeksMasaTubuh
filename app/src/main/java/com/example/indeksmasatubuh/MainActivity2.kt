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

        /* Mengambil data bundle dari activity1 */
        val kumpulData = intent.getBundleExtra("data_main_activity")

        /* Mengambil data float dari activity1 */
        val tinggi = kumpulData!!.getFloat("tinggi")
        val berat = kumpulData!!.getFloat("berat")

        /* Rumus nya */
        val tinggiPangkat = (tinggi / 100) * (tinggi / 100)

        /* Menampilkan text dari variabel yang di get*/
        idtv_result2.text = """
            Tinggi: $tinggi cm
            Berat: $berat kg
        """.trimIndent()

        idbtn_submit2.setOnClickListener {
            /* Rumus bb ideal */
            val imt = berat / tinggiPangkat

            /* Menaruh data dengan Intent() */
            val intent_secondMain = Intent()
            intent_secondMain.putExtra("data_main_activity2", imt)

            /* menutup activity */
            setResult(Activity.RESULT_OK, intent_secondMain)
            finish()
        }
    }
}