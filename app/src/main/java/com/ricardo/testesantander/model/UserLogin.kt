package com.ricardo.testesantander.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("user")
    val user: String,
    @SerializedName("password")
    val password: String
)






