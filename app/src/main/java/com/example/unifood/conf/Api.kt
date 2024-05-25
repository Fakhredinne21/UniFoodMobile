package com.example.unifood.conf

import com.example.unifood.model.Meal
import retrofit2.http.GET

interface Api {
    @GET("Meals")
    suspend fun getMeals(): List<Meal>
    companion object {
        const val BASE_URL = "http://192.168.1.12:8080"
    }
}