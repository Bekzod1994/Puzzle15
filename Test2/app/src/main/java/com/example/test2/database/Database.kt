package com.example.kurs.database


interface Database<D> {
    fun getData():List<D>
    fun addData(data: D):Long
    fun deleteData(data: D)
    fun updateData(data: D)
    fun getCount(pos: Int): Int

}