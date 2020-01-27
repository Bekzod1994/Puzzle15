package com.example.test2.database

import android.content.ContentValues
import android.content.Context
import com.example.kurs.database.Database
import com.example.test2.data.Data
import uz.xsoft.lesson21pdp11.database.DBHelper

class AdminDatabese(val context: Context): DBHelper(context,"ariza.db"), Database<Data> {
    override fun getData(): List<Data> {
        val ls = ArrayList<Data>()
        val cursor = database().rawQuery("SELECT * FROM $TABLE_CONTACT", null)
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast) {
                ls.add(
                    Data(
                        cursor.getLong(cursor.getColumnIndex("id"))as Int ,
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("last_name")),
                        cursor.getString(cursor.getColumnIndex("login")),
                        cursor.getString(cursor.getColumnIndex("password")),
                        cursor.getInt(cursor.getColumnIndex("massemger_id"))
                    )
                )
                cursor.moveToNext()
            }
        }
        cursor.close()
        return ls
    }

    override fun addData(data: Data): Long {
        val cv = ContentValues()
        cv.put("id",data.id)
        cv.put("name", data.name)
        cv.put("last_name", data.lastName)
        cv.put("login", data.login)
        cv.put("massemger_id", data.massenger_id)
        return database().insert(TABLE_CONTACT, null, cv)
    }

    override fun deleteData(data: Data) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateData(data: Data) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(pos: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val TABLE_CONTACT = "user"


    }

