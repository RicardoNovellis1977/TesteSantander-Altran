package com.ricardo.testesantander.helper

import com.ricardo.testesantander.model.UserLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface Service {

    @FormUrlEncoded
    @POST("login/")
    fun validateUser(
        @Field("user") user: String?,
        @Field("password") password: String?
    ): Call<UserLogin>?
}