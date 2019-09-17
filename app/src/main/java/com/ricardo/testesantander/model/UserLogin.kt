package com.ricardo.testesantander.model

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("user")
    var user: String? = null,
    @SerializedName("password")
    var password: String? = null
)






