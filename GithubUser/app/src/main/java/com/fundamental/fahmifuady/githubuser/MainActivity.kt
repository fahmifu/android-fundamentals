package com.fundamental.fahmifuady.githubuser

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.Array as Array1
import kotlin.collections.ArrayList as ArrayList1

class MainActivity : AppCompatActivity() {

    private lateinit var dataName: Array1<String>
    private lateinit var dataUserName: Array1<String>
    private lateinit var dataFollowers: Array1<String>
    private lateinit var dataFollowing: Array1<String>
    private lateinit var dataRepository: Array1<String>
    private lateinit var dataLocation: Array1<String>
    private lateinit var dataCompany: Array1<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var rvUser: RecyclerView
    private var users: ArrayList1<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv)
        rvUser.setHasFixedSize(true)

        val a = supportActionBar
        a!!.title = "GitHub Users"

        prepare()
        addItem()
        show()
    }

    //get data sources
    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataUserName = resources.getStringArray(R.array.username)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataRepository = resources.getStringArray(R.array.repository)
        dataLocation = resources.getStringArray(R.array.location)
        dataCompany = resources.getStringArray(R.array.company)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    //get data each category
    private fun addItem(): ArrayList1<User> {
        val listUser = ArrayList1<User>()
        for (position in dataName.indices) {
            val user = User(
                dataAvatar.getResourceId(position,-1),
                dataName[position],
                dataUserName[position],
                dataFollowers[position],
                dataFollowing[position],
                dataRepository[position],
                dataLocation[position],
                dataCompany[position]
            )
            users.add(user)
        }
        return listUser
    }

    //showing data
    private fun show() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listuseradapter = UserAdapter(users)
        rvUser.adapter = listuseradapter
    }
}