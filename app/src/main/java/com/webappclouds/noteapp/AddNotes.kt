package com.webappclouds.noteapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_notes.*
import kotlinx.android.synthetic.main.ticket.*
import java.lang.Exception

class AddNotes : AppCompatActivity() {

    val dbTable = "Notes"
    var id = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        try {
            var bundle: Bundle = intent.extras!!
            id = bundle.getInt("ID")
            if (id != 0) {
                etTitle.setText(bundle.getString("name"))
                etDesc.setText(bundle.getString("desc"))
            }
        } catch (ex: Exception) {
        }
    }

    fun butAdd(view: View) {
        var dbManager = DbManager(this)

        val values = ContentValues()
        values.put("Title", etTitle.text.toString())
        values.put("Description", etDesc.text.toString())

        if (id == 0) {
            val ID = dbManager.Insert(values)
            if (ID > 0) {
                Toast.makeText(this, " note is added", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, " cannot add note ", Toast.LENGTH_LONG).show()
            }
        } else {
            var selectioArgs = arrayOf(id.toString())
            val ID = dbManager.Update(values, "ID=?", selectioArgs)
            if (ID > 0) {
                Toast.makeText(this, " note is added", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, " cannot add note ", Toast.LENGTH_LONG).show()
            }
        }
    }
}
