package com.satheesh.newskotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_layout.*
import kotlinx.android.synthetic.main.news_layout.view.*


class MainActivity : AppCompatActivity() {


    lateinit var db: DatabaseReference
    var titleAL = ArrayList<String>()
    var descAL = ArrayList<String>()
    var headAL = ArrayList<String>()
    var imagelinkAL = ArrayList<String>()
    var newslinkAL = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //data base object
        db = FirebaseDatabase.getInstance().getReference("news")

        // data to be  store in db
        val requestObj = RequestClass("example title0", "example desc", "example imagelink", "example newslink", "example heading")

        // store the data by using the db.

        //onclick to move next screen


        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var data: Iterable<DataSnapshot> = dataSnapshot.children

                for (item in data) {
                    Log.v("####", item.value.toString())
                    titleAL.add(item.child("title").value.toString())
                    descAL.add(item.child("desc").value.toString())
                    headAL.add(item.child("title").value.toString())
                    imagelinkAL.add(item.child("imagelink").value.toString())
                    newslinkAL.add(item.child("newslink").value.toString())

                }


                view_pager2.adapter = ViewPagerAdaper(titleAL, descAL, headAL, imagelinkAL, newslinkAL, )

                //below line can be used to change the orientation to vertical i.e. vertical swipe
                view_pager2.orientation = ViewPager2.ORIENTATION_VERTICAL

                //  val  value : ArrayList<ResponseClass>? = dataSnapshot.getValue(ArrayList<ResponseClass>()::class.java)
                //   Log.d("####", "Value is: ${value?.get(0)?.title}")

                //  db.child(((titleAL.size)+1).toString()).setValue(requestObj)


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("33333", "Failed to read value.", error.toException())
            }
        })


    }

    fun toStart(view:View) {
        val intent = Intent(applicationContext, DataEntryForm::class.java)
        startActivity(intent)


    }



}