package com.example.unifood.conf

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


object RetrofitInstance {
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply{
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        private val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    public val api: Api= retrofit2.Retrofit.Builder().addConverterFactory(
        retrofit2.converter.gson.GsonConverterFactory.create())
        .baseUrl(Api.BASE_URL)
        .client(client)
        .build()
        .create(Api::class.java
    )



}

