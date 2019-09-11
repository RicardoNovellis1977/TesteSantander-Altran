package com.ricardo.testesantander.model.DAOService

import com.google.gson.JsonParser
import com.ricardo.testesantander.helper.RetrofitConfig
import com.ricardo.testesantander.helper.Service
import com.ricardo.testesantander.helper.WebService
import com.ricardo.testesantander.model.UserLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DAOService(listener: WebService?) {

    private var listener: WebService? = listener
    private var call: Call<UserLogin>? = null
    val serviceUser = RetrofitConfig().getRetrofit().create(Service::class.java)

    fun callService(user: String, password: String) {

        call = serviceUser!!.validateUser(user , password)

        call?.enqueue(object : Callback<UserLogin> {
            override fun onFailure(call: Call<UserLogin>, t: Throwable) {
                listener?.erro(t)
            }

            override fun onResponse(call: Call<UserLogin>, response: Response<UserLogin>) {

                if (response.isSuccessful) {
                    listener?.success(response.body())
                    
                }
            }

        })
    }
}