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
        const val EXTRA_USERDATA = "extra_userdata"
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
        val signup1: Button = findViewById(R.id.btn_signup2)

        //get data from parcelable
        val v = intent.getParcelableExtra<User>(EXTRA_USERDATA)

        //sent value to each item in detail_activity.xml
        name.text = v!!.name
        username.text = v.username
        followers.text = v.followers
        following.text = v.following
        repository.text = v.repository
        repository1.text = v.repository
        location.text = v.location
        company.text = v.company
        //using glide for image (avatar)
        Glide.with(this)
            .load(v.avatar)
            .apply(RequestOptions())
            .into(avatar)

        signup.setOnClickListener(this)
        signup1.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when(v?.id) {
            R.id.btn_signup -> {
                val url = "https://github.com/join"
                val moveIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(moveIntent)
            }
            R.id.btn_signup2 -> {
                val url = "https://github.com/join"
                val moveIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(moveIntent)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}