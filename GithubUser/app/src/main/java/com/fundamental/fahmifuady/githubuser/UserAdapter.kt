package com.fundamental.fahmifuady.githubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter internal constructor(private val context: Context): BaseAdapter(){
    internal var users= arrayListOf<User>()

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemview = convertView
        if (itemview == null) {
            itemview = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        }

        val viewHolder = ViewHolder(itemview as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemview
    }

    private inner class ViewHolder constructor(view: View) {
        private val txtname: TextView = view.findViewById(R.id.txt_name)
        private val txtusername: TextView = view.findViewById(R.id.txt_username)
        private val txtfollowers: TextView = view.findViewById(R.id.txt_number_of_followers)
        private val txtfollowing: TextView = view.findViewById(R.id.txt_number_of_following)
        private val txtrepository: TextView = view.findViewById(R.id.txt_number_of_repository)
        private val imgphoto: CircleImageView = view.findViewById(R.id.img_photo)

        fun bind(user: User) {
            txtname.text = user.name
            txtusername.text = user.username
            txtfollowers.text = user.followers
            txtfollowing.text = user.following
            txtrepository.text = user.repository
            imgphoto.setImageResource(user.avatar)
        }
    }
}