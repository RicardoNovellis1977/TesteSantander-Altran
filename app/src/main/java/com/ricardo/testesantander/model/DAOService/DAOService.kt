package com.ricardo.testesantander.model.DAOService

import com.ricardo.testesantander.helper.RetrofitConfig
import com.ricardo.testesantander.helper.Service
import com.ricardo.testesantander.helper.WebService
import com.ricardo.testesantander.model.UserAccountParse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DAOService(listener: WebService?) {

    private var listener: WebService? = listener
    private var call: Call<UserAccountParse>? = null
    val serviceUser = RetrofitConfig().getRetrofitUser().create(Service::class.java)

    fun callService(user: String, password: String) {

        call = serviceUser!!.validateUser(user, password)

        call?.enqueue(object : Callback<UserAccountParse> {
            override fun onFailure(call: Call<UserAccountParse>, t: Throwable) {
                listener?.erro(t)
            }

            override fun onResponse(call: Call<UserAccountParse>, response: Response<UserAccountParse>) {

                if (response.isSuccessful) {
                    listener?.success(response.body())
                }
            }
        })
    }
}