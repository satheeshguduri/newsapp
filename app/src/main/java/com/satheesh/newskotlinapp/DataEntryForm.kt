package com.satheesh.newskotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DataEntryForm  : AppCompatActivity() {

    lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_layout)

        //data base object
        db = FirebaseDatabase.getInstance().getReference("news")

        // data to be  store in db
        val requestObj = RequestClass("example title0", "example desc", "example imagelink", "example newslink", "example heading")

// store the data by using the db.
        // db.child("3").setValue(requestObj)

    }
}
