package com.ricardo.testesantander.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class UserLogin{
     companion object{

         @SerializedName("user")
         @Expose
         var user: String? = null
         @SerializedName("password")
         @Expose
         var password: String? = null

     }
}



