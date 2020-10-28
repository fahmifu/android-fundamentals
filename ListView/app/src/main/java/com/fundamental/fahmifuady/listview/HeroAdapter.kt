package com.fundamental.fahmifuady.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class HeroAdapter internal constructor(private val context: Context): BaseAdapter(){
    internal var heroes = arrayListOf<Hero>()
    override fun getCount(): Int {
        return heroes.size
    }

    override fun getItem(position: Int): Any {
        return heroes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent,false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtname: TextView = view.findViewById(R.id.txt_name)
        private val txtdescription: TextView = view.findViewById(R.id.txt_description)
        private val imgphoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(hero: Hero) {
            txtname.text = hero.name
            txtdescription.text = hero.description
            imgphoto.setImageResource(hero.photo)
        }

    }
}