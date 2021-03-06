package com.example.medicinesapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var uid: String?,
    val name: String,
    val email: String,
    val isDoctor:Boolean,
    var lastActive:Long,
    var isOnline:Boolean,
    var photoPath:String?,
    var isChecked:Boolean?
) : Parcelable {
    constructor() : this("", "", "",false,0,false,null,null)
}