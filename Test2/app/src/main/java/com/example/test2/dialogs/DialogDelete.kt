package uz.xsoft.lesson21pdp11

import android.content.Context
import androidx.appcompat.app.AlertDialog


class DialogDelete (context: Context){
    private var listener: OnDelNameListener? = null
    private val dialog = AlertDialog.Builder(context)
        .setTitle("O'chirish")

        .setPositiveButton("Ha") { _, _ ->
            listener?.delete("ha")

        }
        .setNegativeButton("Yo'q", null)
        .create()

    fun setOnDelListener(f: OnDelNameListener) {
        listener = f
    }

    fun show() {
        dialog.show()
    }
}
interface OnDelNameListener {
    fun delete(name: String)
}