package com.fundamental.fahmifuady.githubuser

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class Detail: AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_AVATAR = "extra_avatar"
        const val EXTRA_FOLLOWERS = "extra_followers"
        const val EXTRA_FOLLOWING = "extra_following"
        const val EXTRA_REPOSITORY = "extra_repository"
        const val EXTRA_LOCATION = "extra_location"
        const val EXTRA_COMPANY = "extra_company"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        //change actionbar text
        val a = supportActionBar
        a!!.title = "Users Detail"
        a.setDisplayHomeAsUpEnabled(true)

        //identify each item in detail_activity.xml
        val avatar: CircleImageView = findViewById(R.id.img_photo)
        val name: TextView = findViewById(R.id.txt_name)
        val username: TextView = findViewById(R.id.txt_username)
        val followers: TextView = findViewById(R.id.txt_number_of_followers)
        val following: TextView = findViewById(R.id.txt_number_of_following)
        val repository: TextView = findViewById(R.id.txt_number_of_repository)
        val repository1: TextView = findViewById(R.id.txt_number_of_repository1)
        val location: TextView = findViewById(R.id.txt_location)
        val company: TextView = findViewById(R.id.txt_company)
        val signup: Button = findViewById(R.id.btn_signup)

        val vAvatar = intent.getIntExtra(EXTRA_AVATAR, 0)
        val vName= intent.getStringExtra(EXTRA_NAME)
        val vUsername= intent.getStringExtra(EXTRA_USERNAME)
        val vFollowers= intent.getStringExtra(EXTRA_FOLLOWERS)
        val vFollowing= intent.getStringExtra(EXTRA_FOLLOWING)
        val vRepository= intent.getStringExtra(EXTRA_REPOSITORY)
        val vLocation= intent.getStringExtra(EXTRA_LOCATION)
        val vCompany= intent.getStringExtra(EXTRA_COMPANY)

        //sent value to each item in detail_activity.xml
        name.text = vName
        username.text = vUsername
        followers.text = vFollowers
        following.text = vFollowing
        repository.text = vRepository
        repository1.text = vRepository
        location.text = vLocation
        company.text = vCompany
        //using glide for image (avatar)
        Glide.with(this)
            .load(vAvatar)
            .apply(RequestOptions())
            .into(avatar)

        signup.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when(v?.id) {
            R.id.btn_signup -> {
                val Url = "https://github.com/join"
                val moveIntent = Intent(Intent.ACTION_VIEW, Uri.parse("$Url"))
                startActivity(moveIntent)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}