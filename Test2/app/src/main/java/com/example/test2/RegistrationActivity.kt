package com.example.test2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kurs.database.Database
import com.example.test2.data.ArizaData
import com.example.test2.data.Data
import com.example.test2.database.AdminDatabese
import kotlinx.android.synthetic.main.activity_registration.*
import uz.xsoft.lesson21pdp11.database.DatabaseImpl

class RegistrationActivity : AppCompatActivity() {
    private lateinit var database: Database<Data>
    private lateinit var data: ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = AdminDatabese(this)
        data = ArrayList(database.getData())
        setContentView(R.layout.activity_registration)
        sign_up1.setOnClickListener {
            if ((inputLogin1.text?.length)!!>=1&& (inputName1.text?.length)!!>=1&& (inputPass1.text?.length)!!>=1&& (inputFirstName1.text?.length)!!>=1){
            val intent = Intent(this,UserActivity::class.java)
                data.add(
                    Data(data.size,inputName1.text.toString(),inputFirstName1.text.toString(),inputLogin1.text.toString(),inputPass1.text.toString(),0
                    )
                )
                database.addData(Data(data.size,inputName1.text.toString(),inputFirstName1.text.toString(),inputLogin1.text.toString(),inputPass1.text.toString(),0
                ))

            startActivity(intent)}
        }
    }
}
