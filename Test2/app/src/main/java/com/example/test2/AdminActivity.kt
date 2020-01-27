package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kurs.database.Database
import com.example.test2.adapter.AdapterUser
import com.example.test2.adapter.AdminAdapter
import com.example.test2.data.ArizaData
import com.example.test2.dialogs.DialogRename
import com.example.test2.dialogs.OnRenameListener
import kotlinx.android.synthetic.main.activity_admin.*
import uz.xsoft.lesson21pdp11.DialogDelete
import uz.xsoft.lesson21pdp11.OnDelNameListener
import uz.xsoft.lesson21pdp11.database.DatabaseImpl

class AdminActivity : AppCompatActivity() {
    private lateinit var database: Database<ArizaData>
    private lateinit var data: ArrayList<ArizaData>
    private lateinit var adapter: AdminAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        setTitle("Arizalar")
        database = DatabaseImpl(this)
        data = ArrayList(database.getData())
        adapter = AdminAdapter(data,this)
        list_item.adapter = adapter
    }

}
