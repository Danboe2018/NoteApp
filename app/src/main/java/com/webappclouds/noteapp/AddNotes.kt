package com.webappclouds.noteapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_notes.*
import kotlinx.android.synthetic.main.ticket.*

class AddNotes : AppCompatActivity() {

    val dbTable = "Notes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
    }

    fun butAdd(view: View) {
        var dbManager = DbManager(this)

        val values = ContentValues()
        values.put("Title", etTitle.text.toString())
        values.put("Description", etDesc.text.toString())

        val ID = dbManager.Insert(values)
        if (ID > 0) {
            Toast.makeText(this, " note is added", Toast.LENGTH_LONG).show()
            finish()
        } else {
            Toast.makeText(this, " cannot add note ", Toast.LENGTH_LONG).show()
        }
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
