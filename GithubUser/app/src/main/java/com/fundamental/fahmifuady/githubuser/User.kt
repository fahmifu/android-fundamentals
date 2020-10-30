package com.fundamental.fahmifuady.githubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var username: String,
    var name: String,
    var location: String,
    var repository: String,
    var companiy: String,
    var followers: String,
    var following: String,
    var photo: Int
) : Parcelable