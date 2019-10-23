package com.webappclouds.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfNotes = ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add dummy data
        listOfNotes.add(
            Note(
                1,
                " meet professor",
                "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."
            )
        )
        listOfNotes.add(
            Note(
                2,
                " meet doctor",
                "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."
            )
        )
        listOfNotes.add(
            Note(
                3,
                " meet friend",
                "Create any pattern of your own - tiles, texture, skin, wallpaper, comic effect, website background and more.  Change any artwork of pattern you found into different flavors and call them your own."
            )

        )

        var myNotesAdapter = MyNotesAdapter(listOfNotes)
        lvNotes.adapter = myNotesAdapter
    }

    inner class MyNotesAdapter : BaseAdapter {

        var listOfNotes = ArrayList<Note>()

        constructor(listOfNotes: ArrayList<Note>) : super() {
            this.listOfNotes = listOfNotes
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.ticket, null)
            var myNote = listOfNotes[p0]
            myView.tvTitle.text = myNote.noteName
            myView.tvDesc.text = myNote.noteDesc

            return myView
        }

        override fun getItem(p0: Int): Any {
            return listOfNotes[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfNotes.size
        }
    }
}

