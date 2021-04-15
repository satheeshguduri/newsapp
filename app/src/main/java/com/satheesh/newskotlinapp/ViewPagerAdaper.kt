package com.satheesh.newskotlinapp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_page.view.*
import kotlinx.android.synthetic.main.news_layout.*
import kotlinx.android.synthetic.main.news_layout.view.*


class ViewPagerAdaper(val titleAL: ArrayList<String>,val descAL: ArrayList<String>,val  headAL: ArrayList<String>,val imagesAL: ArrayList<String>,val newsAL: ArrayList<String>): RecyclerView.Adapter<PagerVH>() {




    //array of colors to change the background color of screen
    private val colors = intArrayOf(
            android.R.color.black,
            android.R.color.holo_red_light,
            android.R.color.holo_blue_dark,
            android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {

      return  PagerVH(
              LayoutInflater.from(parent.context).inflate(R.layout.news_layout, parent, false)
      )

    }

    //get the size of color array
    override fun getItemCount(): Int =  titleAL.size


    //binding the screen with view
    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        Log.v("count in condition", titleAL.size.toString())
        headline.text = titleAL[position]
        desc.text = descAL[position]
        swipeText.text = "Swipe Up"
        head.text = descAL[position]
        taphere.text = newsAL[position]
        Picasso.get().load(imagesAL[position]).into(imageView)
        Picasso.get().load(imagesAL[position]).into(imageView2)



    }

}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)

