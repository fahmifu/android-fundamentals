package com.fundamental.fahmifuady.githubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var avatar: Int,
    var name: String,
    var username: String,
    var followers: String,
    var following: String,
    var repository: String,
    var location: String,
    var company: String
) : Parcelable