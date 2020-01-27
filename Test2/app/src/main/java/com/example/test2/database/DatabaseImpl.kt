package uz.xsoft.lesson21pdp11.database

import android.content.ContentValues
import android.content.Context
import com.example.kurs.database.Database
import com.example.test2.data.ArizaData
import com.example.test2.data.Data

 class DatabaseImpl(context: Context) : DBHelper(context, "ariza.db"), Database<ArizaData> {
    override fun getCount(pos: Int): Int {
        var count = 0
        val cursor = database().rawQuery("SELECT count (*) name from ariza  ",null)
        if (cursor.moveToFirst()){
            count = cursor.getInt(cursor.getColumnIndex("id"))
        }
        return count}



    private val TABLE_CHAT = "chat"

    override fun getData(): List<ArizaData> {
        val ls = ArrayList<ArizaData>()
        val cursor = database().rawQuery("SELECT * FROM $TABLE_CHAT", null)
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast) {
                ls.add(
                    ArizaData(
                        cursor.getLong(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("input_mass")),
                        cursor.getString(cursor.getColumnIndex("output_mass"))
                    )
                )
                cursor.moveToNext()
            }
        }
        cursor.close()
        return ls
    }

    override fun addData(data: ArizaData): Long {
        val cv = ContentValues()
        cv.put("id",data.id)
        cv.put("input_mass", data.inputMass)
        cv.put("output_mass", data.outputMass)
        return database().insert(TABLE_CHAT, null, cv)
    }

    override fun deleteData(data: ArizaData) {
        //Remove count
       database().delete(TABLE_CHAT, "id=${data.id}", null)
    }

    override fun updateData(data: ArizaData) {
        val cv = ContentValues()
        cv.put("input_mass", data.inputMass)
        cv.put("output_mass", data.outputMass)

        //update count
        database().update(TABLE_CHAT, cv, "id=${data.id}", null)
    }
}
