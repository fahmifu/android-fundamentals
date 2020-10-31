package com.fundamental.fahmifuady.githubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Detail: AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_AVATAR = "extra_avatar"
        const val EXTRA_FOLLOWERS = "extra_followers"
        const val EXTRA_FOLLOWING = "extra_following"
        const val EXTRA_LOCATION = "extra_location"
        const val EXTRA_COMPANY = "extra_company"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        //ganti nama actionbar
        val a = supportActionBar
        a!!.title = "Detail User"
        a.setDisplayHomeAsUpEnabled(true)
    }
}