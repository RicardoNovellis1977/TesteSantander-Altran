package com.ricardo.testesantander.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserAccount(
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("name")
var name: String,
@SerializedName("bankAccount")
var bankAccount: String,
@SerializedName("agency")
var agency: Int,
@SerializedName("balance")
var balance: Double) :Serializable

