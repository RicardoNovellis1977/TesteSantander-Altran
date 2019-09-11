package com.ricardo.testesantander.helper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitConfig {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://bank-app-test.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}