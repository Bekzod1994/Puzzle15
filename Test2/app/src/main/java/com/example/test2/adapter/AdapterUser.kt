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
import kotlinx.android.synthetic.main.convert_view.view.*
import uz.xsoft.lesson21pdp11.database.DatabaseImpl

class AdapterUser(val data: ArrayList<ArizaData>, val context :Context):BaseAdapter() {
    private var listenerEdit: ItemClick? = null
    private var listenerDelete: ItemClick? = null
    private var listenerOnClick: ItemClick? = null

    fun setOnEditListener(f: ItemClick) {
        listenerEdit = f
    }
    fun setOnClickListener(f: ItemClick) {
        listenerOnClick = f
    }
    fun setOnDeleteListener(f: ItemClick) {
        listenerDelete = f
    }
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, root: ViewGroup): View {
        val v  = LayoutInflater.from(root.context)
            .inflate(R.layout.convert_view,root,false)
        val d = getItem(position)
        v.setOnClickListener{listenerOnClick?.invoke(position)}
        v.buttonDelete.setOnClickListener { listenerDelete?.invoke(position)}
        v.buttonEdit.setOnClickListener { listenerEdit?.invoke(position)}
        v.name.text =d.inputMass
        v.text1.text = d.outputMass

        return v

    }

    override fun getItem(position: Int): ArizaData = data[position]
    override fun getItemId(p0: Int): Long = 0L


    override fun getCount(): Int = data.size
}
typealias ItemClick = (Int) -> Unit //#typedef