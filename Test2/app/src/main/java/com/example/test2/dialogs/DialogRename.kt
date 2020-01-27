package com.example.test2.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog



class DialogRename(context: Context, name: String) {
    private var listener: OnRenameListener? = null
    private var view: View? = null
    private lateinit var dialog: AlertDialog



    fun setOnRenameListener(f: OnRenameListener) {
        listener = f
    }

    fun show() {
        dialog.show()
    }
}

interface OnRenameListener {
    fun rename(name: String, text: String)
}