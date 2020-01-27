package com.example.test2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.test2.R
import com.example.test2.data.ArizaData
import com.example.test2.data.Data
import com.example.test2.database.AdminDatabese
import kotlinx.android.synthetic.main.convert_view.view.*

class AdminAdapter(val data: ArrayList<ArizaData>, val context :Context):BaseAdapter() {
    private var listenerEdit: ItemClick1? = null


    fun setOnEditListener(f: ItemClick1) {
        listenerEdit = f
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, root: ViewGroup): View {
        val v  = LayoutInflater.from(root.context)
            .inflate(R.layout.convert_view_admin,root,false)
        val d = getItem(position)
        v.name.text =d.inputMass
        v.text1.text= d.outputMass
        return v

    }

    override fun getItem(position: Int): ArizaData = data[position]
    override fun getItemId(p0: Int): Long = 0L


    override fun getCount(): Int = data.size
}
typealias ItemClick1 = (Int) -> Unit //#typedef