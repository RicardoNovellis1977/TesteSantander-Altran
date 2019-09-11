package com.ricardo.testesantander.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserAccount {

    @SerializedName("userId")
    @Expose
    var userId: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("bankAccount")
    @Expose
    var bankAccount: String? = null
    @SerializedName("agency")
    @Expose
    var agency: Int? = null
    @SerializedName("balance")
    @Expose
    var balance: Double? = null
}