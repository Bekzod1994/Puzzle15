package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.kurs.database.Database
import com.example.test2.adapter.AdapterUser
import com.example.test2.data.ArizaData
import com.example.test2.dialogs.DialogRename

import com.example.test2.dialogs.OnRenameListener
import kotlinx.android.synthetic.main.activity_user.*
import uz.xsoft.lesson21pdp11.DialogDelete
import uz.xsoft.lesson21pdp11.OnDelNameListener
import uz.xsoft.lesson21pdp11.database.DatabaseImpl

class UserActivity : AppCompatActivity() {
    private lateinit var database: Database<ArizaData>
    private lateinit var data: ArrayList<ArizaData>
    private lateinit var adapter:AdapterUser
    var user_id:Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setTitle("CHat")
        database = DatabaseImpl(this)
        data = ArrayList(database.getData())
        adapter = AdapterUser(data,this)
        list_item2.adapter= adapter
        user_id = intent.getLongExtra("course_id",0)
        adapter.setOnEditListener{
            onEdit(it,data[it].outputMass)
        }
        adapter.setOnDeleteListener(this::onDelete)

    }

    private fun onEdit(position:Int,outputMass : String){
        val dialog = DialogRename(this,outputMass)
        dialog.setOnRenameListener(object : OnRenameListener {
            override fun rename(name: String,text: String) {
                val g = ArizaData(0,name,text)
                g.id = database.addData(ArizaData(0,name,text))
                data[position] = ArizaData(0,name,text)
                adapter.notifyDataSetChanged()

            }

        })
        dialog.show()

    }

    private fun onDelete(position:Int){
        val dialog = DialogDelete(this)
        dialog.setOnDelListener(object : OnDelNameListener {
            override fun delete(name: String) {
                database.deleteData(data[position])
                data.removeAt(position)
                adapter.notifyDataSetChanged()
            }

        }

        )
        dialog.show()

    }

}
