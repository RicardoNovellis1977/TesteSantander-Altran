package com.ricardo.testesantander.model.DAOService

import com.ricardo.testesantander.helper.RetrofitConfig
import com.ricardo.testesantander.helper.Service
import com.ricardo.testesantander.helper.WebServiceDatail
import com.ricardo.testesantander.model.Launches
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DAOServiceDetail(listener: WebServiceDatail?) {

    private var listener: WebServiceDatail? = listener
    private var call: Call<Launches>? = null
    val serviceUser = RetrofitConfig().getRetrofitUser().create(Service::class.java)

    fun callService(idUser : Int) {

        call = serviceUser!!.getDatail(idUser)

        call?.enqueue(object : Callback<Launches> {
            override fun onFailure(call: Call<Launches>, t: Throwable) {
                listener?.erro(t)

            }

            override fun onResponse(call: Call<Launches>, response: Response<Launches>) {

                if (response.isSuccessful) {
                    listener?.success(response.body())

                }
            }

        })
    }
}