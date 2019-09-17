package com.ricardo.testesantander.helper

import com.ricardo.testesantander.model.Launches
import com.ricardo.testesantander.model.UserAccountParse
import retrofit2.Call
import retrofit2.http.*

interface Service {

    @FormUrlEncoded
    @POST("login/")
    fun validateUser(
        @Field("user") user: String?,
        @Field("password") password: String?
    ): Call<UserAccountParse>?

    @GET("statements/{idUser}")
    fun getDatail(
        @Path("idUser") idUser: Int
    ): Call<Launches>
}