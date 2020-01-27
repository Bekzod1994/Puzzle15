package uz.xsoft.lesson21pdp11.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.FileOutputStream


abstract class DBHelper(context: Context, private val dbName: String) :
    SQLiteOpenHelper(context, dbName, null, 1) {
    private val res = context.resources
    private val assets = context.assets
    private val folder = context.getDatabasePath(dbName)
    private var db: SQLiteDatabase? = null

    init {
        if (!folder.exists()) {
            readableDatabase
            copyFromAssets()
        }
        openDatabase()
    }

    private fun openDatabase() {

        if (folder.exists() && db?.isOpen == true) {
            return
        }
        db = SQLiteDatabase.openDatabase(folder.path, null, SQLiteDatabase.OPEN_READWRITE)
    }


    override fun onCreate(db: SQLiteDatabase) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    protected fun database() = db!!

    private fun copyFromAssets(): Boolean {
        try {
            val inputStream = assets.open(dbName)
            val outputStream = FileOutputStream(folder)
            val buff = ByteArray(1024)
            var length: Int
            do {
                length = inputStream.read(buff)
                outputStream.write(buff, 0, length)
            } while (length > 0)
            outputStream.flush()
            outputStream.close()
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

    }


}