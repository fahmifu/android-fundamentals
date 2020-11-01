package com.fundamental.fahmifuady.githubuser

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter (private var users: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View? = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(view!!)
    }

    override fun onBindViewHolder(view: ListViewHolder, position: Int) {
        val user = users[position]

        Glide.with(view.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions())
            .into(view.imgphoto)
        view.txtname.text = user.name
        view.txtusername.text = user.username
        view.txtfollowers.text = user.followers
        view.txtfollowing.text = user.following
        view.txtrepository.text = user.repository

        val mContext = view.itemView.context

        view.itemView.setOnClickListener{
            val moveToDetail = Intent(mContext, Detail::class.java)
            moveToDetail.putExtra(Detail.EXTRA_NAME, user.name)
            moveToDetail.putExtra(Detail.EXTRA_USERNAME, user.username)
            moveToDetail.putExtra(Detail.EXTRA_FOLLOWERS, user.followers)
            moveToDetail.putExtra(Detail.EXTRA_FOLLOWING, user.following)
            moveToDetail.putExtra(Detail.EXTRA_REPOSITORY, user.repository)
            moveToDetail.putExtra(Detail.EXTRA_LOCATION, user.location)
            moveToDetail.putExtra(Detail.EXTRA_COMPANY, user.company)
            moveToDetail.putExtra(Detail.EXTRA_AVATAR, user.avatar)
            mContext.startActivity(moveToDetail)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ListViewHolder(view: View): RecyclerView.ViewHolder(view){
        var txtname: TextView = view.findViewById(R.id.txt_name)
        var txtusername: TextView = view.findViewById(R.id.txt_username)
        var txtfollowers: TextView = view.findViewById(R.id.txt_number_of_followers)
        var txtfollowing: TextView = view.findViewById(R.id.txt_number_of_following)
        var txtrepository: TextView = view.findViewById(R.id.txt_number_of_repository)
        var imgphoto: CircleImageView = view.findViewById(R.id.img_photo)
    }
}