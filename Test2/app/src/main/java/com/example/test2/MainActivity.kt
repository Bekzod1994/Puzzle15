package com.example.test2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kurs.database.Database
import com.example.test2.data.Data

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var database: Database<Data>
    private lateinit var data: ArrayList<Data>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sign_up.setOnClickListener {
            if (inputName.text.toString() == "Login" && inputPass.text.toString() == "Password") {
                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
            }


        }
        regis.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
