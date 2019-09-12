package com.ricardo.testesantander.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserAccountParse
    (
    @SerializedName("userAccount")
    var userAccount: UserAccount
): Serializable